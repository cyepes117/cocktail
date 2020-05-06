package com.cocktail.test.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL= "http://jsonplaceholder.typicode.com/"

object Api {

    private lateinit var retrofitInstance: Retrofit

    fun getGrupoModeloApi() : GrupoModeloApi {
        if (!this::retrofitInstance.isInitialized) {
            retrofitInstance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitInstance.create(GrupoModeloApi::class.java)
    }

}