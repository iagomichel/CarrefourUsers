package com.iagomichel.carrefourusers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iagomichel.carrefourusers.R
import com.iagomichel.carrefourusers.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class UsersFragment: Fragment() {

    private val usersViewModel: UsersViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addObservables()
        usersViewModel.fetchUsersList()
    }

    private fun addObservables() {
        val rvUsers = activity?.findViewById<RecyclerView>(R.id.recycler_users)

        usersViewModel.users.observe(viewLifecycleOwner) { listUsers ->
            rvUsers?.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            rvUsers?.adapter = AdapterUsers(listUsers)
        }
    }
}
