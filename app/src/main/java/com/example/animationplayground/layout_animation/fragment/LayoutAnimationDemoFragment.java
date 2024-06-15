package com.example.animationplayground.layout_animation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentLayoutAnimationDemoBinding;
import com.example.animationplayground.layout_animation.adpter.LayoutAnimationAdapter;

public class LayoutAnimationDemoFragment extends Fragment implements View.OnClickListener {
    private FragmentLayoutAnimationDemoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLayoutAnimationDemoBinding.inflate(inflater, container, false);
        binding.fadeInButton.setOnClickListener(this);
        binding.fadeInLeftButton.setOnClickListener(this);
        binding.rotateButton.setOnClickListener(this);
        binding.recyclerView.setAdapter(new LayoutAnimationAdapter());
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v == null) return;
        if (v.getId() == binding.fadeInButton.getId()) {
            LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation_fade_in);
            startAnimation(layoutAnimationController);
        } else if (v.getId() == binding.fadeInLeftButton.getId()) {
            LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation_fade_in_left);
            startAnimation(layoutAnimationController);
        } else if (v.getId() == binding.rotateButton.getId()) {
            LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation_rotation);
            startAnimation(layoutAnimationController);
        }
    }

    private void startAnimation(LayoutAnimationController animationController) {
        binding.recyclerView.clearAnimation();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setLayoutAnimation(animationController);
    }
}
