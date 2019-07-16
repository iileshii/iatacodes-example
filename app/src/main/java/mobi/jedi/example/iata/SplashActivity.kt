package mobi.jedi.example.iata

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onPostResume() {
        super.onPostResume()

        handler.postDelayed({ startNextScreen() }, 3000)
    }

    private fun startNextScreen() {
        MainActivity.start(this)

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}