package com.example.animationplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.animationplayground.databinding.ActivityMainBinding;
import com.example.animationplayground.views_animation.ViewsAnimationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.main_layout, new ViewsAnimationFragment()).commit();
    }
}