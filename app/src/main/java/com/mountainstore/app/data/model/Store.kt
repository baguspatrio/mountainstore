package com.mountainstore.app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Store(
    val judul:String="",
    val harga:String="",
    val ukuran:String="",
    val gambar:String="",
    val warna:String=""

) : Parcelable
