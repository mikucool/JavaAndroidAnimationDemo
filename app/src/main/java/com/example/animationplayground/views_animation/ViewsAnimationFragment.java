package com.example.animationplayground.views_animation;

import static com.example.animationplayground.Const.MAP_LIST;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.animationplayground.R;
import com.example.animationplayground.adapter.DemoAdapter;
import com.example.animationplayground.databinding.FragmentViewsAnimationBinding;

public class ViewsAnimationFragment extends Fragment {
    private FragmentViewsAnimationBinding binding;

    public ViewsAnimationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewsAnimationBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(new DemoAdapter(fragmentName -> {
            try {
                Class<?> cls = Class.forName(fragmentName);
                Fragment fragment = (Fragment) cls.newInstance();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_layout, fragment)
                        .addToBackStack(fragmentName)
                        .commit();
            } catch (Exception e) {
                Toast.makeText(requireContext(), "Fragment Is Not Found", Toast.LENGTH_SHORT).show();
            }
        }, MAP_LIST.get(0)));
        return binding.getRoot();
    }
}