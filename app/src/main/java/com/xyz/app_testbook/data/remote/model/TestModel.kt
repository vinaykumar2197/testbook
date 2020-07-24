package com.xyz.app_testbook.data.remote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_messages")
data class TestModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var bubbleId : Int



)