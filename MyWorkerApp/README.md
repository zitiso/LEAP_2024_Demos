--------------------------------------------------------------
# Worker: Demo Steps

1. **Create new application:**
    - WorkerDemoApp
2. **Add dependencies using ‘File > Project Structure > Dependencies’:**
    - androidx.work -> workruntime-ktx @2.9.0
3. **Code application:**
    - TheWorker class:
        - code is work to be done in background
        - includes logging out its status
    - GetWorkDone composable function:
        - Defines workRequests using TheWorker
        - Connects to WorkerManager to add workRequests to queue
    - MainActivity class – calls GetWorkDone
4. **Test:**
    - Watch the logcat to see the messages from TheWorker

**Source:** 
**[Schedule tasks with WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager)**
