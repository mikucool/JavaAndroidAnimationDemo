package com.example.animationplayground.canvas.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animationplayground.databinding.FragmentBasicShapeBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BasicShapeFragment extends Fragment implements View.OnClickListener {
    private FragmentBasicShapeBinding binding;
    private Bitmap imageBitmap;

    public BasicShapeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBasicShapeBinding.inflate(inflater, container, false);
        imageBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        binding.imageView.setImageBitmap(imageBitmap);
        binding.drawArcButton.setOnClickListener(this);
        binding.drawCircleButton.setOnClickListener(this);
        binding.drawOvalButton.setOnClickListener(this);
        binding.drawPointButton.setOnClickListener(this);
        binding.drawRectangleButton.setOnClickListener(this);
        binding.drawRoundedRectangleButton.setOnClickListener(this);
        binding.drawLineButton.setOnClickListener(this);
        binding.drawPathButton.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (binding == null) return;
        if (v.getId() == binding.drawArcButton.getId()) {
            drawArc();
        } else if (v.getId() == binding.drawCircleButton.getId()) {
            drawCircle();
        } else if (v.getId() == binding.drawOvalButton.getId()) {
            drawOval();
        } else if (v.getId() == binding.drawPointButton.getId()) {
            drawPoint();
        } else if (v.getId() == binding.drawRectangleButton.getId()) {
            drawRectangle();
        } else if (v.getId() == binding.drawRoundedRectangleButton.getId()) {
            drawRoundedRectangle();
        } else if (v.getId() == binding.drawLineButton.getId()) {
            drawLine();
        } else if (v.getId() == binding.drawPathButton.getId()) {
            drawPath();
        }
        // update view
        binding.imageView.invalidate();
    }

    private void drawPath() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        List<Float> points = new ArrayList<>();
        points.add(500f);
        points.add(300f);
        points.add(900f);
        points.add(1900f);
        points.add(800f);
        points.add(1200f);
        points.add(500f);
        points.add(1500f);
        points.add(1300f);
        points.add(600f);
        Path path = generateCubicBezierCurve(points, new Size(imageBitmap.getWidth(), imageBitmap.getHeight()));
        if (path == null) return;
        // 最后，绘制坐标系
        path.moveTo(0, 0);
        path.lineTo(0, imageBitmap.getHeight());
        path.lineTo(imageBitmap.getWidth(), imageBitmap.getHeight());
        canvas.drawPath(path, paint);
    }

    private void drawLine() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        canvas.drawLine(100f, 100f, 400f, 400f, paint);
    }

    private void drawRoundedRectangle() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        RectF rectF = new RectF(100f, 100f, 400f, 300f);
        canvas.drawRoundRect(rectF, 20f, 20f, paint);
    }

    private void drawRectangle() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        RectF rectF = new RectF(100f, 100f, 400f, 300f);
        canvas.drawRect(rectF, paint);
    }

    private void drawPoint() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(20f);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        Canvas canvas = new Canvas(imageBitmap);
        canvas.drawPoint(100f, 100f, paint);
        canvas.drawPoint(200f, 200f, paint);
        canvas.drawPoint(300f, 400f, paint);
    }

    private void drawOval() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        RectF rectF = new RectF(100f, 100f, 400f, 300f);
        canvas.drawOval(rectF, paint);
    }

    private void drawCircle() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        canvas.drawCircle(250f, 250f, 100f, paint);
    }

    private void drawArc() {
        imageBitmap.eraseColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(imageBitmap);
        RectF rectF = new RectF(100f, 100f, 400f, 400f);
        canvas.drawArc(rectF, 30f, 300f, true, paint);
    }

    @Nullable
    private Path generateCubicBezierCurve(@NonNull List<Float> points, Size size) {
        if (points.isEmpty()) return null;
        AtomicReference<Float> maxValue = new AtomicReference<>(0f);
        AtomicReference<Float> minValue = new AtomicReference<>(points.get(0));
        points.forEach(value -> {
            if (value > maxValue.get()) maxValue.set(value);
            if (value < minValue.get()) minValue.set(value);
        });
        float range = maxValue.get() - minValue.get();
        // 横坐标刻度
        int xCoordinateWidth = size.getWidth() / points.size() - 1;
        // value 乘积因子，用于计算 y 坐标
        float yCoordinateFactor = size.getHeight() / range;
        Path path = new Path();
        float previousX = 0f;
        float previousY = size.getHeight();
        for (int i = 0; i < points.size(); i++) {
            if (i == 0) {
                path.moveTo(0, (points.get(i) - minValue.get()) * yCoordinateFactor);
            }
            // 1. 计算 x 坐标
            float x = i * xCoordinateWidth;
            // 2. 计算 y 坐标
            float y = size.getHeight() - (points.get(i) - minValue.get()) * yCoordinateFactor;
            // 3. 计算控制点
            PointF controlPoint1 = new PointF((x + previousX) / 2, previousY);
            PointF controlPoint2 = new PointF((x + previousX) / 2, y);
            // 4. 三次贝塞尔曲线
            path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, x, y);
            previousX = x;
            previousY = y;

        }
        return path;
    }
}
