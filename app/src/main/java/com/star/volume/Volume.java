package com.star.volume;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class Volume extends View {

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;

    private int mRectCount;
    private Paint mPaint;

    public Volume(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {
            canvas.drawRect(
                    0, 0, 0, 0, mPaint
            );
        }
    }
}
