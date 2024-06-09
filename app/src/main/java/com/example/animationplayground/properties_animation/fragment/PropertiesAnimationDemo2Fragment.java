package com.example.animationplayground.properties_animation.fragment;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.databinding.FragmentPropertiesAnimationDemo2FragmentBinding;

public class PropertiesAnimationDemo2Fragment extends Fragment implements View.OnClickListener {
    private FragmentPropertiesAnimationDemo2FragmentBinding binding;

    public PropertiesAnimationDemo2Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPropertiesAnimationDemo2FragmentBinding.inflate(inflater, container, false);
        binding.zRotationButton.setOnClickListener(this);
        binding.alphaButton.setOnClickListener(this);
        binding.animationKeyFrameButton.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (binding == null) return;
        View animationView = binding.animationView;
        if (v.getId() == binding.zRotationButton.getId()) {
            binding.animationView.clearAnimation();
            ObjectAnimator animator = ObjectAnimator.ofFloat(animationView, "rotation", 0.0f, 270.0f);
            animator.setDuration(1000);
            animator.start();
        } else if (v.getId() == binding.alphaButton.getId()) {
            binding.animationView.clearAnimation();
            ValueAnimator animator = ValueAnimator.ofFloat(1.0f, 0.2f);
            animator.addUpdateListener(animation -> {
                animationView.setAlpha((float) animation.getAnimatedValue());
                animationView.requestLayout();
            });
            animator.setDuration(1000);
            animator.start();
        } else if (v.getId() == binding.animationKeyFrameButton.getId()) {
            binding.animationView.clearAnimation();
            /**
             * 第0，rotate:0
             * 第0.1，rotate -30
             * 第0.3，rotate 30
             * 第0.6，rotate -30
             * 第0.8，rotate 30
             * 最後1，rotate 0
             */
            Keyframe keyframe0 = Keyframe.ofFloat(0f, 0f);
            Keyframe keyframe1 = Keyframe.ofFloat(0.1f, -30f);
            Keyframe keyframe2 = Keyframe.ofFloat(0.3f, 30f);
            Keyframe keyframe3 = Keyframe.ofFloat(0.6f, -30f);
            Keyframe keyframe4 = Keyframe.ofFloat(1f, 0f);
            PropertyValuesHolder rotationValuesHolder = PropertyValuesHolder.ofKeyframe(
                    "rotation",
                    keyframe0, keyframe1, keyframe2, keyframe3, keyframe4
            );
            ValueAnimator animator = ObjectAnimator
                    .ofPropertyValuesHolder(animationView, rotationValuesHolder);
            animator.setDuration(1000);
            animator.start();
        }
    }
}
