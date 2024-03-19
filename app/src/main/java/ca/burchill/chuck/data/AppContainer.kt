package ca.burchill.chuck.data

import ca.burchill.chuck.network.ChuckApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val chuckJokeRepository: ChuckJokeRepository
}

class DefaultContainer : AppContainer {

    private val BASE_URL = "https://api.chucknorris.io/jokes/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ChuckApiService by lazy {
        retrofit.create(ChuckApiService::class.java)
    }


    override val chuckJokeRepository: ChuckJokeRepository by lazy {
        NetworkChuckJokeRepository(retrofitService)
    }

}

