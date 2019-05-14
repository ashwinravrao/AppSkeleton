package com.ashwinrao.appskeleton.view.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwinrao.appskeleton.AppSkeleton;
import com.ashwinrao.appskeleton.R;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.databinding.FragmentAddBinding;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import javax.inject.Inject;

public class AddItemFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory factory;

    private ItemViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppSkeleton) Objects.requireNonNull(getActivity()).getApplication())
                .getAppComponent()
                .inject(this);

        viewModel = ViewModelProviders.of(getActivity(), factory).get(ItemViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final FragmentAddBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false);
        binding.saveItemAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.saveItem(new Item(binding.itemNameInput.getText().toString(), binding.itemLocationInput.getText().toString()));
                MainActivity.popBackStack();
            }
        });

        return binding.getRoot();
    }
}
