package com.nisha.myvideocall

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class LoginActivity : AppCompatActivity() {
    private lateinit var myUserId: EditText
    private lateinit var loginButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myUserId = findViewById(R.id.myUserId)
        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val myUserId = myUserId.text.toString()
            if(myUserId.isNotEmpty()){
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                intent.putExtra("userID",myUserId)
                startActivity(intent)
                setupZegoUIKit(myUserId)
            }
        }

        //App id : 1686344549
        //App sign : 9e824749da43c787d5d44040410b5904687394bc40bbe9d6f47aa63ca18ad937
    }

    private fun setupZegoUIKit(userID: String) {
        val application: Application = application
        val appID: Long =1686344549
        val appSign: String = "9e824749da43c787d5d44040410b5904687394bc40bbe9d6f47aa63ca18ad937"
        val userName: String = userID
        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
        ZegoUIKitPrebuiltCallService.init(application,appID,appSign,userID,userName,callInvitationConfig)
    }

    override fun onDestroy() {
        super.onDestroy()
        ZegoUIKitPrebuiltCallService.unInit()
    }

}