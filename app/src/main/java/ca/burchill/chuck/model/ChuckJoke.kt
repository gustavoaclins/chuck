package ca.burchill.chuck.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChuckJoke(
    val categories: List<String>,
    @SerialName(value = "created_at")
    val createdAt: String,
    @SerialName(value = "icon_url")
    val iconUrl: String,
    val id: String,
    @SerialName(value = "updated_at")
    val updatedAt: String,
    val url: String,
    val value: String
)

