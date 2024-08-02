--------------------------------------------------------
# Brodcast Receiver: Demo Steps
1. **Create application:**
    - BroadcastDemoApp
2. **Code application:**
    - Create a POST_NOTIFICATION channel
    - Create a doNotify function to post notifications of broadcast events
    - GetPermission composable – launches system’s permission dialog
    - BroadcastEventHandler composable to receive airplane mode events:
        - Calls GetPermission
        - Creates and registers broadcast receiver
        - Upon receiver the registered event, calls doNotify function
    - MainActivity – calls BrodcastEventHandler
    - AndroidManifest:
        - uses the permission: POST_NOTIFICATIONS
3. **Test:**
    - Toggle airplane mode to trigger event

Source ~ <https://medium.com/@khush.panchal123/understanding-broadcast-receivers-in-android-044fbfaa1330>
