package com.alex.study.snaphelerptest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.study.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {


    private static final String TAG = "adapter";
    Context mContext;


    List<HelperBean> mDatas;
    public TestAdapter(Context context, List<HelperBean> datas){
        this.mContext=context;
        this.mDatas=datas;

    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_helper,null);
        TestViewHolder viewHolder=new TestViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        Log.i(TAG,"得到的holder:  "+holder);
        holder.ivIcon.setImageResource(mDatas.get(position).getIcon());
        holder.tvName.setText(mDatas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class TestViewHolder extends  RecyclerView.ViewHolder{
      public  TextView tvName;
       public  ImageView ivIcon;
        public TestViewHolder(View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            ivIcon=itemView.findViewById(R.id.ivIcon);
        }
    }
}
