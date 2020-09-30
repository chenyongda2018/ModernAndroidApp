package com.cyd.modernandroidapp.model

import android.os.Handler

/**
 * Created by cyd on 2020/9/30.
 */
class RepoRemoteDataSource {

    fun loadRepo(repoListener: OnLoadRepoListener<Repo>) {
        var repoList = ArrayList<Repo>()
        repoList.add(Repo("repo1_remote","data",true,20))
        repoList.add(Repo("repo2_remote","data",true,20))
        repoList.add(Repo("repo3_remote","data",true,20))
        repoList.add(Repo("repo4_remote","data",true,20))
        Handler().postDelayed({repoListener.onLoadRepoListSuccess(repoList)},2000)
    }



    interface LoadListener {
        fun onLoadSuccess(data: String)
        fun onLoadFailed(msg: String)
    }


}