------------------------------------------------------------
# Intent: Demo Steps
1. **Create two new applications:**
    - One = Receiver
    - Other = Sender
2. **Code Receiver application:**
    - Greeting composable – leave as is
    - MainActivity – check for the intent with the name to display
        - Use the input if available
        - else pass in “Nothing sent to me” to the Greeting composable
        - Update the manifest.xml to declare the intent-filter for receiving intents:
            - &lt;intent-filter&gt;  
                &lt;action android:name="android.intent.action.MAIN" /&gt;  
                &lt;category android:name="android.intent.category.LAUNCHER" /&gt;  
                <br/><**action android:name="ACTION_SHOWNAME"**/>  
                <**category android:name="android.intent.category.DEFAULT"** />  
                &lt;/intent-filter&gt;
3. **Code sender application:**
    - Sender composable –
        - Create an intent with a name to send to the receiver using the filters defined for it
        - Create a button that when clicked will send the intent to start the receiver
    - MainActivity – load the Sender composable
4. **Test:**
    - Run the receiver so that it is installed and verified working
    - Stop the receiver app but leave it installed
    - Run the sender on same emulator
    - Click its button:
        - Result should be the receiver is started and displays the name the sender sent in the intent object



Source ~ <https://developer.android.com/guide/components/intents-filters>
