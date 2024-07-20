package com.myself223.data.module

import com.myself223.data.BuildConfig.BASE_URL
import com.myself223.data.remote.apiservice.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideOkHttpClient().build() }
    factory { provideApiService(provideOkHttpClient().build()) }
}
fun provideApiService(client: OkHttpClient): ApiService =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(ApiService::class.java)


fun provideOkHttpClient() =
    OkHttpClient.Builder().
    addInterceptor(provideLoggingInterceptor())
        .callTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)

private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
    when {
        BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
        else-> HttpLoggingInterceptor.Level.NONE
    }
)


