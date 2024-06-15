package com.example.animationplayground.layout_animation.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationplayground.R;

import java.util.ArrayList;
import java.util.List;

public class LayoutAnimationAdapter extends RecyclerView.Adapter<LayoutAnimationAdapter.LayoutAnimationViewHolder> {

    private static List<String> dataSet = createLayoutAnimationData();

    private static List<String> createLayoutAnimationData() {
        List<String> list = new ArrayList<>(26);
        char value = 'A';
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf(value++));
        }
        return list;
    }

    @NonNull
    @Override
    public LayoutAnimationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_animation, parent, false);
        return new LayoutAnimationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutAnimationAdapter.LayoutAnimationViewHolder holder, int position) {
        holder.button.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    static class LayoutAnimationViewHolder extends RecyclerView.ViewHolder {
        private final Button button;

        public LayoutAnimationViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_item);
        }
    }
}
