package com.example.animationplayground.canvas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.R;
import com.example.animationplayground.canvas.views.CustomSelector;
import com.example.animationplayground.databinding.FragmentCustomSelectorBinding;

public class CustomSelectorFragment extends Fragment {
    private FragmentCustomSelectorBinding binding;
    public CustomSelectorFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCustomSelectorBinding.inflate(inflater, container, false);
        int[] icons = {R.drawable.baseline_cloud_upload_24, R.drawable.baseline_home_24, R.drawable.baseline_manage_accounts_24};
        CustomSelector.IconSelectListener iconSelectListener = new CustomSelector.IconSelectListener() {
            @Override
            public void onOpen() {
            }
            @Override
            public void onSelected(int position) {
            }
            @Override
            public void onCancel() {
            }
        };
        binding.customSelector.initSelector(icons, iconSelectListener);
        return binding.getRoot();
    }

}
