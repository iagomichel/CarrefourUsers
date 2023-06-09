package com.iagomichel.carrefourusers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iagomichel.carrefourusers.R
import com.iagomichel.carrefourusers.data.model.Users
import com.squareup.picasso.Picasso

class AdapterUsers(private val list: List<Users>):
    RecyclerView.Adapter<AdapterUsers.AdapterUserViewHolder>() {

    class AdapterUserViewHolder(item: View): RecyclerView.ViewHolder(item) {

        private val tvUser = item.findViewById<TextView>(R.id.textview_user)
        private val imageViewUser = item.findViewById<ImageView>(R.id.imageview_profile)

        fun bind(user: Users) {
            tvUser.text = user.login
            Picasso.get()
                .load(user.avatarUrl)
                .placeholder(R.drawable.ic_user_place_holder)
                .error(R.drawable.ic_error_place_holder)
                .into(imageViewUser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdapterUserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_users, parent, false)
        )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: AdapterUserViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }
}
