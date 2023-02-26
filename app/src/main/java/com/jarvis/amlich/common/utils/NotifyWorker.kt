/*
 * Copyright © OMRON HEALTHCARE Co., Ltd. 2020. All rights reserved.
 */

package com.jarvis.amlich.common.utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class NotifyWorker(private val appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    companion object {
        const val KEY_ACTION_REMINDER = "KEY_ACTION_REMINDER"
        const val DATA_ACTION_REMINDER = "DATA_ACTION_REMINDER"
    }


    @SuppressLint("CheckResult")
    override fun doWork(): Result {
        val title = inputData.getString(KEY_ACTION_REMINDER)
        val content = inputData.getString(DATA_ACTION_REMINDER)
        NotificationUtils.createNotification(appContext, title, content)
        return Result.success()
    }


}
