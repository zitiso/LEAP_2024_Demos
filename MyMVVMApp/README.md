-------------------------------------------------------------------------------------------
# MVVM: Demo Steps

### Create new application:
- **Application Name:** RESTDemoApp

### Add dependencies using ‘File > Project Structure > Dependencies’:
- **androidx.lifecycle:** lifecycle-viewmodel-compose@2.8.4

### Code application:
1. **Team:** 
   - Data class in the data folder.
2. **TeamViewModel:** 
   - Uses Team.
3. **TeamView:** 
   - Uses TeamViewModel and Team.
4. **InsertTeamView:** 
   - Uses TeamViewModel and Team.
5. **MainActivity:** 
   - Uses TeamView and InsertTeamView.
6. **Test**

### More Information
- [Geeks for Geeks: MVVM (Model View ViewModel) Architecture Pattern in Android](https://www.geeksforgeeks.org/mvvm-model-view-viewmodel-architecture-pattern-in-android/)



