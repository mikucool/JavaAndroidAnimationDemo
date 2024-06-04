package com.example.animationplayground.fragment;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Animation5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Animation5Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentAnimation5Binding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Animation5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Animation5Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Animation5Fragment newInstance(String param1, String param2) {
        Animation5Fragment fragment = new Animation5Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnimation5Binding.inflate(inflater, container, false);
        // create a animation set
        AnimationSet pressAnimationSet = getPressAnimationSet();
        AnimationSet releaseAnimationSet = getReleaseAnimationSet();
        // set click listener
        binding.view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
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
            }
        });
        return binding.getRoot();
    }

    @NonNull
    private static AnimationSet getPressAnimationSet() {
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
    private AnimationSet getReleaseAnimationSet() {
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