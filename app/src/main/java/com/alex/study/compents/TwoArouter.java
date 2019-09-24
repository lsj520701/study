package com.alex.study.compents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alex.study.R;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = Constants.Two_PATH)
public class TwoArouter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_arouter);
    }
}
