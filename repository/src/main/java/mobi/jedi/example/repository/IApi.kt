package mobi.jedi.example.repository

import retrofit2.Call
import retrofit2.http.GET

internal interface IApi {

    @GET("v6/airports")
    fun getAirports(): Call<AirportResponse>

    @GET("v6/cities")
    fun getCities(): Call<CityResponse>
}
