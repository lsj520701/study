package com.alex.study.aidltest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

import com.alex.study.R;

public class AiAct extends AppCompatActivity {

    private static final String TAG = "AiAct";

    public static  void start(Context context){

        Intent intent=new Intent(context,AiAct.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        Log.i(TAG,"在AiAct中的进程id是:  "+ Process.myPid());

    }
}
