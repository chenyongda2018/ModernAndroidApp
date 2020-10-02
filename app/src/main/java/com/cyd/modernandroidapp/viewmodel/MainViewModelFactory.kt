package com.cyd.modernandroidapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cyd.modernandroidapp.model.GitRepoRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val gitRepoRepository: GitRepoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(gitRepoRepository) as T
        }
        throw IllegalArgumentException("unknow viewmodel class")
    }
}