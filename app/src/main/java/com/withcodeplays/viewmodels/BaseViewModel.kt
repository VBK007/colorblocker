package com.withcodeplays.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    var loader: MutableLiveData<Int> = MutableLiveData()
    var setUI: MutableLiveData<Int> = MutableLiveData()
    var error: MutableLiveData<ApiError> = MutableLiveData()

    fun showLoader() = loader.postValue(SHOW)
    fun hideLoader() = loader.postValue(DISMISS)
    fun setUi(ui: Int) = setUI.postValue(ui)
    fun apiError(apiNo: Int, e: String) = error.postValue(ApiError(apiNo, e))

    companion object {
        const val SHOW = -1000
        const val DISMISS = -1001
    }


}

data class ApiError(var apicode: Int, var e: String)