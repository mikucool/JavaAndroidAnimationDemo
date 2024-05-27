package com.example.animationplayground.adapter;

import static com.example.animationplayground.Const.FRAGMENT_MAP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationplayground.R;

import java.util.ArrayList;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    private static final List<String> list = new ArrayList<>();

    static {
        list.addAll(FRAGMENT_MAP.keySet());
    }

    private final Callback callback;

    public DemoAdapter(Callback callback) {
        this.callback = callback;
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
        String demoName = list.get(position);
        holder.button.setText(demoName);
        holder.button.setOnClickListener(v -> callback.onClickedButton(FRAGMENT_MAP.get(demoName)));
    }

    @Override
    public int getItemCount() {
        return list.size();
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
