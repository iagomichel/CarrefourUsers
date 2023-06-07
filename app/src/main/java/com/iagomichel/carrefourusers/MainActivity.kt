package com.iagomichel.carrefourusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iagomichel.carrefourusers.ui.UsersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUsersFragment()
    }
    private fun addUsersFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frm_main, UsersFragment(), "")
            .commit()
    }
}
