package com.cocktail.test.userlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cocktail.test.R
import com.cocktail.test.domain.User

class UserListAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    class ViewHolder(root: View): RecyclerView.ViewHolder(root) {
        private var name: TextView = root.findViewById(R.id.name_text_view)
        private var username: TextView = root.findViewById(R.id.username_text_view)
        private var email: TextView = root.findViewById(R.id.email_text_view)
        private var phone: TextView = root.findViewById(R.id.phone_text_view)
        private var website: TextView = root.findViewById(R.id.website_text_view)

        fun bind(user: User) {
            name.text = user.name
            username.text = user.username
            email.text = user.email
            phone.text = user.phone
            website.text = user.website
        }

    }
}
