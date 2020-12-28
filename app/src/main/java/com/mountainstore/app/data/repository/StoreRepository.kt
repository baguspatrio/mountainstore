package com.mountainstore.app.data.repository

import com.mountainstore.app.data.model.ActionState
import com.mountainstore.app.data.model.Store
import com.mountainstore.app.data.remote.RetrofitApi
import com.mountainstore.app.data.remote.StoreService
import retrofit2.await
import java.lang.Exception

class StoreRepository {

    private val storeService:StoreService by lazy {RetrofitApi.storeService()}

    suspend fun listStore() : ActionState<List<Store>>{
       return try {
            val list = storeService.listStore().await()

            ActionState(list.data)
        }catch ( e:Exception){
            ActionState(message = e.message,isSuccess = false )
        }
    }
    suspend fun detailStore(url:String):ActionState<Store>{
       return try {
            val list = storeService.detailStore(url).await()
            ActionState(list.data.first())
        }catch (e:Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
    suspend fun searchStore(query:String):ActionState<List<Store>>{
     return  try {
           val list = storeService.searchStore(query).await()
           ActionState(list.data)

        }catch (e:Exception){
            ActionState(message = e.message, isSuccess = false)

        }
    }

}