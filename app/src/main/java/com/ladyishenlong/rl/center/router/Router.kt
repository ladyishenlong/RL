package com.ladyishenlong.rl.center.router

import com.alibaba.android.arouter.launcher.ARouter

object Router {


    fun to(path: String) {
        ARouter.getInstance().build(path).navigation()
    }
}