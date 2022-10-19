package com.bcis.chamena.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bcis.chamena.R;
import com.bcis.chamena.databinding.FoodItemBinding;
import com.bcis.chamena.model.Product;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {
    List<Product> items;
    Context context;
    public FoodItemAdapter(List<Product> items,Context context){
      this.items=items;
      this.context=context;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodItemBinding binding= FoodItemBinding.bind(View.inflate(parent.getContext(), R.layout.food_item,null));
        return new FoodItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
       holder.binding.price.setText("Rs "+items.get(position).price.toString());
       holder.binding.productname.setText(items.get(position).productName);
        Glide.with(context).load(items.get(position).productUrl).into(holder.binding.productImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FoodItemViewHolder extends RecyclerView.ViewHolder{
        FoodItemBinding binding;
        public FoodItemViewHolder(@NonNull FoodItemBinding itemView) {
            super(itemView.getRoot());
           binding=itemView;
        }
    }
    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
