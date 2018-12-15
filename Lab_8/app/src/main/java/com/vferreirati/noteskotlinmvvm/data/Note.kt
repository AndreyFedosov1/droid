package com.vferreirati.noteskotlinmvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
        @PrimaryKey
        var id: Int?,
        var title: String,
        var description: String?
)