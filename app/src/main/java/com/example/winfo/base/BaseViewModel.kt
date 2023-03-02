package com.example.winfo.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<VIEW_STATE> : ViewModel() {
    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(initialViewState()) }

    abstract fun initialViewState(): VIEW_STATE

    abstract fun reduce(event: MyEvent, previousState: VIEW_STATE): VIEW_STATE?

    fun processUiEvent(event: MyEvent) {
        updateState(event)
    }

    protected fun processDataEvent(event: MyEvent) {
        updateState(event)
    }

    private fun updateState(event: MyEvent) {
        val newViewState = reduce(event, viewState.value ?: initialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }
}