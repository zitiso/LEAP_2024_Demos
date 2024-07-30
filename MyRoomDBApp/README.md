-----------------------------------------------------------------------------
# ROOM Database Demo Steps

**1. Create a new application:**
    - RoomDBDemoApp
**2. Configure Plug-ins**
**3. Configure Dependencies:**
    - See next page for details
**4. Code application:**
    1. Team class
    2. TeamDAO – uses Team class
    3. TeamRepository – uses TeamDao
    4. TeamDatabase – uses TeamDao
    5. TeamViewModel – uses Team, TeamDao, TeamRepository, TeamDatbase
    6. TeamView - uses TeamViewModel, Team
    7. InsertTeamView – uses TeamViewModel, Team
    8. TeamViewModelFactory – uses TeamViewModel
    9. MainActivity – uses TeamViewModelFactory, TeamView, InsertTeamView
**5. Test application**

**Configure dependencies:**

1. **project gradle.build.kt:**

- plugins **{  
    **alias(_libs_._plugins_._androidApplication_) _apply_ **false  
    **alias(_libs_._plugins_._jetbrainsKotlinAndroid_) _apply_ **false  
    **id(**"com.google.devtools.ksp"**) _version_ **"1.9.0-1.0.12"** _apply_ **false  
    }**
- Click ‘Sync Now’

1. **app gradle.build.kt:**

- plugins **{  
    **alias(_libs_._plugins_._androidApplication_)alias(_libs_._plugins_._jetbrainsKotlinAndroid_)id(**"com.google.devtools.ksp"**)**  
    }**
- copy and paste the following into the “dependencies” section at the top**<br/>val** roomVersion = **"2.6.1"  
    <br/>**_annotationProcessor_(**"androidx.room:room-compiler:$**roomVersion**"**)_ksp_(**"androidx.room:room-compiler:$**roomVersion**"**)
- Use File>Project Structure > Dependencies tool to add the following

androidx.room -> room-runtime@2.6.1

androidx.lifecycle -> lifecycle-viewmodel-compose @2.8.4

androidx.compose.runtime -> runtime-livedata @1.6.8

androidx.constraintlayout -> constraintlayout-compose@1.0.1

- Click ‘Sync Now’
- It should look like this:

_dependencies_ **{**  
**val** roomVersion = **"2.6.1"**  
<br/>_annotationProcessor_(**"androidx.room:room-compiler:$**roomVersion**"**)  
_ksp_(**"androidx.room:room-compiler:$**roomVersion**"**)  
<br/>_implementation_(_libs_._androidx_._room_._runtime_)  
_implementation_(_libs_._androidx_._lifecycle_._viewmodel_._compose_)  
_implementation_(_libs_._androidx_._runtime_._livedata_)  
_implementation_(_libs_._androidx_._constraintlayout_._compose_)

....

### More Information
- [How to Build a Simple Note Android App using MVVM and Room Database](https://www.geeksforgeeks.org/how-to-build-a-simple-note-android-app-using-mvvm-and-room-database/)
