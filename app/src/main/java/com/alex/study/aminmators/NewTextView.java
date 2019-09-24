package com.alex.study.aminmators;

import android.widget.TextView;

public class NewTextView {


    private  TextView mTextView;
    public NewTextView (TextView textView){

        this.mTextView=textView;
    }


    private int realWidth;
    private float realHeight;

    public int getRealWidth() {
        return realWidth;
    }

    public void setRealWidth(int realWidth) {
        this.realWidth = realWidth;

        mTextView.getLayoutParams().width=realWidth;
        mTextView.requestLayout();
    }

    public float getRealHeight() {
        return realHeight;
    }

    public void setRealHeight(float realHeight) {
        this.realHeight = realHeight;
        mTextView.getLayoutParams().height= (int) (realHeight*mTextView.getMeasuredHeight()+mTextView.getMeasuredHeight());
        mTextView.requestLayout();
    }
}
