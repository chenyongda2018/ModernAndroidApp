package com.cyd.modernandroidapp.model

import android.content.Context
import com.cyd.modernandroidapp.util.NetManager
import io.reactivex.Observable

/**
 * Created by cyd on 2020/9/30.
 */
class GitRepoRepository(private val netManager: NetManager) {

    val localDataSource  = RepoLocalDataSource()

    val remoteDataSource = RepoRemoteDataSource()




    fun loadData(): Observable<ArrayList<Repo>> {

        netManager.isConnect?.let {
            if(it) {
                return remoteDataSource.loadRepo().flatMap { result ->
                    return@flatMap localDataSource.saveData(result).toSingleDefault(result).toObservable()
                }
            }
        }
        return localDataSource.loadData()
    }
}