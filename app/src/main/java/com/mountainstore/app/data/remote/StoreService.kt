package com.mountainstore.app.data.remote


import com.mountainstore.app.data.model.StoreList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreService {

    @GET("/native/mountain")
    fun listStore() : Call<StoreList>

    @GET("/native/mountain")
    fun detailStore(@Query("url")url:String):Call<StoreList>

    @GET("/native/mountain")
    fun searchStore(@Query("q")query:String):Call<StoreList>
}