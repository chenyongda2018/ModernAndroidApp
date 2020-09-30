package com.cyd.modernandroidapp.model

import android.content.Context
import com.cyd.modernandroidapp.util.NetManager
import io.reactivex.Observable

/**
 * Created by cyd on 2020/9/30.
 */
class GitRepoRepository(context: Context) {
    val localDataSource  = RepoLocalDataSource()

    val remoteDataSource = RepoRemoteDataSource()

    val netManager = NetManager(context)


    fun loadData(): Observable<ArrayList<Repo>> {

        netManager.isConnect?.let {
            if(it) {
                return remoteDataSource.loadRepo().flatMap {
                    return@flatMap localDataSource.saveData(it).toSingleDefault(it).toObservable()
                }
            }
        }
        return localDataSource.loadData()
    }
}