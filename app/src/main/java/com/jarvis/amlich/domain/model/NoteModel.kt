package com.jarvis.amlich.domain.model

import com.jarvis.amlich.R
import com.jarvis.amlich.data.entity.NoteEntity
import com.jarvis.amlich.di.App
import com.jarvis.amlich.domain.mapper.MapAbleToEntity
import com.jarvis.amlich.domain.mapper.MapAbleToModel

data class NoteModel(
    var id: Int? = 0,
    var title: String? = null,
    var des: String? = null,
    var dateTime: Long? = 0L,
) : MapAbleToEntity<NoteEntity> {

    override fun toEntity(): NoteEntity {
        return NoteEntity(
            id = id,
            title = title,
            des = des,
            dateTime = dateTime,
        )
    }
}