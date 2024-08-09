package com.rajpaliwal.bkpraj.myapplication.repository

import com.rajpaliwal.bkpraj.myapplication.data.local.TripDao
import com.rajpaliwal.bkpraj.myapplication.data.model.TripInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TripRepository @Inject constructor(private val tripDao: TripDao) {

    val allTrips: Flow<List<TripInfo>> = tripDao.getAllTrip()

    suspend fun saveTrip(trip: TripInfo) {
        tripDao.saveTrip(trip)
    }

    suspend fun removeAllTrip() {
        tripDao.removeAllTrip()
    }
}
