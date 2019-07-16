package mobi.jedi.example.repository

import okhttp3.Interceptor
import okhttp3.Response

internal class ApiKeyInterceptor : Interceptor {

    companion object {
        private const val API_KEY_QUERY_PARAM = "api_key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY_QUERY_PARAM, BuildConfig.API_KEY)
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}