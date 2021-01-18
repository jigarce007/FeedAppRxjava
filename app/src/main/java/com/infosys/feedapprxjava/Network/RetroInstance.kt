package com.infosys.feedapprxjava.Network

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {
    companion object{

        val baseURL =  "https://dl.dropboxusercontent.com"
    fun getRetroInstace(applicationContext: Context): Retrofit{
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(applicationContext))
            .build()
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
}