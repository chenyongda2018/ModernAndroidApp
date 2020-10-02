package com.cyd.modernandroidapp.inject

import android.content.Context
import com.cyd.modernandroidapp.model.GitRepoRepository
import com.cyd.modernandroidapp.util.NetManager
import com.cyd.modernandroidapp.viewmodel.MainViewModelFactory

object Inject {
    fun provideViewModelFactory(context : Context) : MainViewModelFactory {
        val netManager = NetManager(context)
        val repository = GitRepoRepository(netManager)
        return MainViewModelFactory(repository)
    }
}