package com.nisha.githubuserinfo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameInput: EditText = findViewById(R.id.username_input)
        val fetchButton: Button = findViewById(R.id.fetch_button)
        val userinfo: TextView = findViewById(R.id.user_info)

        fetchButton.setOnClickListener {
            val username = usernameInput.text.toString()
            if(username.isNotEmpty()){
                viewModel.fetchUser(username)
            }
        }

        viewModel.user.observe(this, Observer { user ->
            userinfo.text = if (user != null) {
                "Username: ${user.login}\nFollowers: ${user.followers}\nFollowing: ${user.following}\nPublic Repositories: ${user.publicRepos}"
            } else {
                "User not found or an error occurred."
            }
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            errorMessage?.let {
                userinfo.text = it
                Log.e("MainActivity", it)
            }
        })
    }
}