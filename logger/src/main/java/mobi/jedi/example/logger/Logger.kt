package mobi.jedi.example.logger

import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean

@Suppress("unused")
class Logger private constructor(private val debuggable: Boolean) {

    companion object {
        private lateinit var INSTANCE: Logger
        private val initialized = AtomicBoolean()

        fun initialize(debuggable: Boolean) {
            if (initialized.getAndSet(true).not()) {
                INSTANCE = Logger(debuggable)
                INSTANCE.onInitialize()
            }
        }

        fun d(message: String, vararg args: Any) {
            INSTANCE.d(message, *args)
        }

        fun d(throwable: Throwable?) {
            INSTANCE.d(throwable)
        }

        fun i(message: String, vararg args: Any) {
            INSTANCE.i(message, *args)
        }

        fun e(message: String, vararg args: Any) {
            INSTANCE.e(message, *args)
        }

        fun e(throwable: Throwable?) {
            INSTANCE.e(throwable)
        }

        fun e(throwable: Throwable?, message: String, vararg args: Any) {
            INSTANCE.e(throwable, message, *args)
        }
    }

    private fun onInitialize() {
        if (debuggable) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun d(message: String, vararg args: Any) {
        Timber.d(message, *args)
    }

    private fun d(throwable: Throwable?) {
        Timber.d(throwable)
    }

    private fun i(message: String, vararg args: Any) {
        Timber.i(message, *args)
    }

    private fun e(message: String, vararg args: Any) {
        Timber.e(message, *args)
    }

    private fun e(throwable: Throwable?) {
        Timber.e(throwable)
    }

    private fun e(throwable: Throwable?, message: String, vararg args: Any) {
        Timber.e(throwable, message, *args)
    }
}