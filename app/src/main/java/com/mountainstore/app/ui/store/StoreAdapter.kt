package com.mountainstore.app.ui.store

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.mountainstore.app.R
import com.mountainstore.app.data.model.Store
import com.mountainstore.app.databinding.ItemStoreBinding
import com.mountainstore.app.ui.base.BaseAdapter

class StoreAdapter(val context: Context): BaseAdapter<Store>(R.layout.item_store) {
    override fun onBind(binding: ViewDataBinding?, data: Store) {
     val mBinding=binding as ItemStoreBinding

        Glide.with(context).load(data.gambar).into(mBinding.itemGambar)
    }

    override fun onClick(binding: ViewDataBinding?, data: Store) {
        val intent = Intent(context,StoreActivity::class.java)
        intent.putExtra(StoreActivity.OPEN_STORE,data)
        context.startActivity(intent)
    }
}