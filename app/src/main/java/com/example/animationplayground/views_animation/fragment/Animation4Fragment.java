package com.example.animationplayground.views_animation.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentAnimation4Binding;


public class Animation4Fragment extends Fragment {

    private FragmentAnimation4Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnimation4Binding.inflate(inflater, container, false);
        binding.accelerateButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.decelerateButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.linearButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new LinearInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.shootButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new OvershootInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.accDecButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.anticipateButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AnticipateInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.anticipateShootButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AnticipateOvershootInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.bounceButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new BounceInterpolator());
            binding.imageView.startAnimation(translateAnimation);
        });

        binding.cycleButton.setOnClickListener(v -> {
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 1600f);
            translateAnimation.setDuration(3000L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new CycleInterpolator(5f));
            binding.imageView.startAnimation(translateAnimation);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}