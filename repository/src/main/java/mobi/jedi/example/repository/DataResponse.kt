package mobi.jedi.example.repository

import kotlinx.serialization.Serializable
import mobi.jedi.example.domain.Airport
import mobi.jedi.example.domain.City

@Serializable
data class CityResponse(val response: List<City>)

@Serializable
data class AirportResponse(val response: List<Airport>)