-----------------------------------------------------------------------------
# ROOM Database Demo Steps

1. **Create a new application:**
    - RoomDBDemoApp
2. **Configure Plug-ins**
   - See below for details
4. **Configure Dependencies:**
    - See below for details
5. **Code application:**
    1. Team class
    2. TeamDAO – uses Team class
    3. TeamRepository – uses TeamDao
    4. TeamDatabase – uses TeamDao
    5. TeamViewModel – uses Team, TeamDao, TeamRepository, TeamDatbase
    6. TeamView - uses TeamViewModel, Team
    7. InsertTeamView – uses TeamViewModel, Team
    8. TeamViewModelFactory – uses TeamViewModel
    9. MainActivity – uses TeamViewModelFactory, TeamView, InsertTeamView
5.**Test application**

**Configure dependencies:**

- **project gradle.build.kt:**

```
plugins {
 	alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
}
```
- Click ‘Sync Now’

- **app gradle.build.kt:**

```
plugins {
    alias(libs.plugins.androidApplication)
 	alias(libs.plugins.jetbrainsKotlinAndroid)
	id("com.google.devtools.ksp")
}
```
- Copy and paste the following into the “dependencies” section at the top
```
 val roomVersion = "2.6.1"

 annotationProcessor("androidx.room:room-compiler:$roomVersion")
 ksp("androidx.room:room-compiler:$roomVersion")
      
 ```
- Use **File>Project Structure > Dependencies** tool to add the following:
  
```
androidx.room -> room-runtime@2.6.1

androidx.lifecycle -> lifecycle-viewmodel-compose @2.8.4

androidx.compose.runtime -> runtime-livedata @1.6.8

androidx.constraintlayout -> constraintlayout-compose@1.0.1
```

- Click ‘Sync Now’
- When done, it should look like this:
  
```
dependencies {
 	val roomVersion = "2.6.1"

 	annotationProcessor("androidx.room:room-compiler:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

	implementation(libs.androidx.room.runtime)
  	implementation(libs.androidx.lifecycle.viewmodel.compose)
  	implementation(libs.androidx.runtime.livedata)
  	implementation(libs.androidx.constraintlayout.compose)

...
}
```


### More Information
- [How to Build a Simple Note Android App using MVVM and Room Database](https://www.geeksforgeeks.org/how-to-build-a-simple-note-android-app-using-mvvm-and-room-database/)
