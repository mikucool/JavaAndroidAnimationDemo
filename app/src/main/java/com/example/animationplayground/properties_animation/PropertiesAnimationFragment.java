package com.example.animationplayground.properties_animation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.databinding.FragmentPropertiesAnimationBinding;

public class PropertiesAnimationFragment extends Fragment {

    private FragmentPropertiesAnimationBinding binding;

    public PropertiesAnimationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPropertiesAnimationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
