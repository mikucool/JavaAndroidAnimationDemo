package com.example.animationplayground.properties_animation;

import static com.example.animationplayground.Const.MAP_LIST;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.animationplayground.R;
import com.example.animationplayground.adapter.DemoAdapter;
import com.example.animationplayground.databinding.FragmentPropertiesAnimationBinding;

import java.util.Map;

public class PropertiesAnimationFragment extends Fragment {

    private FragmentPropertiesAnimationBinding binding;

    public PropertiesAnimationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPropertiesAnimationBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        Map<String, String> map = MAP_LIST.get(1);
        if (map != null) {
            binding.recyclerView.setAdapter(new DemoAdapter(
                    fragmentName -> {
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
                    }, map));
        }

        return binding.getRoot();
    }
}
