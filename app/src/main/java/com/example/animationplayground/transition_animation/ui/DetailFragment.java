package com.example.animationplayground.transition_animation.ui;

import static com.example.animationplayground.transition_animation.ui.TransitionOriginFragment.ARG_SCENERY_ID;

import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.animationplayground.databinding.FragmentDetailBinding;
import com.example.animationplayground.transition_animation.bean.Scenery;
import com.example.animationplayground.transition_animation.data.SceneryRepository;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private Scenery scenery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG", "onCreateView");
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        int sceneryId = this.getArguments().getInt(ARG_SCENERY_ID);
        scenery = SceneryRepository.getSceneryById(sceneryId);
        /*if (this.getArguments() == null) return binding.getRoot();
        int sceneryId = this.getArguments().getInt(ARG_SCENERY_ID);
        scenery = SceneryRepository.getSceneryById(sceneryId);
        ViewCompat.setTransitionName(binding.sceneryImageView, TRANSITION_SCENERY_IMAGE_NAME);
        ViewCompat.setTransitionName(binding.sceneryTitle, TRANSITION_SCENERY_TITLE_NAME);*/
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("TAG", "onViewCreated" + getArguments());
        loadData();
    }

    private void loadData() {
        binding.sceneryTitle.setText(scenery.getSceneryName());
        binding.sceneryDesc.setText(scenery.getDescription());
        Log.e("TAG", scenery.getSceneryName() + " " + scenery.getDescription());
        // add transition listener
//        addTransitionListener();
        loadFullSizeImage();
    }

    private void loadFullSizeImage() {
        Glide.with(binding.sceneryImageView.getContext()).load(scenery.getImageUrl()).into(binding.sceneryImageView);
    }


    private void addTransitionListener() {
        Transition sharedElementEnterTransition = requireActivity().getWindow().getSharedElementEnterTransition();
        if (sharedElementEnterTransition != null) {
            sharedElementEnterTransition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    Log.e("TAG", "onTransitionEnd: ");
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionCancel(Transition transition) {
                    Log.e("TAG", "onTransitionCancel: ");
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }

            });
        }
    }

}
