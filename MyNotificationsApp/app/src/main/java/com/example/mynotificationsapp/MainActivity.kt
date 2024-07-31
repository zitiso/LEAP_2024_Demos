package com.example.mynotificationsapp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.mynotificationsapp.ui.theme.MyNotificationsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the channel created
        myCreateNotificationChannel(
            this,
            "com.example.MyNotificationsApp",
            "Channel 1",
            "Channel for My Notifications App"
        )

        setContent {
            MyNotificationsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNotifier()
                }
            }
        }
    }
}

@Composable
fun MyNotifier() {
    val context = LocalContext.current

    // Check the permission status
    // Post Notification permission - but only if running in an android version 33 or higher
    var hasNotificationPermission by remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            mutableStateOf(
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                )
                        == PackageManager.PERMISSION_GRANTED
            )
        } else mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Set up the modal to launch if permissions have not be set by the user
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted ->
                hasNotificationPermission = isGranted
            }
        )

        Button(
            onClick = {
                //Only post the notification if permission is granted
                if (hasNotificationPermission) {
                    postNotification(context)
                } else {
                    //Request for permission if device is Android 33 or higher
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }
            })
        {
            if (hasNotificationPermission) {
                Text(text = "Notify Now")
            } else {
                Text(text = "Grant Permission")
            }
        }
        if (hasNotificationPermission) {
            Text(text = "WooHoo!! I can post for you!!")
        } else {
            Text(text = "You need to grant permission.")
        }
    }
}

// When it is time, this function will create the pending intent
// And use it to create the notification which is then posted
var notificationId = 0
private fun postNotification(context: Context) {

    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent: PendingIntent? = TaskStackBuilder.create(context).run {
        addNextIntent(intent)
        getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    var notification = NotificationCompat.Builder(context, "com.example.MyNotificationsApp_2")
        .setSmallIcon(R.drawable.icons8_notification_100) //
        .setContentTitle("Notifications App")
        .setContentText("${notificationId} : This is important!")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()


    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, notification)
    }
    notificationId++

}

// Invoked at application start from onCreate
fun myCreateNotificationChannel(
    context: Context,
    channelId: String,
    channelName: String,
    channelDescription: String
) {
    // Create the NotificationChannel.
    val channel = NotificationChannel(
        channelId,
        channelName,
        NotificationManager.IMPORTANCE_DEFAULT,
    )
    channel.description = channelDescription

    // Register the channel with the system. You can't change the importance
    // or other notification behaviors after this.
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    notificationManager.createNotificationChannel(channel)
}
