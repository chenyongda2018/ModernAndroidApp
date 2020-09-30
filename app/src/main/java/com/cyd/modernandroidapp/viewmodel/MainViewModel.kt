package com.cyd.modernandroidapp.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cyd.modernandroidapp.model.GitRepoRepository
import com.cyd.modernandroidapp.model.OnLoadRepoListener
import com.cyd.modernandroidapp.model.Repo
import java.util.*

/**
 * Created by cyd on 2020/9/30.
 */
class MainViewModel : AndroidViewModel {

    constructor(application: Application) : super(application)

    var dataSource = GitRepoRepository(getApplication())

    var isLoading = ObservableField<Boolean>(true)

    var data = ObservableField<String>("")

    var repoList = MutableLiveData<ArrayList<Repo>>()


    fun refreshData() {
        isLoading.set(true)
        dataSource.loadData(object : OnLoadRepoListener<Repo> {
            override fun onLoadRepoListSuccess(data: ArrayList<Repo>) {
                repoList.postValue(data)
                isLoading.set(false)
            }

            override fun onLoadFailed(msg: String) {
                data.set(msg)
                isLoading.set(false)
            }
        })
    }
}