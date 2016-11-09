package com.yyxk.rxjava_retrofit.webutils;


import com.yyxk.rxjava_retrofit.bean.BaseBean;
import com.yyxk.rxjava_retrofit.bean.Bean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

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
 * 类描述：Retrofit API
 * 创建人：Random
 * 创建时间：11:20
 * 修改人：Random
 * 修改时间：11:20
 * 修改备注：
 */
public interface ResponseCallBack<T extends BaseBean> {
    /**
     * BaseNetwork
     */
    @FormUrlEncoded
    @POST("{path}?")
    Observable<BaseBean<Bean>> baseConnect(@Path("path") String path, @FieldMap Map<String, String> map);


}
