package com.azapps.cis_intermediate_task.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.azapps.cis_intermediate_task.R;
import com.azapps.cis_intermediate_task.pojo.FoodItem;

public class ItemAdapter extends ListAdapter<FoodItem, ItemViewHolder> {
    public static final ItemDiffUtill CALLBACK = new ItemDiffUtill();
    OnFoodItemClick listener;

    protected ItemAdapter(OnFoodItemClick onFoodItemClick) {
        super(CALLBACK);
        listener = onFoodItemClick;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        FoodItem currentItem = getItem(position);
        holder.foodImageView.setImageResource(currentItem.getImgRes());
        holder.nameTV.setText(currentItem.getName());
        holder.priceTV.setText(currentItem.getPrice());
        if (currentItem.isHasOfferPrice()) {
            holder.offerPriceTv.setVisibility(View.VISIBLE);
            holder.offerPriceTv.setText(currentItem.getOfferPrice());
        }
        holder.ratingTV.setText(String.valueOf(currentItem.getRating()));
    }
}
