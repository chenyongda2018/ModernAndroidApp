package com.cyd.modernandroidapp.model

import android.os.Handler
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


/**
 * Created by cyd on 2020/9/30.
 */
class RepoLocalDataSource{


    fun loadData() : Observable<ArrayList<Repo>> {
        var repoList = ArrayList<Repo>()
        repoList.add(Repo("repo1_local","data",true,20))
        repoList.add(Repo("repo2_local","data",true,20))
        repoList.add(Repo("repo3_local","data",true,20))
        repoList.add(Repo("repo4_local","data",true,20))
        return Observable.just(repoList).delay(2, TimeUnit.SECONDS)
    }

    fun saveData(arrayList: ArrayList<Repo>) {}

}