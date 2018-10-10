package com.ladyishenlong.rl.center.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.ladyishenlong.rl.R;
import com.ladyishenlong.rl.center.annotation.Layout;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    private RelativeLayout layoutBase;

    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        layoutBase = (RelativeLayout) findViewById(R.id.layout_base);

        initAnnotation();
    }


    /**
     * 解释注解
     */
    private void initAnnotation() {

        Class<?> clazz = this.getClass();

        if (clazz.getAnnotations() != null) {

            //将子类所有布局放进baseActivity的布局中
            if (clazz.isAnnotationPresent(Layout.class)) {
                Layout layout = clazz.getAnnotation(Layout.class);
                if (layout.value() != -1) {
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view = inflater.inflate(layout.value(), null);
                    layoutBase.addView(view);
                    ButterKnife.bind(this);
                    context = this;
                }
            }

        }

    }


}
