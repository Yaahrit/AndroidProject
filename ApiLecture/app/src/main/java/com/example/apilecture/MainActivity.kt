package com.example.apilecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummy.json.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()
                val productList = responseBody?.products!!
                val collectDataInSB = StringBuilder()

                for (mydata in productList) {
                    collectDataInSB.append(mydata.title + " ")
                }
                val tv = findViewById<TextView>(R.id.textView)
                tv.text = collectDataInSB
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Main Activity", "on Failure: " + t.message)
            }
        })
    }
}