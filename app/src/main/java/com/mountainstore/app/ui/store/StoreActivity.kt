package com.mountainstore.app.ui.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mountainstore.app.R

class StoreActivity : AppCompatActivity() {

    companion object{
        const val OPEN_STORE="open_store"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)


    }
}