package com.cyd.modernandroidapp.inject

import android.content.Context
import com.cyd.modernandroidapp.model.GitRepoRepository
import com.cyd.modernandroidapp.util.NetManager
import com.cyd.modernandroidapp.viewmodel.MainViewModelFactory

object Inject {

    private val NET_MANAGER_INSTANCE: NetManager? = null

    fun provideNetManager(context: Context): NetManager {

        if (NET_MANAGER_INSTANCE == null) {
            return NetManager(context)
        }
        return NET_MANAGER_INSTANCE
    }

    fun provideGitRepository(netManager: NetManager): GitRepoRepository {
        return GitRepoRepository(netManager)
    }

    fun provideViewModelFactory(context: Context): MainViewModelFactory {
        val netManager = provideNetManager(context)
        val repository = provideGitRepository(netManager)
        return MainViewModelFactory(repository)
    }
}