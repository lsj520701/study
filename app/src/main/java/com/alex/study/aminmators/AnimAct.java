package com.alex.study.aminmators;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alex.study.R;

import java.util.concurrent.locks.ReentrantLock;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimAct extends AppCompatActivity {

    @BindView(R.id.tvStart)
    TextView mTvStart;
    @BindView(R.id.tvTarget)
    TextView mTvTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tvStart, R.id.tvTarget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvStart:
//                valueAnim();
//                objectAnim();
                test();
                break;
            case R.id.tvTarget:
                break;
        }
    }

    private void sth(){
        handler.post(new Runnable() {
            @Override
            public void run() {

                Log.i("alex",".........runable");
            }
        });
    }

    private void test(){

        sth();
        Log.i("alex","       test方法。。。。。");

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.i("alex","handlerMessage.....");

        }
    };

    private void valueAnim(){

        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,1);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i("alex","得到到value  "+animation.getAnimatedValue());
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) mTvTarget.getLayoutParams();

                params.width = 100 + ((int)animation.getAnimatedValue() * 100);
                params.height=100+((int)animation.getAnimatedValue() * 200);
                mTvTarget.setLayoutParams(params);

            }
        });
        valueAnimator.start();
    }
    private void objectAnim(){

      ObjectAnimator objectAnimatorX= ObjectAnimator.ofInt(new NewTextView(mTvTarget),"realWidth",200,500).setDuration(500);

      objectAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
              Log.i("alex","得到到value  "+animation.getAnimatedValue());
          }
      });

      ObjectAnimator objectAnimatorY=ObjectAnimator.ofFloat(new NewTextView(mTvTarget),"realHeight",0,1F).setDuration(500)
              ;
      AnimatorSet set=new AnimatorSet();
      set.playTogether(objectAnimatorX,objectAnimatorY);
      set.start();
    }
}
