package com.example.animationplayground.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.databinding.FragmentAnimation5Binding;

public class Animation5Fragment extends Fragment {
    private FragmentAnimation5Binding binding;
    public Animation5Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnimation5Binding.inflate(inflater, container, false);
        // create a animation set
        AnimationSet pressAnimationSet = createPressAnimationSet();
        AnimationSet releaseAnimationSet = createReleaseAnimationSet();
        // set click listener
        binding.view1.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                binding.view1.clearAnimation();
                binding.view1.startAnimation(pressAnimationSet);
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                binding.view1.clearAnimation();
                binding.view1.startAnimation(releaseAnimationSet);
                return true;
            }
            return false;
        });

        return binding.getRoot();
    }

    @NonNull
    private static AnimationSet createPressAnimationSet() {
        AnimationSet animationSet = new AnimationSet(true);
        // create animation
        Animation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Animation rotateAnimation = new RotateAnimation(0, 30, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // set animation duration
        scaleAnimation.setDuration(200);
        rotateAnimation.setDuration(200);
        // add animation to animation set
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    @NonNull
    private AnimationSet createReleaseAnimationSet() {
        AnimationSet animationSet = new AnimationSet(true);
        // create animation
        Animation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Animation rotateAnimation = new RotateAnimation(30, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // set animation duration
        scaleAnimation.setDuration(200);
        rotateAnimation.setDuration(200);
        // add animation to animation set
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setFillAfter(true);
        return animationSet;
    }
}