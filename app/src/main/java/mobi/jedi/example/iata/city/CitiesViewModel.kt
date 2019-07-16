package mobi.jedi.example.iata.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mobi.jedi.example.domain.City
import mobi.jedi.example.repository.DataRepository

internal class CitiesViewModel : ViewModel() {

    private val liveData: LiveData<List<City>> by lazy {
        DataRepository.instance.getCities()
    }

    fun getCities(): LiveData<List<City>> = liveData
}