package com.example.animationplayground.frame_animation.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentFrameAnimationDemoBinding;

public class FrameAnimationDemoFragment extends Fragment {
    FragmentFrameAnimationDemoBinding binding;
    private boolean isStarted = false;

    public FrameAnimationDemoFragment() {
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFrameAnimationDemoBinding.inflate(inflater, container, false);
        binding.image.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) binding.image.getBackground();
        binding.startButton.setOnClickListener(v -> {
            if (isStarted) {
                // stop
                binding.startButton.setText("stop");
                animationDrawable.stop();
            } else {
                // start
                binding.startButton.setText("start");
                animationDrawable.start();
            }
            isStarted = !isStarted;

        });
        return binding.getRoot();
    }
}
