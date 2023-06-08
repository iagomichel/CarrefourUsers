package com.iagomichel.carrefourusers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iagomichel.carrefourusers.R
import com.iagomichel.carrefourusers.data.model.Users

class AdapterUsers(private val list: List<Users>):
    RecyclerView.Adapter<AdapterUsers.AdapterUserViewHolder>() {

    class AdapterUserViewHolder(val item: View): RecyclerView.ViewHolder(item) {
        fun bind(user: Users) {
            val tvUser = item.findViewById<TextView>(R.id.textview_user)
            tvUser.text = user.login
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
