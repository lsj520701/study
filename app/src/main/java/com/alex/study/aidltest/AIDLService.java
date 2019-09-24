package com.alex.study.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.alex.study.common.events.AidlEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class AIDLService extends Service {
    private static final String TAG ="service" ;
    List<Book> books=new ArrayList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"服務創建成功！！！！！！！！！！ 进程id: "+ Process.myPid());
        EventBus.getDefault().post(new AidlEvent("来自Service的Event"));

    }
}
