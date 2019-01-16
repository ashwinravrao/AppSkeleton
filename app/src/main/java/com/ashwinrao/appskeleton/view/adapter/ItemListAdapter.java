package com.ashwinrao.appskeleton.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwinrao.appskeleton.R;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.databinding.ViewholderBinding;
import com.ashwinrao.appskeleton.view.ui.DetailEditFragment;
import com.ashwinrao.appskeleton.view.ui.MainActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private Context mContext;
    private List<Item> mItems;

    public ItemListAdapter(Context context, List<Item> items) {
        mContext = context;
        mItems = items;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.viewholder, parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.binding.setItem(item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ViewholderBinding binding;

        public ItemViewHolder(@NonNull ViewholderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            DetailEditFragment fragment = new DetailEditFragment();
            Bundle args = new Bundle();
            args.putInt("item", getAdapterPosition());
            fragment.setArguments(args);
            MainActivity.doFragmentTransaction(fragment);
        }
    }
}
