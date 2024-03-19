package ca.burchill.chuck.network

import ca.burchill.chuck.model.ChuckJoke
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET



interface ChuckApiService {

    @GET("random")
    suspend fun getJoke() : ChuckJoke

}
