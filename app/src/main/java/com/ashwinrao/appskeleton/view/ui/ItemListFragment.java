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

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListFragment extends Fragment {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private ItemListAdapter mAdapter;
    private LiveData<List<Item>> mItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();

        // Get viewmodel object using factory

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);

        mRecyclerView = binding.recyclerview;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ItemListAdapter(getActivity());

        // observe LiveData<List<Item>>, update UI on change

        return binding.getRoot();

    }

    private void updateUI(List<Item> items) {
        mAdapter.setItems(items);
        mRecyclerView.setAdapter(mAdapter);
    }

}
