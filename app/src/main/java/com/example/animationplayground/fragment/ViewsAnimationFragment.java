package com.example.animationplayground.fragment;

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
import com.example.animationplayground.databinding.FragmentDemosBinding;

public class ViewsAnimationFragment extends Fragment {
    private FragmentDemosBinding binding;
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
        binding = FragmentDemosBinding.inflate(inflater, container, false);
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
        }));
        return binding.getRoot();
    }
}