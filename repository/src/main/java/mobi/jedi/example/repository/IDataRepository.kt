package mobi.jedi.example.repository

import androidx.lifecycle.MutableLiveData
import mobi.jedi.example.domain.Airport
import mobi.jedi.example.domain.City

interface IDataRepository {

    fun getCities(): MutableLiveData<List<City>>
    fun getAirports(): MutableLiveData<List<Airport>>
}
