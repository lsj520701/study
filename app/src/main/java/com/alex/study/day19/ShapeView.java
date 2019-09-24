package com.alex.study.day19;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.alex.study.R;

import androidx.annotation.Nullable;

public class ShapeView extends View {

    Paint mPaint;
    public ShapeView(Context context) {
        this(context,null);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private  int mWidth;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth=MeasureSpec.getSize(widthMeasureSpec);
        Log.i("shape","得到的寬度是:   +"+  mWidth);
        setMeasuredDimension(mWidth,mWidth);

    }

    private void init(){
        mPaint=new Paint();
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawShape(canvas);
    }

    private int type=1;
    int color= R.color.colorAccent;
    private void drawShape(Canvas canvas){

        switch (type){
            case 1:
                color=R.color.colorPrimary;
                mPaint.setColor(getContext().getResources().getColor(color));
                canvas.drawCircle(mWidth/2,mWidth/2,mWidth/2,mPaint);
                break;
            case 2:
                color=R.color.colorPrimaryDark;
                mPaint.setColor(getContext().getResources().getColor(color));
                RectF rectF=new RectF(0,0,mWidth,mWidth);
                canvas.drawRect(rectF,mPaint);
                break;
            case 3:
                color=R.color.colorAccent;
                mPaint.setColor(getContext().getResources().getColor(color));
                Path path=new Path();
                path.moveTo(0,mWidth);
                path.lineTo(mWidth/2,0);
                path.lineTo(mWidth,mWidth);
                path.close();
                canvas.drawPath(path,mPaint);
        }

    }

    public void changeShape(){
        switch (type){
            case 1:
                type=2;
                break;
            case 2:
                type=3;
                break;
            case 3:
                type=1;
                break;

        }
        invalidate();
    }

    public void startAaim(){
        ObjectAnimator objectAnimator=null;
        switch (type){
            case 1:
            case 2:
                objectAnimator=ObjectAnimator.ofFloat(this,"rotation",180);
                break;

            case 3:
                objectAnimator=ObjectAnimator.ofFloat(this,"rotation",45);
                break;
        }
        if(objectAnimator==null)return;
        objectAnimator.setDuration(350);
        objectAnimator.start();

    }
}
