package ca.burchill.chuck.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import ca.burchill.chuck.ChuckJokeApplication
import ca.burchill.chuck.data.ChuckJokeRepository
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface ChuckUiState {
    data class Success(val joke: String) : ChuckUiState
    object Error : ChuckUiState
    object Loading : ChuckUiState
}


class ChuckViewModel (
    private val chuckJokeRepository : ChuckJokeRepository
)
    : ViewModel() {

    var chuckUiState: ChuckUiState by mutableStateOf(ChuckUiState.Loading)
        private set

    init {
        getChuckJoke()
    }

    fun getChuckJoke() {
        Log.d("QQ", "get photos before on ${Thread.currentThread().name}")
        viewModelScope.launch {
            chuckUiState = try {
                Log.d("QQ", "get photos in on ${Thread.currentThread().name}")

                val jokeResult = chuckJokeRepository.getChuckJoke()

                ChuckUiState.Success(jokeResult.value)
            } catch (e: IOException) {
                ChuckUiState.Error
            }
            Log.d("QQ", "get photos after on ${Thread.currentThread().name}")

        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ChuckJokeApplication)
                val chuckJokeRepository = application.container.chuckJokeRepository
                ChuckViewModel(chuckJokeRepository = chuckJokeRepository)            }
        }
    }

}