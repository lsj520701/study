package com.alex.study.acts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.alex.study.R;

import androidx.fragment.app.Fragment;

public class ActOne extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_one);
        Log.e(TAG,"  one:  onCreat");

    }

    public String TAG="821";

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG,"  one:  onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG,"  one:  onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"  one:  onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"  one:  onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"  one:  onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"  one:  onDestroy");
    }
    public void onClickEvent(View view){

        ActTwo.start(this);
        ActThree.start(this);

    }
}
