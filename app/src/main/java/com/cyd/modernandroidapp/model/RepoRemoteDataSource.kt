package com.cyd.modernandroidapp.model

import android.os.Handler
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by cyd on 2020/9/30.
 */
class RepoRemoteDataSource {

    fun loadRepo(): Observable<ArrayList<Repo>> {
        var repoList = ArrayList<Repo>()
        repoList.add(Repo("repo1_remote","data",true,20))
        repoList.add(Repo("repo2_remote","data",true,20))
        repoList.add(Repo("repo3_remote","data",true,20))
        repoList.add(Repo("repo4_remote","data",true,20))
//        Handler().postDelayed({repoListener.onLoadRepoListSuccess(repoList)},2000)
        return Observable.just(repoList).delay(2,TimeUnit.SECONDS)
    }
}