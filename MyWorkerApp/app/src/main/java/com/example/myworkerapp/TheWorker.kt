package com.example.myworkerapp

import android.content.Context
import android.os.SystemClock
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class TheWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.wtf("MyWorker", "MyWorker - STARTED")
        SystemClock.sleep(15000) // do work here
        Log.wtf("MyWorker", "MyWorker - DONE")
        return Result.success()
    }
}
