package com.cyd.modernandroidapp.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by cyd on 2020/9/30.
 */
class NetManager(private var context : Context) {
    val isConnect : Boolean?
    get() {
        val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connManager.isActiveNetworkMetered
    }
}