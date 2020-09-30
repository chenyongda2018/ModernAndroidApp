package com.cyd.modernandroidapp.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cyd.modernandroidapp.model.GitRepoRepository
import com.cyd.modernandroidapp.model.Repo
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

/**
 * Created by cyd on 2020/9/30.
 */
class MainViewModel : AndroidViewModel {

    constructor(application: Application) : super(application)

    var dataSource = GitRepoRepository(getApplication())

    var isLoading = ObservableField<Boolean>(true)

    var repoList = MutableLiveData<ArrayList<Repo>>()

    lateinit var disposable: Disposable


    fun refreshData() {
        isLoading.set(true)
        disposable = dataSource.loadData().subscribeWith(object : DisposableObserver<ArrayList<Repo>>() {
            override fun onNext(t: ArrayList<Repo>) {
                repoList.postValue(t)
            }

            override fun onComplete() {
                isLoading.set(false)
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    //防止内存泄露，onCleared()会在activity 销毁后被调用
    override fun onCleared() {
        super.onCleared()
        if(!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}