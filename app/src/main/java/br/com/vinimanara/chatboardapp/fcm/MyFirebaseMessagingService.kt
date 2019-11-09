package br.com.vinimanara.chatboardapp.fcm

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import br.com.vinimanara.chatboardapp.R
import br.com.vinimanara.chatboardapp.utils.DatabaseUtil
import br.com.vinimanara.chatboardapp.utils.NotificationManagerUtils
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    companion object {
        private const val notificationID = 1000
    }
    override fun onNewToken(s: String) {
        super.onNewToken(s)
        DatabaseUtil.saveToken(s)
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        configureNotification(remoteMessage, getLastScreen())
    }
    private fun getLastScreen(): PendingIntent {
        val nIntent = packageManager.getLaunchIntentForPackage(packageName)
        return PendingIntent.getActivity(
            this, 0, nIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
    private fun configureNotification(remoteMessage: RemoteMessage, pendingIntent:
    PendingIntent?) {
        val title = remoteMessage.notification?.title ?: getString(R.string.app_name)
        val message = remoteMessage.notification?.body ?: ""
        showNotification(pendingIntent, title, message)
    }
private fun createNotificationCompatBuilder(context: Context): NotificationCompat.Builder {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationCompat.Builder(context,
            NotificationManagerUtils(context).getMainNotificationId())
    } else {
        NotificationCompat.Builder(context)
    }
}

private fun showNotification(pendingIntent: PendingIntent?, title: String, message: String) {
    val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val mBuilder =
        createNotificationCompatBuilder(applicationContext)
            .setContentTitle(title)
            .setSound(defaultSoundUri)
            .setStyle(NotificationCompat.BigTextStyle())
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
    val mNotificationManager =
        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
    mNotificationManager.notify(notificationID, mBuilder.build())
}
}