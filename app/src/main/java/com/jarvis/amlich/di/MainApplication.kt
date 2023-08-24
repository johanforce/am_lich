package com.jarvis.amlich.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.jarvis.amlich.R
import com.jarvis.amlich.common.firebase.FireBaseLogEvents
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        App.context = this
        App.application = this
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(dataModule, repositoryModule, useCaseModule, viewModelModule)
        }

        initLogEventFirebase()
        initRemoteConfigFirebase()
    }

    private fun initLogEventFirebase() {
        FireBaseLogEvents.init(this)
    }

    private fun initRemoteConfigFirebase() {
        App.remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        App.remoteConfig.setConfigSettingsAsync(configSettings)
        App.remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        App.remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val updated = task.result
                Log.d("TAG", "Config params updated: $updated")
                Toast.makeText(
                    this, "Fetch and activate succeeded",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Fetch failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@SuppressLint("StaticFieldLeak")
object App {
    lateinit var context: Context
    lateinit var application: MainApplication
    lateinit var remoteConfig: FirebaseRemoteConfig
}
