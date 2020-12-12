package com.mountainstore.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mountainstore.app.R
import com.mountainstore.app.databinding.ActivityMainBinding
import com.mountainstore.app.ui.auth.AuthActivity
import com.mountainstore.app.ui.auth.MountainstoreAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
           MountainstoreAuth.logout(this){
               startActivity(Intent(this,AuthActivity::class.java))
               finish()
           }
        }
    }
}