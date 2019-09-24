package com.alex.study.acts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alex.study.R;

public class ActThree extends AppCompatActivity {

    public static void start(Activity activity){
        Intent intent=new Intent(activity,ActThree.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_three);
        Log.e(TAG,"  Three:  onCreate");
    }

    public String TAG="821";

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG,"  Three:  onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG,"  Three:  onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"  Three:  onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"  Three:  onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"  Three:  onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"  Three:  onDestroy");
    }
}
