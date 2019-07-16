package mobi.jedi.example.repository

internal class CacheList<T> {

    private var cache: List<T>? = null

    fun set(list: List<T>) {
        cache = list
    }

    fun get(): List<T> = cache ?: throw IllegalStateException("Cache is invalid")

    fun isValid() = cache != null

    fun invalidate() {
        cache = null
    }
}