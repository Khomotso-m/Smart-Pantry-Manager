package com.khomotso.smartpantrymanager;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khomotso.smartpantrymanager.data.PantryItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.PantryViewHolder> {

    public interface OnItemLongClickListener {
        void onItemLongClick(PantryItem item);
    }

    public interface OnItemClickListener {
        void onItemClick(PantryItem item);
    }

    private List<PantryItem> items = new ArrayList<>();
    private OnItemLongClickListener longClickListener;
    private OnItemClickListener clickListener;

    public void setItems(List<PantryItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.longClickListener = listener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public PantryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);
        return new PantryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PantryViewHolder holder, int position) {
        PantryItem item = items.get(position);
//name and quantity of item
        holder.textName.setText(item.getName());
        holder.textQuantity.setText(item.getQuantity() + " " + item.getUnit());

        //expiry item details
        if (item.getExpiryDate() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            String dateStr = sdf.format(new Date(item.getExpiryDate()));
            holder.textExpiry.setText("Expires: " + dateStr);

            //calculating expiry days
            long now = System.currentTimeMillis();
            long diffMillis = item.getExpiryDate() - now;
            long daysLeft = TimeUnit.MILLISECONDS.toDays(diffMillis);

            if (daysLeft < 0) {
                holder.textExpiry.setTextColor(Color.parseColor("#D32F2F"));
                holder.textExpiry.append(" EXPIRED");
            } else if (daysLeft <= 3) {
                //warning expire soon
                holder.textExpiry.setTextColor(Color.parseColor("#F57C00"));
                holder.textExpiry.append("!" + daysLeft + " day(s) left");
            } else {
                holder.textExpiry.setTextColor(Color.parseColor("#666666"));
            }
        } else {
            //no expiry date
            holder.textExpiry.setText("No expiry date");
            holder.textExpiry.setTextColor(Color.parseColor("#666666"));
        }
        //tap listener (edit)
        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onItemClick(item);
            }
        });

        //long-press listener (delete)
        holder.itemView.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                longClickListener.onItemLongClick(item);
                return true;
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class PantryViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textQuantity;
        TextView textExpiry;

        PantryViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textQuantity = itemView.findViewById(R.id.textQuantity);
            textExpiry = itemView.findViewById(R.id.textExpiry);
        }
    }
}