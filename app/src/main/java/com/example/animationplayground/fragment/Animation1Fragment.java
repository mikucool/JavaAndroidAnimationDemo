package com.example.animationplayground.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentAnimation1Binding;


public class Animation1Fragment extends Fragment {

    private FragmentAnimation1Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnimation1Binding.inflate(inflater, container, false);
        binding.alphaButton.setOnClickListener(view -> {
            binding.imageView.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.alpha));
        });

        binding.rotateButton.setOnClickListener(view -> {
            binding.imageView.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.rotate));
        });

        binding.scaleButton.setOnClickListener(view -> {
            binding.imageView.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.scale));
        });

        binding.translateButton.setOnClickListener(view -> {
            binding.imageView.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.translate));
        });

        return binding.getRoot();
    }
}