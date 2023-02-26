package com.jarvis.amlich.common.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.jarvis.amlich.common.utils.NotificationUtils

class MessagingService : FirebaseMessagingService() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data = remoteMessage.data
        val dataJson = Gson().toJson(data)
        Log.d("FCM", "Message: " + remoteMessage.notification?.title)
        Log.d("FCM", "Message: " + remoteMessage.notification?.body)
        Log.d("FCM", "Message: " + remoteMessage.notification?.imageUrl)
        NotificationUtils.createNotification(
            this,
            remoteMessage.notification?.title,
            remoteMessage.notification?.body
        )
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d("FCM", "Token: $p0")
    }
}