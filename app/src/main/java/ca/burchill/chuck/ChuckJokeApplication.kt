package ca.burchill.chuck

import android.app.Application
import ca.burchill.chuck.data.AppContainer
import ca.burchill.chuck.data.DefaultContainer

class ChuckJokeApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = DefaultContainer()

    }
}