package com.nisha.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private val url = "https://api.github.com/users"

    //private val userInfoItem = arrayListOf<userInfoItem>()
    private var userInfoItem = mutableListOf<userInfoItem>()
    private val userInfo = userInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rev)

        val stringRequest = StringRequest(url, Response.Listener {
            val gsonBuilder = GsonBuilder()
            val gson = gsonBuilder.create()
            userInfoItem = gson.fromJson(it, Array<userInfoItem>::class.java).toMutableList()
            userInfoItem.forEach {
                userInfo.add(it)
            }
            val adaptor = Adaptor(this,userInfo)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter=adaptor

        }, Response.ErrorListener {
            Toast.makeText(this, " Something went wrong " + it.toString(), Toast.LENGTH_LONG).show()
        })
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)
    }
}