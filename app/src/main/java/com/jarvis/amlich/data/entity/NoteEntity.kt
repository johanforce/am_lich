package com.jarvis.amlich.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jarvis.amlich.domain.mapper.MapAbleToModel
import com.jarvis.amlich.domain.model.NoteModel
import com.jarvis.amlich.domain.model.TuViModel
import org.jetbrains.annotations.NotNull


@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "des") var des: String? = null,
    @ColumnInfo(name = "date_time") var dateTime: Long? = 0L,
) : MapAbleToModel<NoteModel> {

    override fun toModel(): NoteModel {
        return NoteModel(
            id = id,
            title = title,
            des = des,
            dateTime = dateTime,
        )
    }
}
