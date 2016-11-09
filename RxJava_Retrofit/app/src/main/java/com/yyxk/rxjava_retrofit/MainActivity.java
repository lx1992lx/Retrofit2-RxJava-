package com.yyxk.rxjava_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yyxk.rxjava_retrofit.bean.Bean;
import com.yyxk.rxjava_retrofit.webutils.ProgressSubscriber;
import com.yyxk.rxjava_retrofit.webutils.ResponseCallBack;
import com.yyxk.rxjava_retrofit.webutils.RetrofitHelp;
import com.yyxk.rxjava_retrofit.webutils.SubscriberOnNextListener;

import java.util.HashMap;

import rx.Observable;

/**
 * 网络请求，为了省事，全写在这里了
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtn;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn= (Button) findViewById(R.id.btn);
        mText= (TextView) findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                load();
                break;
        }
    }

    /**
     * 网络加载
     */
    private void load() {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", "13611042364");
        map.put("code","543210");
        map.put("path","/emorder/login.json?");
        String path = "dispatcher.json";
        ResponseCallBack callBack = RetrofitHelp.getResponseCallBack();
        RetrofitHelp help = RetrofitHelp.getInstance();
        Observable observable = callBack.baseConnect(path, map)
                .map(help.new HttpResultFunc<Bean>());
        SubscriberOnNextListener<Bean> onNextListener=new SubscriberOnNextListener<Bean>() {
            @Override
            public void onNext(Bean bean) {
                //在此做请求成功之后的事情
            }
        };
        RetrofitHelp.toSubscribe(observable,new ProgressSubscriber(onNextListener,MainActivity.this));
    }
}
