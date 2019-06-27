package com.demo.crosswordnewcreate;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.GridLayout;

public class ZoomableGridLayout extends GridLayout {

    float mScaleFactor = 1;

    float mPivotX;

    float mPivotY;

    public ZoomableGridLayout(Context context) {
        super(context);
    }

    public ZoomableGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoomableGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ZoomableGridLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void dispatchDraw(Canvas canvas){

        canvas.save();

        canvas.scale(mScaleFactor, mScaleFactor, mPivotX, mPivotY);

        super.dispatchDraw(canvas);

        canvas.restore();

    }

    public void scale(float mScaleFactor, float mPivotX, float mPivotY){

        this.mScaleFactor = mScaleFactor;

        this.mPivotX = mPivotX;

        this.mPivotY = mPivotY;

        this.invalidate();

    }

    public void restore(){
        mScaleFactor = 1;
        this.invalidate();
    }

}
