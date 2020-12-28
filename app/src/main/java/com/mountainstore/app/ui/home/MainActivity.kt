package com.mountainstore.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mountainstore.app.R
import com.mountainstore.app.databinding.ActivityMainBinding
import com.mountainstore.app.ui.auth.AuthActivity
import com.mountainstore.app.ui.auth.MountainstoreAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
       binding.bottomNav.setOnNavigationItemSelectedListener{
           when(it.itemId){
               R.id.ic_home->navigate(R.id.homeFragment)
               R.id.ic_store->navigate(R.id.storeFragment)
               R.id.ic_favorite->navigate(R.id.favoriteFragment)
               R.id.ic_profile->navigate(R.id.profileFragment)
               else->false
           }
       }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true

    }


}