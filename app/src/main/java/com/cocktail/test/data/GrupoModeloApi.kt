package com.cocktail.test.data

import com.cocktail.test.domain.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface GrupoModeloApi {

    @GET("users")
    fun listUsers(): Single<List<User>>

}
