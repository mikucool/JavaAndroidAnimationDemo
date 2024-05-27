package com.example.animationplayground.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.example.animationplayground.databinding.FragmentAnimation3Binding;

public class Animation3Fragment extends Fragment {
    private FragmentAnimation3Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnimation3Binding.inflate(inflater, container, false);
        binding.animationSetButton.setOnClickListener(view -> {
            // 创建动画组合
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            // 第一个动画
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, .2f);
            alphaAnimation.setDuration(2000L);
            // 第二个动画，同时设置重复效果
            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 100f, 0f, -100f);
            translateAnimation.setDuration(2000L);
            translateAnimation.setRepeatMode(Animation.REVERSE);
            translateAnimation.setRepeatCount(Animation.INFINITE);
            // 加入集合
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            // 动画！启动！
            binding.imageView.startAnimation(animationSet);
        });

        binding.scaleButton.setOnClickListener(view -> {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1f, .2f);
            alphaAnimation.setRepeatCount(1);
            alphaAnimation.setDuration(5000L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    Toast.makeText(requireContext(), "animation start", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(requireContext(), "animation end", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    Toast.makeText(requireContext(), "animation repeat", Toast.LENGTH_SHORT).show();
                }
            });
            binding.imageView.startAnimation(alphaAnimation);

        });
        return binding.getRoot();
    }
}