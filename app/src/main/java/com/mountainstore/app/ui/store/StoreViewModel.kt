package com.mountainstore.app.ui.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mountainstore.app.data.model.ActionState
import com.mountainstore.app.data.model.Store
import com.mountainstore.app.data.repository.StoreRepository
import kotlinx.coroutines.launch
import java.net.URL

class StoreViewModel : ViewModel() {
    private val repo: StoreRepository by lazy { StoreRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Store>>()
    val detailResp = MutableLiveData<Store>()
    val searchResp = MutableLiveData<List<Store>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listStore() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listStore()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailStore(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailStore(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }

    }

    fun searchStore(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchStore(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}