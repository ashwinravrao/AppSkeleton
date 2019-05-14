package com.ashwinrao.appskeleton.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwinrao.appskeleton.AppSkeleton;
import com.ashwinrao.appskeleton.R;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.databinding.FragmentDetailEditBinding;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModel;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

public class DetailEditFragment extends Fragment {

    private int mItemIndex;
    private ItemViewModel viewModel;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mItemIndex = Objects.requireNonNull(args).getInt("item", 0);

        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity()), factory).get(ItemViewModel.class);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        ((AppSkeleton) context.getApplicationContext())
                .getAppComponent()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final FragmentDetailEditBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_edit, container, false);
        viewModel.getItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                binding.setItem(items.get(mItemIndex));
            }
        });
        return binding.getRoot();
    }
}
