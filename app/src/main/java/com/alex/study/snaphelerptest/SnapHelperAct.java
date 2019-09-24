package com.alex.study.snaphelerptest;

import android.os.Bundle;

import com.alex.study.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SnapHelperAct extends AppCompatActivity {
    List<HelperBean> mDatas=new ArrayList<>();

    TestAdapter mTestAdapter;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap_helper);
        mRecyclerView=findViewById(R.id.recyclerView);

        for(int i=0;i<20;i++){
            HelperBean bean=new HelperBean();
            int icon=R.drawable.jd;
            switch (i%3){
                case 0:
                    icon=R.drawable.jd;
                    break;
                case 1:
                    icon=R.drawable.qq;
                    break;

                case 2:
                    icon=R.drawable.xin;
                    break;

            }
            bean.setIcon(icon);
            bean.setName("名字"+i);
            mDatas.add(bean);
        }

        mTestAdapter=new TestAdapter(this,mDatas);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);

        mRecyclerView.setAdapter(mTestAdapter);
        TestHpler testHpler=new TestHpler();
        testHpler.attachToRecyclerView(mRecyclerView);

    }
}
