package com.cyd.modernandroidapp.model

import android.os.Handler
import androidx.lifecycle.ViewModel


/**
 * Created by cyd on 2020/9/30.
 */
class RepoModel{

    var data: String = ""


    fun loadData(loadListener: LoadListener) {
        Handler().postDelayed({ loadListener.onLoadSuccess("new data") }, 2000)
    }

    fun loadRepo(repoListener: OnLoadRepoListener<Repo>) {
        var repoList = ArrayList<Repo>()
        repoList.add(Repo("repo1","data",true,20))
        repoList.add(Repo("repo2","data",true,20))
        repoList.add(Repo("repo3","data",true,20))
        repoList.add(Repo("repo4","data",true,20))
        Handler().postDelayed({repoListener.onLoadRepoListSuccess(repoList)},2000)
    }


    interface LoadListener {
        fun onLoadSuccess(data: String)
        fun onLoadFailed(msg: String)
    }

    interface OnLoadRepoListener<T> {
        fun onLoadRepoListSuccess( data : ArrayList<T>)
        fun onLoadFailed(msg : String)
    }
}