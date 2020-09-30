package com.cyd.modernandroidapp.model

/**
 * Created by cyd on 2020/9/30.
 */
interface OnLoadRepoListener<T> {
    fun onLoadRepoListSuccess( data : ArrayList<T>)
    fun onLoadFailed(msg : String)
}