package com.cocktail.test.userlist

import com.cocktail.test.data.UserListRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class UserListPresenter(
    private val userListView: UserListContract.View,
    private val userListRepository: UserListRepository
) : UserListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getUserList() {
        val subscribe = userListRepository.getUserList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { userList ->
                    userListView.showUserList(userList)
                },
                { throwable ->
                    userListView.showError(throwable.localizedMessage)
                }
            )
        compositeDisposable.add(subscribe)
    }

    override fun destroy() = compositeDisposable.dispose()
}