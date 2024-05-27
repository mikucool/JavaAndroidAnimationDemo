package com.example.animationplayground.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.animationplayground.adapter.DemoAdapter;
import com.example.animationplayground.R;
import com.example.animationplayground.databinding.FragmentDemosBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemosFragment extends Fragment {
    private FragmentDemosBinding binding;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DemosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DemosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DemosFragment newInstance(String param1, String param2) {
        DemosFragment fragment = new DemosFragment();
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