package com.cocktail.test.userlist

import com.cocktail.test.domain.User

interface UserListContract {
    interface View {
        fun showUserList(users: List<User>)
        fun showError(error: String)
    }
    interface Presenter {
        fun getUserList()
        fun destroy()
    }
}