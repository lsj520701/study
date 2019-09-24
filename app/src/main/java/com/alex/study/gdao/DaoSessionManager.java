package com.alex.study.gdao;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.alex.study.greendao.DaoMaster;
import com.alex.study.greendao.DaoSession;

import java.io.File;

public class DaoSessionManager {
    private String DA_NAME="daniujia.db";

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static volatile  Object lock=new Object();
    public static DaoSessionManager manager;

    public static DaoSessionManager getInstance(){
        if(manager==null){
            synchronized (lock){
                if(manager==null){
                    manager=new DaoSessionManager();
                }
            }
        }
        return  manager;
    }
    private final String mPath = "1111";
    public DaoMaster getDaoMaster(Context context){
        DaoMaster.DevOpenHelper devOpenHelper=new VersionChangeHelper(new ContextWrapper(context){
            @Override
            public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
                return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
            }

            @Override
            public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
                return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
            }

            @Override
            public File getDatabasePath(String name) {
                File file = FileUtils.buildDataBasePath(mPath, name);
                return file != null ? file : super.getDatabasePath(name);
            }
        },DA_NAME);
        Toast.makeText(context,"创建成功",Toast.LENGTH_LONG).show();
        mDaoMaster=new DaoMaster(devOpenHelper.getWritableDatabase());
        return mDaoMaster;
    }
    public DaoSession getDaoSession(Context context){
        if(mDaoSession==null){

            if(mDaoMaster==null){
                getDaoMaster(context);
            }
            mDaoSession=mDaoMaster.newSession();
        }

        return  mDaoSession;

    }
}
