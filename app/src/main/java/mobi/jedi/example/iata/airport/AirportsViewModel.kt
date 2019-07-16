package mobi.jedi.example.iata.airport

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mobi.jedi.example.domain.Airport
import mobi.jedi.example.repository.DataRepository

internal class AirportsViewModel : ViewModel() {

    private val liveData: LiveData<List<Airport>> by lazy {
        DataRepository.instance.getAirports()
    }

    fun getAirports(): LiveData<List<Airport>> = liveData
}