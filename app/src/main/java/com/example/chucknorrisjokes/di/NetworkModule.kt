package com.example.chucknorrisjokes.di

import com.example.chucknorrisjokes.rest.ChuckNorrisApi
import com.example.chucknorrisjokes.rest.ChuckNorrisApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    }

    @Provides
    fun providesChuckNorrisAPI(retrofit: Retrofit): ChuckNorrisApi{
        return retrofit.create(ChuckNorrisApi::class.java)
    }

    @Provides
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}

//val api: ChuckNorrisApi by lazy {
//    initRetrofit().create(ChuckNorrisApi::class.java)
//}
//
//private fun initRetrofit(): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(createOkHttpClient())
//        .build()
//}
//
//private fun createOkHttpClient(): OkHttpClient {
//    val loggingInterceptor = HttpLoggingInterceptor()
//    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//    val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
//
//    return client
//}