package com.cyd.modernandroidapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyd.modernandroidapp.model.GitRepoRepository
import com.cyd.modernandroidapp.model.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by cyd on 2020/9/30.
 */
class MainViewModel(private val dataSource : GitRepoRepository) : ViewModel() {

    var isLoading = ObservableField<Boolean>(true)

    var repoList = MutableLiveData<ArrayList<Repo>>()

    //CompositeDisposable,
    // a disposable container that can hold onto multiple other disposables
    private var compositeDisposable = CompositeDisposable()


    fun refreshData() {
        isLoading.set(true)
        compositeDisposable.add(
            dataSource.loadData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ArrayList<Repo>>() {
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
        )
    }

    //防止内存泄露，onCleared()会在activity 销毁后被调用
    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
