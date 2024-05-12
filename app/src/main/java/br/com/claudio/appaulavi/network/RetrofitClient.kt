package br.com.claudio.appaulavi.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://api-android-mvp-example-production.up.railway.app/"

        private fun getRetrofitInstance(): Retrofit {
            var http = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <T> createService(service: Class<T>): T {
            return getRetrofitInstance().create(service)
        }
    }
}