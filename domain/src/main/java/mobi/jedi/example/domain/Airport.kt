package mobi.jedi.example.domain

import kotlinx.serialization.Serializable

@Serializable
data class Airport(val code: String, val name: String)
