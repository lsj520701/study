package com.alex.study.acts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alex.study.R;

public class ActTwo extends AppCompatActivity {

    public static void start(Activity activity){
        Intent intent=new Intent(activity,ActTwo.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_two);

        Log.e(TAG,"  two:  onCreat");
    }
    public String TAG="821";

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG,"  two:  onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG,"  two:  onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"  two:  onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"  two:  onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"  two:  onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"  two:  onDestroy");
    }
}
