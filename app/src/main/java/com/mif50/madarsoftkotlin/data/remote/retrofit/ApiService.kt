package com.mif50.madarsoftkotlin.data.remote.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY ="b1b15e88fa797225412429c1c50c122a1"
// https://samples.openweathermap.org/data/2.5/forecast/daily
interface ApiServices {

    companion object {

        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): ApiServices {
            val requestInterceptor = Interceptor {
                val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build()

                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor it.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://samples.openweathermap.org/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServices::class.java)
        }
    }

    @GET("data/2.5/forecast/daily")
    fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") log: Double,
        @Query("cnt") cnt: Int = 10
    ): Deferred<Place>
}