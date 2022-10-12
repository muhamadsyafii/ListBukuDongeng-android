package com.syafii.listbukudongeng.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    var noBook : Int = 0,
    var judulBuku : String = "",
    var tahun : String = "",
    var penerbit : String = "",
    var image : Int = 0
) : Parcelable
