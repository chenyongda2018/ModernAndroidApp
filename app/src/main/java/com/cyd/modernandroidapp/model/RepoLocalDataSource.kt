package com.cyd.modernandroidapp.model

import android.os.Handler
import androidx.lifecycle.ViewModel


/**
 * Created by cyd on 2020/9/30.
 */
class RepoLocalDataSource{




    fun loadData(repoListener: OnLoadRepoListener<Repo>) {
        var repoList = ArrayList<Repo>()
        repoList.add(Repo("repo1_local","data",true,20))
        repoList.add(Repo("repo2_local","data",true,20))
        repoList.add(Repo("repo3_local","data",true,20))
        repoList.add(Repo("repo4_local","data",true,20))
        Handler().postDelayed({repoListener.onLoadRepoListSuccess(repoList)},2000)
    }

    fun saveData(arrayList: ArrayList<Repo>) {}


    interface LoadListener {
        fun onLoadSuccess(data: String)
        fun onLoadFailed(msg: String)
    }


}