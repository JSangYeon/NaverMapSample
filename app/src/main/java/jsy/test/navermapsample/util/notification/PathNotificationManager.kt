package jsy.test.navermapsample.util.notification

import android.app.NotificationChannel
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import jsy.test.navermapsample.R
import javax.inject.Inject


class PathNotificationManager @Inject constructor(@ApplicationContext private val context: Context) {

    private var CHANNEL_ID = ""

    private var notiIndex = 0;

    private val strNotificationChannel = context.getString(R.string.path_notification_channel);

    fun testNotification(){

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("textTitle")
            .setContentText("textContent")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Get an instance of the NotificationManager service
        val notificationManager = NotificationManagerCompat.from(context)
        val channel = createNotificationChannel()

        if(channel!=null) notificationManager.createNotificationChannel(channel)

        notificationManager.notify(1234, builder.build())


    }

    fun pathSavedNotify(departurePlaceName : String, destinationName : String){
        notiIndex +=1;
        CHANNEL_ID = strNotificationChannel + notiIndex

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(context.getString(R.string.complete_saved_path))
            .setContentText("${departurePlaceName}에서 ${destinationName}까지 가는 경로가 저장되었습니다.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Get an instance of the NotificationManager service
        val notificationManager = NotificationManagerCompat.from(context)
        val channel = createNotificationChannel()

        if(channel!=null) notificationManager.createNotificationChannel(channel)

        notificationManager.notify(notiIndex, builder.build())


    }

    private fun createNotificationChannel() : NotificationChannel? {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.path_notification_channel_Name)
            val descriptionText = context.getString(R.string.path_notification_channel_description)
            val importance = IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            return channel
        }
        return null

    }



}