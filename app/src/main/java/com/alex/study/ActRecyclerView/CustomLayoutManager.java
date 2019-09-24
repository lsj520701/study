package com.alex.study.ActRecyclerView;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public boolean canScrollVertically() {

        return false;
    }


    @Override
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int widthSpec, int heightSpec) {
        super.onMeasure(recycler, state, widthSpec, heightSpec);
        for(int i=0;i<getItemCount();i++){
            View view=recycler.getViewForPosition(i);
            measureChild(view,0,0);

            Log.i("alex"," onMeasure  :  "+ view.getMeasuredHeight());

        }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        int offsetY=0;

        for(int i=0;i<getItemCount();i++){

            View view=recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view,0,0);
            int width=getDecoratedMeasuredWidth(view);
            int height=getDecoratedMeasuredHeight(view);
            Log.i("alex","onLayoutChildren   >>>得到的跨高是width   "+width+"   h== "+height+"  getMeasureHeight= "+view.getMeasuredHeight());
            layoutDecorated(view,0,offsetY,width,offsetY+height);
            offsetY+=height;
        }
    }

/*    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
offsetChildrenVertical(-dy);
        return dy;
    }*/
}
