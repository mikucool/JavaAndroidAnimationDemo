package com.example.animationplayground.canvas.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.animationplayground.R;

public class CustomSelector extends LinearLayout {

    private static final float HEIGHT_WIDTH_RATIO = 2.0f / 3.0f;
    private final int ROW_HEIGHT = dp2px(64);
    private static final int ITEMS_PER_ROW = 3;
    private int[] drawableIds = {};
    private boolean isOpen;
    private IconSelectListener mListener;
    private final ImageView mSelectImageView;
    private final LinearLayout mIconsLinearlayout;
    private final LinearLayout mDialogSelectLinearlayout;

    public CustomSelector(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View mRootView = View.inflate(getContext(), R.layout.custom_selector, this);
        mSelectImageView = mRootView.findViewById(R.id.select_image_view);
        mIconsLinearlayout = mRootView.findViewById(R.id.icons_linearlayout);
        mDialogSelectLinearlayout = mRootView.findViewById(R.id.dialog_select_linearlayout);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int refactorHeight = (int) (width * HEIGHT_WIDTH_RATIO);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(refactorHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void initSelector(int[] drawableIds, IconSelectListener listener) {
        setDrawableIds(drawableIds);
        setIconSelectListener(listener);
        initDialog();
    }

    private void initDialog() {
        drawButton();
        drawDialog();
        displayDialog(false);

        mSelectImageView.setOnClickListener(v -> {
            rotateSelectImageView();
            displayDialog(!isOpen);
            if (isOpen) {
                if (mListener != null) {
                    mListener.onCancel();
                }
            } else {
                if (mListener != null) {
                    mListener.onOpen();
                }
            }
            isOpen = !isOpen;
        });
    }

    private Bitmap buttonBitmap;
    private Canvas buttonBitmapCanvas;
    private Paint buttonDrawPaint;

    private void drawButton() {
        int buttonSize = dp2px(50);
        float buttonRadius = (float) buttonSize / 2;
        if (buttonBitmap == null) {
            buttonBitmap = Bitmap.createBitmap(buttonSize, buttonSize, Bitmap.Config.ARGB_8888);
            buttonBitmapCanvas = new Canvas(buttonBitmap);
        }
        if (buttonDrawPaint == null) {
            buttonDrawPaint = new Paint();
            buttonDrawPaint.setStyle(Paint.Style.FILL);
            buttonDrawPaint.setAntiAlias(true);
            buttonDrawPaint.setColor(Color.parseColor("#419DFF"));
        }
        buttonBitmapCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        buttonBitmapCanvas.drawCircle(buttonRadius, buttonRadius, buttonRadius, buttonDrawPaint);
        mSelectImageView.setImageBitmap(buttonBitmap);
    }

    private Bitmap dialogBitmap;
    private Canvas dialogBitmapCanvas;
    private Paint dialogDrawPaint;

    private void drawDialog() {
        int triangleWidth = dp2px(25);
        int triangleHeight = dp2px(20);
        int itemRows = (int) Math.ceil((double) drawableIds.length / (ITEMS_PER_ROW * 1.0));
        int dialogWidth = 500;
        int dialogImageHeight = ROW_HEIGHT * itemRows;
        int dialogHeight = dialogImageHeight + triangleHeight;

        // put the icons into linearlayout
        for (int i = 0; i < itemRows; i++) {
            LinearLayout iconsLinearLayout = createIconsLayout(dialogWidth, i);
            this.mIconsLinearlayout.addView(iconsLinearLayout);
        }

        // draw appearance of the dialog
        if (dialogBitmap == null) {
            dialogBitmap = Bitmap.createBitmap(dialogWidth, dialogHeight, Bitmap.Config.ARGB_8888);
            dialogBitmapCanvas = new Canvas(dialogBitmap);
        }
        if (dialogDrawPaint == null) {
            dialogDrawPaint = new Paint();
            dialogDrawPaint.setStyle(Paint.Style.FILL);
            dialogDrawPaint.setAntiAlias(true);
            dialogDrawPaint.setColor(Color.WHITE);
            dialogDrawPaint.setAntiAlias(true);
            dialogDrawPaint.setShadowLayer(5f, 2f, 2f, Color.LTGRAY);
            dialogDrawPaint.setStrokeJoin(Paint.Join.ROUND);
            dialogDrawPaint.setStrokeCap(Paint.Cap.ROUND);
            dialogDrawPaint.setPathEffect(new CornerPathEffect(10f));
        }
        // drawing dialog shape by setting background
        int leftX = 0;
        int leftY = 0;
        int centerX = dialogWidth / 2;
        Path path = new Path();
        path.moveTo(leftX * 1.0f, leftY * 1.0f);
        path.lineTo(dialogWidth * 1.0f, leftY * 1.0f);
        path.lineTo(dialogWidth * 1.0f, dialogImageHeight * 1.0f);
        path.lineTo((centerX + triangleWidth) * 1.0f, dialogImageHeight * 1.0f);
        path.lineTo(centerX * 1.0f, dialogHeight * 1.0f);
        path.lineTo((centerX - triangleWidth) * 1.0f, dialogImageHeight * 1.0f);
        path.lineTo(leftX * 1.0f, dialogImageHeight * 1.0f);
        path.close();
        dialogBitmapCanvas.drawPath(path, dialogDrawPaint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), dialogBitmap);
        this.mDialogSelectLinearlayout.setBackground(bitmapDrawable);
    }

    @NonNull
    private LinearLayout createIconsLayout(int dialogWidth, int i) {
        LinearLayout iconsLinearLayout = new LinearLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(0, dialogWidth / 6, 1f);
        for (int j = 0; j < ITEMS_PER_ROW; j++) {
            int index = i * ITEMS_PER_ROW + j;
            if (index < drawableIds.length) {
                ImageView iconImageView = new ImageView(getContext());
                iconImageView.setImageResource(drawableIds[index]);
                iconImageView.setLayoutParams(layoutParams);
                iconImageView.setOnClickListener(v -> {
                    if (mListener != null) {
                        mListener.onSelected(index);
                    }
                    dismissDialog();
                });
                iconsLinearLayout.addView(iconImageView);
            }

        }
        return iconsLinearLayout;
    }

    private void displayDialog(boolean isDisplay) {
        float fromScale = 0f;
        float toScale = 1.0f;
        if (isDisplay) {
            this.mDialogSelectLinearlayout.setVisibility(View.VISIBLE);
            this.mDialogSelectLinearlayout.bringToFront();
        } else {
            fromScale = 1.0f;
            toScale = 0f;
            this.mDialogSelectLinearlayout.setVisibility(View.GONE);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                fromScale, toScale,
                fromScale, toScale,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        scaleAnimation.setDuration(300);
        this.mDialogSelectLinearlayout.startAnimation(scaleAnimation);
    }

    private void rotateSelectImageView() {
        float from;
        float to;
        if (isOpen) {
            from = -45f;
            to = 0f;
        } else {
            from = 0f;
            to = 45f;
        }

        RotateAnimation rotateAnimation = new RotateAnimation(
                from,
                to,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        mSelectImageView.startAnimation(rotateAnimation);
    }

    private void dismissDialog() {
        isOpen = false;
        rotateSelectImageView();
        displayDialog(isOpen);
    }

    private void setIconSelectListener(IconSelectListener listener) {
        this.mListener = listener;
    }

    public void setDrawableIds(int[] drawableIds) {
        this.drawableIds = drawableIds;
    }

    private int dp2px(float dp) {
        // calculates dp to px
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public interface IconSelectListener {
        void onOpen();

        void onSelected(int position);

        void onCancel();
    }

}
