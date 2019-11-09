package br.com.vinimanara.chatboardapp.utils

import android.app.Notification
import android.app.NotificationChannel
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi

class NotificationManagerUtils(private val context: Context) {
    companion object {
        private val CHANNEL_ID = "YOUR_CHANNEL_ID"
        private val CHANNEL_NAME = "Miscellaneous"
        private val CHANNEL_DESCRIPTION = "description"
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMainNotificationId(): String {
        return CHANNEL_ID
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun createMainNotificationChannel() {
        val id = CHANNEL_ID
        val name = CHANNEL_NAME
        val description = CHANNEL_DESCRIPTION
        val importance = android.app.NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id, name, importance)
        mChannel.description = description
        mChannel.enableLights(true)
        mChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
        mNotificationManager.createNotificationChannel(mChannel)
    }
}