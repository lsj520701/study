package com.alex.study.compents;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alex.module1.Module1Act;
import com.alex.module2.Module2Act;
import com.alex.study.R;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ARouterAct extends AppCompatActivity {

    @BindView(R.id.tvOne)
    TextView mTvOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);
        ButterKnife.bind(this);

        ARouter.getInstance().inject(this);

    }

    private void goOne(){
        Person person=new Person();
        person.setAge(100);
        person.setName("alexxx");
        ARouter.getInstance().build(Constants.ONE_PATH).withObject("person",person).
                withString("name","alex").
                withBoolean("isExpert",false).navigation(this, new NavCallback() {

            @Override
            public void onFound(Postcard postcard) {
                super.onFound(postcard);
                Log.e(Constants.TAG," onFound 调用");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                Log.e(Constants.TAG," onInterrupt 调用");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.e(Constants.TAG," onArrival 调用");
            }
        });
    }

    @OnClick({R.id.tvOne,R.id.tvModule1,R.id.tvModule2})
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.tvOne:
                goOne();
                break;

            case R.id.tvModule1:
                Module1Act.start(this);

                break;

            case R.id.tvModule2:
                Module2Act.start(this);

                break;

        }
    }
}
