package com.jarvis.amlich.domain.model

import com.jarvis.amlich.R
import com.jarvis.amlich.di.App
import com.jarvis.amlich.domain.mapper.MapAbleToModel

data class TuViModel(
    var id: Int? = 0,
    var cung: String? = null,
    var vitri: String? = null,
    var anChinhTinh: String? = null,
    var anPhuTinh: String? = null,
    var luanGiai: String? = null,
)