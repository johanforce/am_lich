/*
 * Copyright © OMRON HEALTHCARE Co., Ltd. 2020. All rights reserved.
 */

package com.jarvis.amlich.common.utils

import androidx.work.*
import com.jarvis.amlich.di.App
import java.util.*
import java.util.concurrent.TimeUnit

object AlarmUtils {

    const val TAG_NOTE = "TAG_NOTE"

    /**
     * This is the method to set BP reminder to work manager
     * @param time is time will notification reminder
     */
    fun schedulePeriodicWork(tag: String, time: Long, title: String, note: String) {
        val workConstraints = Constraints.Builder().build()
        // using Data.Builder
        val inputData = Data.Builder()
            .putString(NotifyWorker.KEY_ACTION_REMINDER, title)
            .putString(NotifyWorker.DATA_ACTION_REMINDER, note)
            .build()

        val calendar = Calendar.getInstance()
        val nowMillis = calendar.timeInMillis
        calendar.timeInMillis = time
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(Calendar.DATE, 1);
        }
        val diff: Long = calendar.timeInMillis - nowMillis

        // declare repeating work at specific time of day
        val periodicWork = PeriodicWorkRequestBuilder<NotifyWorker>(1, TimeUnit.DAYS)
            .addTag(tag)
            .setConstraints(workConstraints)
            .setInputData(inputData)
            .setInitialDelay(diff, TimeUnit.MILLISECONDS)
            .build()

        // register repeated work on time
        WorkManager.getInstance(App.application).enqueue(periodicWork)
    }

    fun scheduleOneTimeWork(
        tag: String,
        delayMillisecond: Long,
        keyAction: String? = null,
        dataAction: String? = null,
    ) {
        val delay = (delayMillisecond / 1000) * 1000
        val workConstraints = Constraints.Builder().build()
        // using Data.Builder
        val inputData = Data.Builder()
            .putString(NotifyWorker.KEY_ACTION_REMINDER, keyAction)
            .putString(NotifyWorker.DATA_ACTION_REMINDER, dataAction)
            .build()

        // declare one time work at specific time
        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<NotifyWorker>()
            .addTag(tag)
            .setConstraints(workConstraints)
            .setInputData(inputData)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()

        // register work on time
        WorkManager.getInstance(App.application).enqueue(oneTimeWorkRequest)
    }

    /**
     * This method is used to cancel notification
     * @param workTag is tag of all works will be cancel
     */
    fun cancelWork(workTag: String) {
        WorkManager.getInstance(App.application).cancelAllWorkByTag(workTag)
    }
}
