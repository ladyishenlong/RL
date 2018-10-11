package com.ladyishenlong.rl.center;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.ladyishenlong.rl.center.config.AppConfig;
import com.ladyishenlong.rl.center.internet.Internet;

import java.util.List;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        LogUtils.configAllowLog = !AppConfig.isRelease;
        LogUtils.configTagPrefix = "LogUtils";


        if (!AppConfig.isRelease) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);



        Internet.INSTANCE.init();


    }
}
