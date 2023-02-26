package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.TuViModel
import org.jetbrains.annotations.NotNull


@Entity(tableName = "tu_vi")
data class TuViEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "cung") var cung: String? = null,
    @ColumnInfo(name = "vitri") var vitri: String? = null,
    @ColumnInfo(name = "an_sao_chinh") var anChinhTinh: String? = null,
    @ColumnInfo(name = "an_sao_chinh_di_kem") var anPhuTinh: String? = null,
    @ColumnInfo(name = "luan_giai") var luanGiai: String? = null,
) : MapAbleToModel<TuViModel> {

    override fun toModel(): TuViModel {
        return TuViModel(
            id = id,
            cung = cung,
            vitri = vitri,
            anChinhTinh = anChinhTinh,
            anPhuTinh = anPhuTinh,
            luanGiai = luanGiai,
        )
    }
}
