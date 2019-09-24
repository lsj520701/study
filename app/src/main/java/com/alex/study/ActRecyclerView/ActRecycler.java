package com.alex.study.ActRecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.study.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActRecycler extends Activity {

    private static final String TAG = "alex";
    MyAdapter mAdapter;
    CustomLayoutManager mLayoutManager;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_recycler);
        ButterKnife.bind(this);
        mAdapter = new MyAdapter(this);
        mLayoutManager = new CustomLayoutManager();
        LinearDecoration dividerItemDecoration=new LinearDecoration();
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context mContext;
        List<String> mList;

        public MyAdapter(Context context) {
            mContext=context;
            mList = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                mList.add("测试: " + i);
            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_test, parent,false);

            MyViewHolder viewHolder=new MyViewHolder(view);
            Log.i(TAG,"onCreateViewHolder   创建== "+viewHolder.toString());

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//            Log.e(TAG,"onBindViewHolder   holder== "+holder.toString()+"   position= "+position);
            holder.tvName.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }
}
