package com.ashwinrao.appskeleton.view.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwinrao.appskeleton.R;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.databinding.FragmentAddBinding;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModel;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModelFactory;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class AddItemFragment extends Fragment {

    private ItemViewModel mItemViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ItemViewModelFactory factory = ItemViewModelFactory.getInstance(Objects.requireNonNull(getActivity()).getApplication());
        mItemViewModel  = factory.create(ItemViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final FragmentAddBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false);
        binding.saveItemAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemViewModel.saveItem(new Item(binding.itemNameInput.getText().toString(), binding.itemLocationInput.getText().toString()));
                MainActivity.popBackStack();
            }
        });

        return binding.getRoot();
    }
}
