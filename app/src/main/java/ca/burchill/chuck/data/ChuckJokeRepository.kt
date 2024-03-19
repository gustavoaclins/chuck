package ca.burchill.chuck.data

import ca.burchill.chuck.model.ChuckJoke
import ca.burchill.chuck.network.ChuckApiService

interface ChuckJokeRepository {
    suspend fun getChuckJoke(): ChuckJoke
}

class NetworkChuckJokeRepository(
    private val chuckApiService: ChuckApiService
) : ChuckJokeRepository {

    override suspend fun getChuckJoke(): ChuckJoke =
        chuckApiService.getJoke()

}