package com.example.animationplayground.layout_animation.fragment;

import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentLayoutTransitionDemoBinding;

public class LayoutTransitionDemoFragment extends Fragment implements View.OnClickListener {
    private FragmentLayoutTransitionDemoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLayoutTransitionDemoBinding.inflate(inflater, container, false);
        binding.addButton.setOnClickListener(this);
        binding.removeButton.setOnClickListener(this);
        initTransition();
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v == null) return;
        if (v.getId() == binding.addButton.getId()) {
            addButtonView();
        } else if (v.getId() == binding.removeButton.getId()) {
            removeButtonView();
        }
    }

    @SuppressLint("SetTextI18n")
    private void addButtonView() {
        Button button = new Button(requireContext());
        int i = 0;
        button.setText("BUTTON" + i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        binding.resultLayout.addView(button, layoutParams);
    }

    private void removeButtonView() {
        if (binding.resultLayout.getChildCount() > 0) binding.resultLayout.removeViewAt(0);
    }

    private void initTransition() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(requireContext(), R.animator.anim_scale_x));
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, AnimatorInflater.loadAnimator(requireContext(), R.animator.anim_color));
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, AnimatorInflater.loadAnimator(requireContext(), R.animator.layout_change_appearing));
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, AnimatorInflater.loadAnimator(requireContext(), R.animator.layout_change_disappearing));
        binding.resultLayout.setLayoutTransition(layoutTransition);

    }

}
