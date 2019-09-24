package com.alex.study.ActRecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearDecoration extends RecyclerView.ItemDecoration {

    Paint mPaint;
    public  LinearDecoration(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);

    }
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        outRect.top=2;
        outRect.left=200;

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();

        for (int i=0;i<childCount;i++){
            View child = parent.getChildAt(i);
            int cx = 100;
            int cy = child.getTop()+child.getHeight()/2;
            c.drawCircle(cx,cy,20,mPaint);
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
