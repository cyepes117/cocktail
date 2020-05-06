package com.cocktail.test.data

import com.cocktail.test.domain.User
import io.reactivex.rxjava3.core.Single

class UserListRepository {
    fun getUserList(): Single<List<User>> {
        //TODO cache data
        return Api.getGrupoModeloApi()
            .listUsers()
    }
}