package com.azapps.cis_intermediate_task.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.azapps.cis_intermediate_task.R;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView foodImageView;
    TextView nameTV, priceTV, offerPriceTv, ratingTV;
    CardView cardView;
    OnFoodItemClick listener;

    public ItemViewHolder(@NonNull View itemView, OnFoodItemClick onFoodItemClick) {
        super(itemView);
        foodImageView = itemView.findViewById(R.id.item_img);
        nameTV = itemView.findViewById(R.id.item_name);
        priceTV = itemView.findViewById(R.id.item_price);
        offerPriceTv = itemView.findViewById(R.id.item_offer_price);
        ratingTV = itemView.findViewById(R.id.item_rating_text);
        cardView = itemView.findViewById(R.id.root_view);

        cardView.setOnClickListener(this);
        listener = onFoodItemClick;
    }

    @Override
    public void onClick(View view) {
        listener.onFoodClick(getAdapterPosition());
    }
}
