package com.example.animationplayground.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentAnimation2Binding;

public class Animation2Fragment extends Fragment {

    private FragmentAnimation2Binding binding;
    private float startAngel = 0f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnimation2Binding.inflate(inflater, container, false);

        binding.alphaButton.setOnClickListener(view -> {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
            alphaAnimation.setDuration(2000L);
            binding.imageView.startAnimation(alphaAnimation);
        });

        binding.rotateButton.setOnClickListener(view -> {
            RotateAnimation rotateAnimation = new RotateAnimation(startAngel, startAngel + 90,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(2000L);
            rotateAnimation.setFillAfter(true);
            binding.imageView.startAnimation(rotateAnimation);
            startAngel += 90f;
        });

        binding.scaleButton.setOnClickListener(view -> {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.5f,
                    1.0f, 1.5f, Animation.RELATIVE_TO_SELF, .4f, Animation.RELATIVE_TO_SELF, .7f);
            scaleAnimation.setDuration(2000L);
            scaleAnimation.setFillAfter(true);
            binding.imageView.startAnimation(scaleAnimation);
        });

        binding.translateButton.setOnClickListener(view -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 100f, 0f, 100f);
            translateAnimation.setDuration(2000L);
            translateAnimation.setFillAfter(true);
            binding.imageView.startAnimation(translateAnimation);
        });

        return binding.getRoot();
    }
}