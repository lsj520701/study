package com.alex.module2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Module2Act extends AppCompatActivity {

    public static void start(Activity a){
        Intent intent=new Intent(a,Module2Act.class);
        a.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
    }
}
