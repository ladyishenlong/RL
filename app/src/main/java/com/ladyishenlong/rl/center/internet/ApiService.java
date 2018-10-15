package com.ladyishenlong.rl.center.internet;

import android.widget.BaseExpandableListAdapter;

import com.ladyishenlong.rl.center.bean.BaseBean;
import com.ladyishenlong.rl.login.LoginBean;
import com.ladyishenlong.rl.test.TestBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    /***
     * 1.登录
     *
     * @param username
     * @param password
     */
    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username") String username,
                                @Field("password") String password);



    @GET("hello")
    Observable<TestBean>hello2();


}
