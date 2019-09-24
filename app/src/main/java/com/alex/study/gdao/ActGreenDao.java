package com.alex.study.gdao;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alex.study.R;
import com.alex.study.gdao.bean.DnjMessage;
import com.alex.study.greendao.DaoSession;
import com.alex.study.greendao.DnjConversationDao;
import com.alex.study.greendao.DnjMessageDao;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActGreenDao extends AppCompatActivity {

    @BindView(R.id.tvPermission)
    TextView mTvPermission;
    @BindView(R.id.etName)
    EditText mEtName;
    @BindView(R.id.tvAdd)
    TextView mTvAdd;
    @BindView(R.id.tvRemove)
    TextView mTvRemove;
    @BindView(R.id.tvQuery)
    TextView mTvQuery;
    @BindView(R.id.tvCreat)
    TextView tvCreat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_green_dao);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tvPermission, R.id.tvAdd, R.id.tvRemove, R.id.tvQuery,R.id.tvCreat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvPermission:
                permission();
                break;
            case R.id.tvCreat:
                onCreate();
                break;
            case R.id.tvAdd:
                add();
                break;
            case R.id.tvRemove:
                break;
            case R.id.tvQuery:
                break;
        }
    }

    private int index;

    private void query(){

    }
    private void add(){

        DnjMessage message=new DnjMessage();
        message.setIsExpert(true);
        message.setNikeName("专家 "+index);
        index++;
        mMessageDao.insert(message);
    }

    private DnjMessageDao mMessageDao;
    private DnjConversationDao mConversationDao;

    private void onCreate(){

      DaoSession daoSession= DaoSessionManager.getInstance().getDaoSession(this);
      mMessageDao=daoSession.getDnjMessageDao();
      mConversationDao=daoSession.getDnjConversationDao();

    }

    private void permission(){
        AndPermission.with(this).runtime().permission(Permission.Group.STORAGE).onGranted(new Action<List<String>>() {
            @Override
            public void onAction(List<String> data) {

                Log.e("daot","同意了存储权限、。。。");
            }
        }).start();
    }
}
