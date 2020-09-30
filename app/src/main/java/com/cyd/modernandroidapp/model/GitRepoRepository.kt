package com.cyd.modernandroidapp.model

import android.content.Context
import com.cyd.modernandroidapp.util.NetManager

/**
 * Created by cyd on 2020/9/30.
 */
class GitRepoRepository(context: Context) {
    val localDataSource  = RepoLocalDataSource()

    val remoteDataSource = RepoRemoteDataSource()

    val netManager = NetManager(context)


    fun loadData(onLoadRepoListener: OnLoadRepoListener<Repo>) {

        netManager.isConnect?.let {
            if(it) {
                remoteDataSource.loadRepo(object : OnLoadRepoListener<Repo> {
                    override fun onLoadRepoListSuccess(data: ArrayList<Repo>) {
                        localDataSource.saveData(data)
                        onLoadRepoListener.onLoadRepoListSuccess(data)
                    }

                    override fun onLoadFailed(msg: String) {
                    }
                })
            } else {
                localDataSource.loadData(object : OnLoadRepoListener<Repo> {
                    override fun onLoadRepoListSuccess(data: ArrayList<Repo>) {
                        onLoadRepoListener.onLoadRepoListSuccess(data)
                    }

                    override fun onLoadFailed(msg: String) {
                    }
                })
            }
        }
    }
}