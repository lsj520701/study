package com.alex.study.aidltest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alex.ipcservice.BuyCarControl;
import com.alex.ipcservice.Car;
import com.alex.study.R;
import com.alex.study.common.events.AidlEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AidlAct extends AppCompatActivity {

    private static final String TAG = "AidlAct";
    @BindView(R.id.onBind)
    TextView mOnBind;
    @BindView(R.id.tvLook)
    TextView mTvLook;
    @BindView(R.id.tvBuy)
    TextView mTvBuy;
    @BindView(R.id.tvShow)
    TextView mTvShow;
    @BindView(R.id.onJump)
    TextView onJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        Log.i(TAG,"Act中的id :  "+ Process.myPid());
    }

    @OnClick({R.id.onBind, R.id.tvLook, R.id.tvShow,R.id.tvBuy,R.id.onJump})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.onBind:
                onBind();
                break;
            case R.id.tvLook:
                lookCar();
                break;
            case R.id.tvBuy:
                buyCar();
                break;
            case R.id.tvShow:
                break;
            case R.id.onJump:
                onJump();
                break;

        }
    }

    private void buyCar(){
        try {
            Car car=mBuyCarControl.buyCar(1000);

            if(car!=null){
                mTvShow.setText("买到了car 名字是: "+car.getName());
            }else{
                mTvShow.setText("没有买到车");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    private void lookCar(){
        String name= "";
        try {
            name = mBuyCarControl.lookCar();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        mTvShow.setText(name);
    }

    public static int BOOK_INDEX=1;

    private void onJump(){
        AiAct.start(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AidlEvent event){

        Log.i(TAG,"接收刀事件:  "+event.getName());

    }
    MyServiceConnection myServiceConnection;
    BuyCarControl mBuyCarControl;
    boolean connected=false;
    private void onBind(){
        Intent intent=new Intent();
        intent.setAction("com.alex.buycar");
        intent.setPackage("com.alex.ipcservice");
         myServiceConnection=new MyServiceConnection();
        bindService(intent,myServiceConnection, Context.BIND_AUTO_CREATE);

    }

    class  MyServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG,"连接成功！！！！！！！！！！！"+service.toString());
            connected=true;
            mBuyCarControl=BuyCarControl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected=false;

        }
    }

}
