package mobi.jedi.example.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(val code: String, val name: String, @SerialName("country_code") val countryCode: String)