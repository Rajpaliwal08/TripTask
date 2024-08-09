package com.rajpaliwal.bkpraj.myapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajpaliwal.bkpraj.myapplication.data.model.TripInfo
import com.rajpaliwal.bkpraj.myapplication.repository.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TripRepository): ViewModel() {

    private val _trips = MutableStateFlow<List<TripInfo>>(emptyList())
    val trips: StateFlow<List<TripInfo>> = _trips.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allTrips.collect { listOfItems ->
                _trips.value = listOfItems
            }
        }
    }

    fun addTrip(
        customerName: String,
        pickupAddress: String,
        dropOffAddress: String,
        price: String,
        pickupTime: String
    ) {
        val tripInfo = TripInfo(
            customerName = customerName,
            pickupAddress = pickupAddress,
            dropOffAddress = dropOffAddress,
            price = price,
            pickupTime = pickupTime
        )
        viewModelScope.launch {
            repository.saveTrip(tripInfo)
        }
    }

    fun removeTrip() = viewModelScope.launch(Dispatchers.IO) {
        repository.removeAllTrip()
    }
}