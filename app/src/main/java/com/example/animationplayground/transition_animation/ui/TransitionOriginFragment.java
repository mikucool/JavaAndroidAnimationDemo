package com.example.animationplayground.transition_animation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentTransitionOriginBinding;
import com.example.animationplayground.transition_animation.adapter.ActivityTransactionDemoAdapter;
import com.example.animationplayground.transition_animation.bean.Scenery;
import com.example.animationplayground.transition_animation.data.SceneryRepository;
import com.example.animationplayground.transition_animation.views.SquareImageView;

public class TransitionOriginFragment extends Fragment implements ActivityTransactionDemoAdapter.OnItemClickListener {
    public static String ARG_SCENERY_ID = "ARG_SCENERY_ID";

    public static String TRANSITION_SCENERY_IMAGE_NAME = "ARG_SCENERY_IMAGE_NAME";
    public static String TRANSITION_SCENERY_TITLE_NAME = "TRANSITION_SCENERY_TITLE_NAME";
    private FragmentTransitionOriginBinding binding;
    private static int TRANSITION_MODE = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTransitionOriginBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        ActivityTransactionDemoAdapter activityTransactionDemoAdapter = new ActivityTransactionDemoAdapter(requireContext(), SceneryRepository.getScenerys());
        activityTransactionDemoAdapter.setOnItemClickListener(this);
        binding.recyclerView.setAdapter(activityTransactionDemoAdapter);
        binding.activityTransitionButton.setEnabled(false);
        binding.activityTransitionButton.setOnClickListener(v -> {
            TRANSITION_MODE = 0;
            binding.activityTransitionButton.setEnabled(false);
            binding.fragmentTransitionButton.setEnabled(true);
            Toast.makeText(requireContext(), "Activity Transition Mode", Toast.LENGTH_SHORT).show();
        });
        binding.fragmentTransitionButton.setOnClickListener(v -> {
            TRANSITION_MODE = 1;
            binding.fragmentTransitionButton.setEnabled(false);
            binding.activityTransitionButton.setEnabled(true);
            Toast.makeText(requireContext(), "Fragment Transition Mode", Toast.LENGTH_SHORT).show();

        });
        return binding.getRoot();

    }


    @Override
    public void onItemClick(View v, int position) {
        SquareImageView imageView = v.findViewById(R.id.sceneryImageView);
        TextView title = v.findViewById(R.id.sceneryTitle);
        if (imageView == null || title == null) return;
        //將imageView、title 設定Transition Name，這裡的Transition Name會與DetailActivity一樣
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(),
                new Pair<>(imageView, TRANSITION_SCENERY_IMAGE_NAME),
                new Pair<>(title, TRANSITION_SCENERY_TITLE_NAME)
        );
        if (TRANSITION_MODE == 0) {
            activityModeItemClick(position, activityOptions.toBundle());
        } else {
            Toast.makeText(requireContext(), "Oops!, this feature have no implementation yet", Toast.LENGTH_SHORT).show();
            // TODO implementing fragment transition animation
            // remove existed shared elements and create new ones for fragment screen
//            fragmentModeItemClick(position, Objects.requireNonNull(activityOptions.toBundle()));
        }
    }

    private void activityModeItemClick(int position, Bundle bundle) {
        Scenery scenery = SceneryRepository.getScenerys().get(position);
        Intent intent = new Intent(requireContext(), DetailActivity.class);
        intent.putExtra(ARG_SCENERY_ID, scenery.getSceneryId());
        startActivity(intent, bundle);
    }

    private void fragmentModeItemClick(int position, Bundle bundle) {
        if (bundle == null) bundle = new Bundle();
        Scenery scenery = SceneryRepository.getScenerys().get(position);
        bundle.putInt(ARG_SCENERY_ID, scenery.getSceneryId());
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_layout, detailFragment)
                .addToBackStack("DetailFragment")
                .commit();
    }
}
