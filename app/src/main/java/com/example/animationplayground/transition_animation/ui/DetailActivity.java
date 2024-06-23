package com.example.animationplayground.transition_animation.ui;

import static com.example.animationplayground.transition_animation.ui.TransitionOriginFragment.ARG_SCENERY_ID;
import static com.example.animationplayground.transition_animation.ui.TransitionOriginFragment.TRANSITION_SCENERY_IMAGE_NAME;
import static com.example.animationplayground.transition_animation.ui.TransitionOriginFragment.TRANSITION_SCENERY_TITLE_NAME;

import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.bumptech.glide.Glide;
import com.example.animationplayground.databinding.ActivityDetailBinding;
import com.example.animationplayground.transition_animation.bean.Scenery;
import com.example.animationplayground.transition_animation.data.SceneryRepository;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private Scenery scenery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int sceneryId = getIntent().getIntExtra(ARG_SCENERY_ID, 0);
        scenery = SceneryRepository.getSceneryById(sceneryId);
        ViewCompat.setTransitionName(binding.sceneryImageView, TRANSITION_SCENERY_IMAGE_NAME);
        ViewCompat.setTransitionName(binding.sceneryTitle, TRANSITION_SCENERY_TITLE_NAME);
        loadData();
    }

    private void loadData() {
        binding.sceneryTitle.setText(scenery.getSceneryName());
        binding.sceneryDesc.setText(scenery.getDescription());
        // add transition listener
        addTransitionListener();
        loadFullSizeImage();
    }

    private void loadThumbnail() {
        Glide.with(binding.sceneryImageView.getContext()).load(scenery.getThumbUrl()).into(binding.sceneryImageView);
    }

    private void loadFullSizeImage() {
        Glide.with(binding.sceneryImageView.getContext()).load(scenery.getImageUrl()).into(binding.sceneryImageView);
    }


    private void addTransitionListener() {
        Transition sharedElementEnterTransition = this.getWindow().getSharedElementEnterTransition();
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
