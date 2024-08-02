-----------------------------------------------------------------
# Notifications: Demo Steps
1. **Create new application:**
    - NotifyDemoApp
2. **Add icon image file to res folder:**
    - Download an image:
        - <https://icons8.com/icons/set/notification>
    - Use underscores not hyphens for the file name:
        - File-based resource names must contain only lowercase a-z, 0-9, or underscore
    - Import using the ‘Resource Manager’ tool:
        - click ‘+’ and choose ‘Import Drawables’
        - choose file to complete task
        - In your code, to reference the image use ‘R.drawable’
            - Be certain that your imports do _NOT_ have:
                - androidx.compose.ui.R
3. **Code application:**
    - MyNotify composable:
        - Get runtime permission to post to status bar
        - Button to launch permission modal if needed, else creates and posts notification
    - MainActivity class
        - create a notification channel in the ‘onCreate’
4. **Update AndroidManifest.xml:**
    - add uses permission: POST_NOTIFICATIONS
5. **Test:**
    - Toggle permission on and off using the phones “Settings > Apps” tool

Source ~ <https://developer.android.com/develop/ui/views/notifications>
