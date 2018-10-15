package com.ladyishenlong.rl.center.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ladyishenlong.rl.R;
import com.ladyishenlong.rl.center.annotation.Layout;
import com.ladyishenlong.rl.center.router.Path;
import com.ladyishenlong.rl.center.router.Router;

@Layout(R.layout.activity_main)
@Route(path = "/center/activity/MainActivity")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Router.INSTANCE.to(Path.home);
        finish();
    }
}
