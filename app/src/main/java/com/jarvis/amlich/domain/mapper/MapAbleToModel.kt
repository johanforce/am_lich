package com.jarvis.amlich.domain.mapper

interface MapAbleToModel<Model> {
    fun toModel(): Model
}

interface MapAbleToEntity<Entity> {
    fun toEntity(): Entity
}

