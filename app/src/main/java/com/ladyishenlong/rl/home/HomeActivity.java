package com.ladyishenlong.rl.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.apkfuns.logutils.LogUtils;
import com.ladyishenlong.rl.R;
import com.ladyishenlong.rl.center.activity.BaseActivity;
import com.ladyishenlong.rl.center.annotation.Layout;
import com.ladyishenlong.rl.center.bean.BaseBean;
import com.ladyishenlong.rl.center.internet.ApiClient;
import com.ladyishenlong.rl.login.LoginBean;
import com.ladyishenlong.rl.test.TestBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Layout(R.layout.activity_home)
@Route(path = "/home/HomeActivity")
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ApiClient.INSTANCE
//                .getApi()
//                .hello2()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<TestBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(TestBean testBean) {
//
//                        LogUtils.d("成功："+testBean.result);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtils.d("错误："+e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


        ApiClient.INSTANCE
                .getApi()
                .login("123","123")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
