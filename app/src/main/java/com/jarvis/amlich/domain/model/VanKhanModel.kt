package com.jarvis.amlich.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VanKhanModel(
    var id: Int? = 0,
    var name: String? = null,
    var noiDung: String? = null,
    var theLoai: Int? = null,
) : Parcelable