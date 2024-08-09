package com.rajpaliwal.bkpraj.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip_info")
data class TripInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val customerName: String,
    val pickupAddress: String,
    val dropOffAddress: String,
    val price: String,
    val pickupTime: String
)
