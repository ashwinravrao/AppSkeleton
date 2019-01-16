package com.ashwinrao.appskeleton.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwinrao.appskeleton.R;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.databinding.FragmentListBinding;
import com.ashwinrao.appskeleton.view.adapter.ItemListAdapter;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModel;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModelFactory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListFragment extends Fragment {

    private Context mContext;
    private ItemListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LiveData<List<Item>> mItems;
    private ItemViewModel mItemViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        ItemViewModelFactory factory = ItemViewModelFactory.getInstance(((FragmentActivity) mContext).getApplication());
        mItemViewModel = factory.create(ItemViewModel.class);
        mItems = mItemViewModel.getItems();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        mRecyclerView = binding.recyclerview;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ItemListAdapter(getActivity());

        mItems.observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                mAdapter.setItems(items);
                mRecyclerView.setAdapter(mAdapter);
            }
        });
        return binding.getRoot();
    }

}
