package com.example.mybroadcastapp

import android.Manifest
import androidx.compose.material3.MaterialTheme



import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import com.example.mybroadcastapp.ui.theme.MyBroadcastAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //To post a notification, we need a channel
        createNotificationChannel(
            this,
            "com.example.mybroadcastapp.notifications",
            "broadcasts",
            "Channel for broadcast notifications"
        )
        setContent {
            MyBroadcastAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BroadcastEventHandler()
                }
            }
        }
    }
}

@Composable
fun BroadcastEventHandler() {
    Text("Broadcast Receiver - Toggle Airplane Mode!!")

    val context = LocalContext.current
    val systemAction = Intent.ACTION_AIRPLANE_MODE_CHANGED//broadcaster of interest for the intent filter e.g. Intent.ACTION_AIRPLANE_MODE_CHANGED

    GetPermission(context)

    //DisposableEffect is used for side-effects that need to be fixed up once the keys change or if the composable departs the composition.
    DisposableEffect(context, systemAction ) {

        //Object to receive from broadcaster
        //intent filter declares what types of broadcasts we can handle.
        val intentFilter = IntentFilter(systemAction)

        //To be a receiver, you need to implement the onReceive function
        //The broadcaster fires its intent, and the system calls this to pass in the intent
        val broadcastReceiver : BroadcastReceiver = object :BroadcastReceiver() {

            override fun onReceive(context: Context, intent: Intent) {
                // Using the intent, retrieve the data that was put on the intent - do you remember how?
                // What data does your broadcaster return? How would you find out?

                //Once we have the data, we would post our notification
                doNotify(context, "This should include the data from the broadcaster")
            }
        }
        //Register to the system your interest in the chosen broadcaster
        context.registerReceiver(broadcastReceiver,intentFilter)
        onDispose { context.unregisterReceiver(broadcastReceiver) }
    }
}

@Composable
fun GetPermission(context: Context){
    //Check the permission status to post notifications
    //Post Notification permission - but only if running in an android version 33 or higher
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

    // Show the button to ask user to allow notifications if needed
    if (!hasNotificationPermission && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Set up the modal to launch if permissions have not be set by the user
            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission(),
                onResult = { isGranted ->
                    hasNotificationPermission = isGranted
                }
            )
            Button(
                onClick = {
                    launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            )
            {
                Text(text = "Click to set permissions")
            }

        }
    }
}

// Keep track of the count in between function calls
var notificationId = 0

// Create and post the message of the event
fun doNotify(context: Context, message: String) {

    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent: PendingIntent? = TaskStackBuilder.create(context).run {
        addNextIntent(intent)
        getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    var notification =
        NotificationCompat.Builder(context, "com.example.mybroadcastapp.notifications")
            .setSmallIcon(R.drawable.ic_smiley_face_icon)
            .setContentTitle("Broadcast Received")
            .setContentText("${notificationId}: ${message}")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, notification)
    }

    notificationId++
}

//Our app will post notifications about the broadcast event
//Function to create the channel to post notifications
//This is called in the Activity's 'onCreate'
fun createNotificationChannel(
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

    // Register the channel with the system.
    // You can't change the importance or other notification behaviors after this.
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)

}

