package com.mountainstore.app.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.mountainstore.app.data.model.ActionState
import com.mountainstore.app.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object MountainstoreAuth {

    fun logout(context: Context,callback: ((ActionState<Boolean>)->Unit)?=null){
        val repo =AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp=repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null)callback.invoke(resp)
            }
        }
    }
}