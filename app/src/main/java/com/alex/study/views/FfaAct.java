package com.alex.study.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Messenger;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alex.study.R;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FfaAct extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    MyViewPagerAdapter mMyViewPagerAdapter=new MyViewPagerAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffa);
        ButterKnife.bind(this);
        mViewPager.setAdapter(mMyViewPagerAdapter);

    }

    public class MyViewPagerAdapter extends PagerAdapter {


        Context mContext;
        public MyViewPagerAdapter(Context context){

            mContext=context;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView =new ImageView(mContext);
            imageView.setImageResource(R.mipmap.timg);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView((View) object);
        }
    }
}
