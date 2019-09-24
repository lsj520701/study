package com.alex.study.rxjavatest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alex.study.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ActRxjava extends AppCompatActivity {

    public static final String TAG="out_rxjava";
    @BindView(R.id.tvSendSimple)
    TextView mTvSendSimple;
    @BindView(R.id.tvSwitchThread)
    TextView mTvSwitchThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_rxjava);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tvSendSimple, R.id.tvSwitchThread,R.id.tvMap})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSendSimple:
                sendSimple();

                break;
            case R.id.tvSwitchThread:
                swtichThread();
                break;

            case R.id.tvMap:
                map();
                break;
        }
    }

    private void  swtichThread(){


        Observable.just("发送第一条").map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {

                Log.e(TAG,"map1  apply :"+s+ "  线程是:   "+Thread.currentThread().getName());
                return "就是要统一操作~~";
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                Log.e(TAG,"map2  apply :"+s+ "  线程是:   "+Thread.currentThread().getName());
                return 110;
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer s) {
                Log.e(TAG,"onNext :"+s+ "  线程是:   "+Thread.currentThread().getName());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void map(){

        Observable.just(10086,10000,3000).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {

                Log.e(TAG,"map 中轉換: "+10010);
                return 10010;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG,"新的客戶電弧是  : "+integer);
            }
        });
    }

    private void sendSimple(){

        Observable observable=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

e.onNext("one");
e.onNext("two");
e.onNext("three");
e.onComplete();
            }
        });

        Observer<String> observer=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.e(TAG,value);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG,"结束了");
            }
        };
        observable.subscribe(observer);

    }

    private void switchThread(){

    }

}
