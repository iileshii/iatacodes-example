package mobi.jedi.example.repository

import mobi.jedi.example.domain.Airport
import mobi.jedi.example.domain.City

internal class CacheHolder private constructor() : ICacheHolder {

    private val cities by lazy { CacheList<City>() }
    private val airports by lazy { CacheList<Airport>() }

    companion object {
        val instance: ICacheHolder by lazy { CacheHolder() }
    }

    override fun hasCities(): Boolean = cities.isValid()

    override fun hasAirports(): Boolean = airports.isValid()

    override fun saveCities(list: List<City>) = cities.set(list)

    override fun saveAirports(list: List<Airport>) = airports.set(list)

    override fun getCities(): List<City> = cities.getOrEmpty()

    override fun getAirports(): List<Airport> = airports.getOrEmpty()

    private fun <T> CacheList<T>.getOrEmpty() = if (isValid()) get() else emptyList()
}
