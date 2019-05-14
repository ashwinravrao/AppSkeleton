package com.ashwinrao.appskeleton.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwinrao.appskeleton.AppSkeleton;
import com.ashwinrao.appskeleton.R;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.databinding.FragmentListBinding;
import com.ashwinrao.appskeleton.view.adapter.ItemListAdapter;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

public class ItemListFragment extends Fragment {

    private Context mContext;
    private ItemListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LiveData<List<Item>> mItems;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();

        ((AppSkeleton) Objects.requireNonNull(getActivity()).getApplication())
                .getAppComponent()
                .inject(this);

        final ItemViewModel viewModel = ViewModelProviders.of(getActivity(), factory).get(ItemViewModel.class);
        mItems = viewModel.getItems();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        mRecyclerView = binding.recyclerview;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ItemListAdapter(mContext, mItems.getValue());
        mRecyclerView.setAdapter(mAdapter);

        mItems.observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                if(items != null) { mAdapter.setItems(items); }
                else { mAdapter.setItems(new ArrayList<Item>()); }
                mRecyclerView.setAdapter(mAdapter);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.doFragmentTransaction(new AddItemFragment());
            }
        });

        return binding.getRoot();
    }

}
