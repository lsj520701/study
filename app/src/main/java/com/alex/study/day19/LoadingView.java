package com.alex.study.day19;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alex.study.R;

import androidx.annotation.Nullable;

public class LoadingView extends LinearLayout {

    ShapeView mShapeView;
    ImageView mCenterView;
    TextView mTvLoading;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public LoadingView(Context context) {
        this(context,null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }


    private void init(){
        inflate(getContext(), R.layout.loading_view,this);
        mTvLoading=findViewById(R.id.tvLoading);
        mCenterView=findViewById(R.id.center_view);
        mShapeView=findViewById(R.id.shape_view);

        post(new Runnable() {
            @Override
            public void run() {
                startDownAnim();
            }
        });

    }

    private void startDownAnim(){

        ObjectAnimator translationAnim=ObjectAnimator.ofFloat(mShapeView,"translationY",0,160);
        ObjectAnimator scaleAnim=ObjectAnimator.ofFloat(mCenterView,"scaleX",1.0f,0.3f);
        AnimatorSet set=new AnimatorSet();
        set.playTogether(translationAnim,scaleAnim);
        set.setDuration(300);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startUpAnim();
            }
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

        set.start();
    }


    private void startUpAnim(){
        ObjectAnimator translationAnim=ObjectAnimator.ofFloat(mShapeView,"translationY",160,0);
        ObjectAnimator scaleAnim=ObjectAnimator.ofFloat(mCenterView,"scaleX",0.3f,1.0f);
        AnimatorSet set=new AnimatorSet();
        set.playTogether(translationAnim,scaleAnim);
        set.setDuration(300);

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mShapeView.changeShape();
                startDownAnim();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                rationAnim();
            }
        });
        set.start();
    }


    private void rationAnim(){

        mShapeView.startAaim();
    }


}
