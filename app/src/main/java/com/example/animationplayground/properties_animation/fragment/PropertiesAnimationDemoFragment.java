package com.example.animationplayground.properties_animation.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentPropertiesAnimationDemoFragmentBinding;

public class PropertiesAnimationDemoFragment extends Fragment implements View.OnClickListener {
    private FragmentPropertiesAnimationDemoFragmentBinding binding;

    public PropertiesAnimationDemoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPropertiesAnimationDemoFragmentBinding.inflate(inflater, container, false);
        binding.xButton.setOnClickListener(this);
        binding.zRotationButton.setOnClickListener(this);
        binding.backgroundColorButton.setOnClickListener(this);
        binding.alphaButton.setOnClickListener(this);
        binding.scaleButton.setOnClickListener(this);
        binding.animationSetButton.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (binding == null) return;
        View animationView = binding.animationView;
        if (v.getId() == binding.xButton.getId()) {
            binding.animationView.clearAnimation();
            Animator animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.properties_animation_x_offset);
            animator.setTarget(animationView);
            animator.start();
        } else if (v.getId() == binding.zRotationButton.getId()) {
            binding.animationView.clearAnimation();
            Animator animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.properties_animation_z_rotate);
            animator.setTarget(animationView);
            animator.start();
        } else if (v.getId() == binding.backgroundColorButton.getId()) {
            binding.animationView.clearAnimation();
            Animator animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.properties_animation_background_color);
            animator.setTarget(animationView);
            animator.start();
        } else if (v.getId() == binding.alphaButton.getId()) {
            binding.animationView.clearAnimation();
            Animator animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.properties_animation_alpha);
            animator.setTarget(animationView);
            animator.start();
        } else if (v.getId() == binding.scaleButton.getId()) {
            binding.animationView.clearAnimation();
            Animator animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.properties_animation_scale);
            animator.setTarget(animationView);
            animator.start();
        } else if (v.getId() == binding.animationSetButton.getId()) {
            binding.animationView.clearAnimation();
            Animator animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.properties_animation_set);
            animator.setTarget(animationView);
            animator.start();
        }
    }
}
