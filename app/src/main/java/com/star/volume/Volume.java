package com.star.volume;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;


public class Volume extends View {

    private static final int OFFSET = 5;

    private double mWidth;
    private double mRectWidth;
    private double mRectHeight;

    private double mCurrentHeight;

    private int mRectCount;
    private Paint mPaint;

    private double mRandom;

    private LinearGradient mLinearGradient;

    public Volume(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);

        mRectCount = 12;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = mWidth * 0.6 / mRectCount;

        mLinearGradient = new LinearGradient(
                0,
                0,
                (float) mRectWidth,
                (float) mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP
        );

        mPaint.setShader(mLinearGradient);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {

            mRandom = Math.random();
            mCurrentHeight = mRectHeight * mRandom;

            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + OFFSET),
                    (float) mCurrentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1) + OFFSET),
                    (float) mRectHeight,
                    mPaint
            );
        }

        postInvalidateDelayed(300);
    }
}
