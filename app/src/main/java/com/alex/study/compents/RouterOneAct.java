package com.alex.study.compents;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alex.study.R;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = Constants.ONE_PATH)
public class RouterOneAct extends AppCompatActivity {


    @Autowired()
    String name;

    @Autowired()
    boolean isExpert;

    @Autowired()
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router_one);
        ARouter.getInstance().inject(this);

        Log.e("router","得到的name:  "+name+   " isExpert=  "+isExpert+"   person= "+person);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
