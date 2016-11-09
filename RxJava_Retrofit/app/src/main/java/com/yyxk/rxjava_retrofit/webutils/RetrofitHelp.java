package com.yyxk.rxjava_retrofit.webutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yyxk.rxjava_retrofit.application.MyApplication;
import com.yyxk.rxjava_retrofit.bean.BaseBean;
import com.yyxk.rxjava_retrofit.utils.DES3Util;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：WheelMedical
 * 包名:com.yyxk.wheelmedical.webutils
 * 类描述：
 * 创建人：Random
 * 创建时间：11:17
 * 修改人：Random
 * 修改时间：11:17
 * 修改备注：
 */
public class RetrofitHelp {
    private static ResponseCallBack responseCallBack;
    private static final String BASE_URL="http://192.168.1.154:8080/INTERFACE/";
    private RetrofitHelp() {
    }
    /**
     * 单例模式创建responseCallBack
     * @return
     */
    public static ResponseCallBack getResponseCallBack() {
        Retrofit builder = null;
        if (responseCallBack == null) {
            builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(JsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            responseCallBack = builder.create(ResponseCallBack.class);
        }
        return responseCallBack;
    }


    /**
     * 定制的okHttpClient
     * 加密。注意若采用加密后的requestNew，则所有接口统一，BaseURL失效，
     * 因为最近做的项目统一了接口，所以有这部分代码，在此仅作为参考使用。
     * @return
     */
    private static OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String code = "";
                        Request request = chain.request()
                                .newBuilder()
                                .build();
                        String encryptStr = encrypt(code, request);
                        FormBody.Builder builder=new FormBody.Builder();
                        builder.add("v",encryptStr);
                        FormBody bodyNew=builder.build();
                        Request requestNew = new Request.Builder().url("http://192.168.1.154:8080/INTERFACE/mainDispatcher/dispatcher.json").post(bodyNew).build();
                        Response response = chain.proceed(requestNew);
                        return response;
                    }
                })
                .build();
        return client;
    }

    /**
     * 加密方法
     * @param code
     * @param request
     * @return
     */
    @Nullable
    private static String encrypt(String code, Request request) {
        RequestBody requestBody=request.body();
        FormBody body= (FormBody) requestBody;
        for(int i=0;i<body.size();i++){
            if(body.encodedName(i).equals("path")){
                code=body.encodedValue(i)+code;
            }else{
                code+=body.encodedName(i)+"="+body.encodedValue(i)+"&";
            }
        }
        ;
        code=code.replace("%2F","/");   //参数传递时，"/"和"?"被转义，所以在此替换回来
        code=code.replace("%3F","?");
        code=code.substring(0,code.length()-1);
        Log.i("taggggggg","code="+code);
        DES3Util des3Util=new DES3Util("wanglaobige&2014");     //自定义一个秘钥
        String encryptStr=null;
        try {
            encryptStr=des3Util.encryptMode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptStr;
    }

    /**
     * 判断网络是否可用
     *
     * @return 布尔类型的值true false
     */
    public static boolean IsNetConnect() {
        ConnectivityManager manager = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info == null) {
            return false;
        } else {
            return info.isConnected();
        }

    }
    /**
     * 用来统一处理Http的Code,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    public class HttpResultFunc<T> implements Func1<BaseBean<T>, T> {
        @Override
        public T call(BaseBean<T> httpResult) {
            if(httpResult.getCode()==-1){
                //进行统一Code错误管理
            }
            return httpResult.getData();
        }
    }
    public static <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    //在访问时创建单例
    private static class SingletonHolder{
        private static final RetrofitHelp INSTANCE = new RetrofitHelp();
    }

    //获取单例
    public static RetrofitHelp getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
