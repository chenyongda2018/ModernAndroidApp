package com.cyd.modernandroidapp.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Created by cyd on 2020/9/29.
 */
class Repo(
    repoName: String,
    var repoOwner: String?,
    var repoHasIssue: Boolean = false,
    var repoStarCount: Int?
) :BaseObservable(){

    @get:Bindable
    var repoName : String = ""
    set(value) {
        field = value;
        notifyPropertyChanged(BR.repoName)
    }
}