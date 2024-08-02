------------------------------------------------------------------
# Content Provider: Demo Steps
1. **Create new application:**
    - ContentDemoApp
2. **Phase 1 - Code application:**
    - Create 3 composables
        - MyContent
            - Request permission to read Contacts
            - call composable based on granted permission
        - Granted composable -if permission granted
        - NotGranted composableone - if permission not granted
    - MainActivity – call the MyContent
    - AndroidManifest
        - Add uses permission: READ_CONTACTS
3. **Test:**
    - Toggle permissions to verify correct page shows
    - When done, leave app with permission on
    - Stop the application
4. **Phase 2 - Code application:**
    - Contact data class:
        - name and phoneNumber
    - loadContacts function
        - connect to the Contacts Content Provider to retrieve contacts
    - Granted composable:
        - Use the loadContacts function and display contacts’ name and phone number
5. **Test:**
    - Add contacts:
        - Open the Contacts app on the emulator
        - Create 2 contacts – name, company, phone, email
    - Run the app

Source ~ <https://data-flair.training/blogs/content-provider-in-android/>
