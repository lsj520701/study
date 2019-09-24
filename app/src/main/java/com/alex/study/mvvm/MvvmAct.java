package com.alex.study.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.alex.study.R;
import com.alex.study.databinding.ActivityMvvmBinding;
import com.alex.study.mvvm.model.User;

public class MvvmAct extends AppCompatActivity {

    ActivityMvvmBinding mMvvmBinding;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        mMvvmBinding= DataBindingUtil.setContentView(this,R.layout.activity_mvvm);

        mUser=new User("默认","  女",30);
        mMvvmBinding.setUser(mUser);

        mMvvmBinding.setVariable()

    }

    public void onClickEvent(View view){

        switch (view.getId()){

            case R.id.tvClickOne:

                mUser.setName("点击转变一");
                break;

            case R.id.tvClickTwo:
                mUser.setName("点击转变二");
                break;

            case R.id.tvClickThree:
                mUser.setName("点击转变三");

                break;
        }
    }
}
