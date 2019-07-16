package mobi.jedi.example.repository

import mobi.jedi.example.domain.Airport
import mobi.jedi.example.domain.City

internal interface ICacheHolder {

    fun hasCities(): Boolean
    fun hasAirports(): Boolean

    fun saveCities(list: List<City>)
    fun saveAirports(list: List<Airport>)

    fun getCities(): List<City>
    fun getAirports(): List<Airport>
}
