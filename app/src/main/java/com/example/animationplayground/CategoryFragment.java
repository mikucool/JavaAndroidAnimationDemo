package com.example.animationplayground;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.animationplayground.canvas.CanvasFragment;
import com.example.animationplayground.databinding.FragmentCategoryBinding;
import com.example.animationplayground.frame_animation.FrameAnimationFragment;
import com.example.animationplayground.layout_animation.LayoutFragment;
import com.example.animationplayground.properties_animation.PropertiesAnimationFragment;
import com.example.animationplayground.views_animation.ViewsAnimationFragment;

public class CategoryFragment extends Fragment implements View.OnClickListener {
    private FragmentCategoryBinding binding;
    private int containerId;

    public CategoryFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            containerId = container.getId();
        }
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        binding.viewsAnimationButton.setOnClickListener(this);
        binding.propertiesAnimationButton.setOnClickListener(this);
        binding.canvasButton.setOnClickListener(this);
        binding.frameAnimationButton.setOnClickListener(this);
        binding.layoutAnimationButton.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        if (containerId == 0) return;
        if (v == v.findViewById(R.id.views_animation_button)) {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerId, new ViewsAnimationFragment()).addToBackStack("").commit();
        } else if (v == v.findViewById(R.id.properties_animation_button)) {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerId, new PropertiesAnimationFragment()).addToBackStack("").commit();
        } else if (v == v.findViewById(R.id.canvas_button)) {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerId, new CanvasFragment()).addToBackStack("").commit();
        } else if (v == v.findViewById(R.id.frame_animation_button)) {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerId, new FrameAnimationFragment()).addToBackStack("").commit();
        } else if (v == v.findViewById(R.id.layout_animation_button)) {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerId, new LayoutFragment()).addToBackStack("").commit();
        }
    }
}