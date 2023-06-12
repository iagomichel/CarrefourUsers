package com.iagomichel.carrefourusers.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iagomichel.carrefourusers.R
import com.iagomichel.carrefourusers.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class UsersFragment: Fragment() {

    private val usersViewModel: UsersViewModel by activityViewModel()

    private var rvUsers: RecyclerView? = null
    private var pbLoading: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findViews()

        addUsersObservable()
        addLoadingObserver()
        addErrorObserver()
        usersViewModel.fetchUsersList()
    }

    private fun findViews() {
        rvUsers = activity?.findViewById(R.id.recycler_users)
        pbLoading = activity?.findViewById(R.id.progress_loading)
    }

    private fun addUsersObservable() {
        usersViewModel.users.observe(viewLifecycleOwner) { listUsers ->
            rvUsers?.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            rvUsers?.adapter = AdapterUsers(listUsers)
        }
    }

    private fun addLoadingObserver() {
        usersViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            pbLoading?.visibility = if (isLoading) View.VISIBLE else View.GONE

            rvUsers?.visibility = if (isLoading) View.GONE else View.VISIBLE
        }
    }

    private fun addErrorObserver() {
        usersViewModel.error.observe(viewLifecycleOwner) { _ ->
            pbLoading?.visibility = View.GONE
            showMessageErrorDialog()
        }
    }

    private fun showMessageErrorDialog() {
        AlertDialog
            .Builder(context)
            .setTitle("Atenção")
            .setMessage("O serviço parece indisponível no momento. Tente novamente mais tarde!")
            .setPositiveButton("Tentar novamente") { dialog, _ ->
                dialog.dismiss()

                usersViewModel.fetchUsersList()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
