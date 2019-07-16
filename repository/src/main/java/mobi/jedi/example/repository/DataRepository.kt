package mobi.jedi.example.repository

import androidx.lifecycle.MutableLiveData
import mobi.jedi.example.domain.Airport
import mobi.jedi.example.domain.City
import mobi.jedi.example.logger.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataRepository private constructor() : IDataRepository {

    companion object {
        val instance: IDataRepository by lazy { DataRepository() }
    }

    private val api = ApiProvider.getApi()
    private val cache = CacheHolder.instance

    override fun getCities(): MutableLiveData<List<City>> {
        val cities = MutableLiveData<List<City>>()

        if (cache.hasCities()) {
            cities.value = cache.getCities()
        } else {
            api.getCities().enqueue(CallbackCity(cities, cache))
        }

        return cities
    }

    override fun getAirports(): MutableLiveData<List<Airport>> {
        val airports = MutableLiveData<List<Airport>>()

        if (cache.hasAirports()) {
            airports.value = cache.getAirports()
        } else {
            api.getAirports().enqueue(CallbackAirport(airports, cache))
        }

        return airports
    }
}

private class CallbackCity(
    private val liveData: MutableLiveData<List<City>>,
    private val cache: ICacheHolder
) : Callback<CityResponse> {

    override fun onFailure(call: Call<CityResponse>, t: Throwable) {
        Logger.e(t)
        liveData.value = null
    }

    override fun onResponse(
        call: Call<CityResponse>,
        response: Response<CityResponse>
    ) {
        val cities = response.body()?.response
        liveData.value = cities
        cities?.let { cache.saveCities(it) }
    }
}

private class CallbackAirport(
    private val liveData: MutableLiveData<List<Airport>>,
    private val cache: ICacheHolder
) : Callback<AirportResponse> {

    override fun onFailure(call: Call<AirportResponse>, t: Throwable) {
        Logger.e(t)
        liveData.value = null
    }

    override fun onResponse(
        call: Call<AirportResponse>,
        response: Response<AirportResponse>
    ) {
        val airports = response.body()?.response
        liveData.value = airports
        airports?.let { cache.saveAirports(it) }
    }
}

