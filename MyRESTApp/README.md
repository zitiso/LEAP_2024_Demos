---------------------------------------------------------------------------------------------------------
# REST Demo Steps

1. **Set up the web service:**
    - 1. Download the teamservice.jar:
            - [https://github.com/zitiso/LEAP_2024_Demos/team-service.jar](https://github.com/zitiso/LEAP_2024_Demos/teamservice.jar)
      2. Open a terminal to the directory where the team-service.jar was saved
      3. Run the application:
            - In the terminal window, execute this command:

              - java -jar team-service.jar

      4. Verify it is running:
            - <http://localhost:8000/swagger-ui.html>
            - <http://localhost:8000/v2/api-docs>

1. **Create new application:**
    - RESTDemoApp
2. **Add dependencies using ‘File > Project Structure > Dependencies’:**
    1. com.squareup.retrofit2 -> retrofit@2.11.0
    2. com.squareup.retrofit2 -> converter-gson@2.11.0
3. **Code application:**
    1. Team
    2. TeamService – uses Team
    3. TeamViewModel – uses TeamService, Team
    4. TeamView – uses TeamViewModel, Team
    5. InsertTeamView – uses TeamViewModel, Team
    6. MainActivity – uses TeamViewModel, TeamView, InsertTeamView
4. **Update the AndroidManifest.xml:**
    - Add uses-permission: _android.permission.INTERNET_
    - add to the top of the “application” tag: _android:usesCleartextTraffic="true"_
5. **Test:**
    1. Check that the service is still running
    2. Run application on the emulator

### More Information
- [Using Retrofit for Network Calls in Android](https://dashwave.io/blog/using-retrofit-for-network-calls-in-android)
