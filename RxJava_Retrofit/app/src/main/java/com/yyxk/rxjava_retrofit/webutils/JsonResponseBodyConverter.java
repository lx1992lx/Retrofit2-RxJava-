package com.yyxk.rxjava_retrofit.webutils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.yyxk.rxjava_retrofit.utils.DES3Util;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

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
 * 类描述：响应体处理类
 * 创建人：Random
 * 创建时间：14:25
 * 修改人：Random
 * 修改时间：14:25
 * 修改备注：
 */
public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson mGson;//gson对象
    private final TypeAdapter<T> adapter;

    /**
     * 构造器
     */
    public JsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.mGson = gson;
        this.adapter = adapter;
    }

    /**
     * 在此对服务器返回值进行解密
     * @param responseBody
     * @return
     * @throws IOException
     */
    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        DES3Util des = new DES3Util("wanglaobige&2014");
        String response = responseBody.string();
        Log.i("taggggg", "解密的服务器数据：" + response);
//        String strResult = response.substring(1, response.length() - 1);
        String result = null;
        try {
            result = des.decryptMode(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("taggggg", "解密的服务器数据：" + result);
//        JsonReader jsonReader = mGson.newJsonReader(responseBody.charStream());
        try {
            return adapter.fromJson(result);
        } finally {
            responseBody.close();
        }

    }

}

