package com.example.animationplayground.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationplayground.R;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    private Map<String, String> titleMap;
    private final Callback callback;
    private final List<String> titleList;

    public DemoAdapter(Callback callback,Map<String, String> titleMap) {
        this.callback = callback;
        this.titleMap = titleMap;
        this.titleList = titleMap.keySet().stream().sorted().collect(Collectors.toList());
    }

    @NonNull
    @Override
    public DemoAdapter.DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new DemoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoAdapter.DemoViewHolder holder, int position) {
        String demoName = titleList.get(position);
        holder.button.setText(demoName);
        holder.button.setOnClickListener(v -> callback.onClickedButton(titleMap.get(demoName)));
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    static class DemoViewHolder extends RecyclerView.ViewHolder {
        private final Button button;

        public DemoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.button = itemView.findViewById(R.id.button_item);
        }
    }

    public interface Callback {
        void onClickedButton(String fragmentName);
    }
}
