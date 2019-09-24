package com.alex.study.gdao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alex.study.gdao.bean.DnjConversation;
import com.alex.study.greendao.DaoMaster;
import com.alex.study.greendao.DnjConversationDao;
import com.alex.study.greendao.DnjMessageDao;

import org.greenrobot.greendao.database.Database;

public class VersionChangeHelper extends DaoMaster.DevOpenHelper {

    public VersionChangeHelper(Context context, String name) {
        this(context, name, null);
    }

    public VersionChangeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);

        if(newVersion>1&&newVersion<3){
            DnjConversationDao.dropTable(db,true);
        }else if(newVersion>2){
            MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

                @Override
                public void onCreateAllTables(Database db, boolean ifNotExists) {
                    Log.e("update", "onCreateAllTables");
                    //                    DaoMaster.createAllTables(db, ifNotExists);
                    DnjMessageDao.createTable(db,ifNotExists);
                    Log.e("update", "onCreateAllTables");
                }

                @Override
                public void onDropAllTables(Database db, boolean ifExists) {
                    Log.e("update", "onDropAllTables");
                    //DaoMaster.dropAllTables(db, ifExists);
                    DnjMessageDao.dropTable(db,ifExists);
                }
            }, DnjMessageDao.class);
        }

        //MigrationHelper.migrate(db, MenuInfoDao.class);
        Log.e("update", "执行了最新onUpgrade");
//        DnjMessageDao.dropTable(db, true);
    }

}
