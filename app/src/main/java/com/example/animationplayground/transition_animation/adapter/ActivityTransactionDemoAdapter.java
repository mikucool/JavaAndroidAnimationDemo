package com.example.animationplayground.transition_animation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.animationplayground.R;
import com.example.animationplayground.transition_animation.bean.Scenery;
import com.example.animationplayground.transition_animation.data.SceneryRepository;
import com.example.animationplayground.transition_animation.views.SquareImageView;

import java.util.List;

public class ActivityTransactionDemoAdapter extends RecyclerView.Adapter<ActivityTransactionDemoAdapter.SceneryViewHolder> {
    private final Context context;
    private final List<Scenery> sceneryList;
    private OnItemClickListener onItemClickListener;

    public ActivityTransactionDemoAdapter(Context context, List<Scenery> sceneryList) {
        this.context = context;
        this.sceneryList = sceneryList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public SceneryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_activity_transaction_item, parent, false);
        return new SceneryViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull SceneryViewHolder holder, int position) {
        Scenery scenery = sceneryList.get(position);
        Glide.with(context).load(scenery.getImageUrl()).into(holder.squareImageView);
        holder.textView.setText(scenery.getSceneryName());
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                int layoutPosition = holder.getLayoutPosition();
                onItemClickListener.onItemClick(v, layoutPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return SceneryRepository.getScenerys().size();
    }

    static class SceneryViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        SquareImageView squareImageView;

        public SceneryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sceneryTitle);
            squareImageView = itemView.findViewById(R.id.sceneryImageView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);

    }

}
