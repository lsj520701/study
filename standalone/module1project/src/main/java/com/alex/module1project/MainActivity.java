package com.alex.module1project;

import android.os.Bundle;
import android.view.View;

import com.alex.module1.Module1Act;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toOne(View view){

        Module1Act.start(this);
    }
}
