package com.cocktail.test.userlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cocktail.test.R
import com.cocktail.test.data.UserListRepository
import com.cocktail.test.domain.User
import com.cocktail.test.userlist.adapters.UserListAdapter

class UserListActivity : AppCompatActivity(), UserListContract.View {

    private lateinit var presenter: UserListPresenter
    private lateinit var adapter: UserListAdapter
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewManager = LinearLayoutManager(this)
        userRecyclerView = findViewById<RecyclerView>(R.id.user_list_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager

        }
        presenter = UserListPresenter(
            this,
            UserListRepository()
        )
        presenter.getUserList()

    }

    override fun showUserList(users: List<User>) {
        adapter = UserListAdapter(users)
        userRecyclerView.adapter = adapter
    }

    override fun showError(error: String) {
        Log.e("COCKTAIL_TEST", error)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}