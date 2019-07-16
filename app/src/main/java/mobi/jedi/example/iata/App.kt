package mobi.jedi.example.iata

import android.app.Application
import android.os.StrictMode
import mobi.jedi.example.logger.Logger

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        initStrictMode()

        super.onCreate()

        initLogger()
    }

    private fun initLogger() {
        Logger.initialize(BuildConfig.DEBUG)
    }

    private fun initStrictMode() {
        if (BuildConfig.DEBUG.not()) {
            return
        }

        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyFlashScreen()
                .penaltyLog()
                .build()
        )
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }
}