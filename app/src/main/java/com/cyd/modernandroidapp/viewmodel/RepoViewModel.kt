package com.cyd.modernandroidapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyd.modernandroidapp.model.Repo
import com.cyd.modernandroidapp.model.RepoModel
import java.util.*

/**
 * Created by cyd on 2020/9/30.
 */
class RepoViewModel : ViewModel(){
    var model : RepoModel = RepoModel()

    var isLoading  = ObservableField<Boolean>(true)

    var data  = ObservableField<String>("")

    var repoList = MutableLiveData<ArrayList<Repo>>()


    fun refreshData() {
        isLoading.set(true)
        model.loadRepo(object : RepoModel.OnLoadRepoListener<Repo> {
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