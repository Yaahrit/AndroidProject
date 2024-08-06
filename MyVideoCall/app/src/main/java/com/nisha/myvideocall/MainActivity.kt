package com.nisha.myvideocall

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class MainActivity : AppCompatActivity() {
    private  lateinit var targetUserId:EditText
    private lateinit var myUserIdText:TextView
    private lateinit var videoCallButton:ZegoSendCallInvitationButton
    private lateinit var voiceCallButton:ZegoSendCallInvitationButton


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        targetUserId = findViewById(R.id.targetUserId)
        myUserIdText = findViewById(R.id.myUserIdText)
        videoCallButton = findViewById(R.id.videoCallButton)
        voiceCallButton = findViewById(R.id.voiceCallButton)

        val myUserId = intent.getStringExtra("userID")
        myUserIdText.text = "HI $myUserId, \n Whom do you want to Call ?"
        targetUserId.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val targetUserID = targetUserId.text.toString()
                if(targetUserID.isNotEmpty()){
                    startVideoCall(targetUserID)
                    startVoiceCall(targetUserID)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun startVideoCall(targetUserID:String){
        val targetUserName:String = targetUserID
        videoCallButton.setIsVideoCall(true)
        videoCallButton.resourceID="zego_uikit_call"
        videoCallButton.setInvitees(listOf(ZegoUIKitUser(targetUserID,targetUserName)))
    }

    private fun startVoiceCall(targetUserID:String){
        val targetUserName:String = targetUserID
        voiceCallButton.setIsVideoCall(false)
        voiceCallButton.resourceID="zego_uikit_call"
        voiceCallButton.setInvitees(listOf(ZegoUIKitUser(targetUserID,targetUserName)))
    }

}