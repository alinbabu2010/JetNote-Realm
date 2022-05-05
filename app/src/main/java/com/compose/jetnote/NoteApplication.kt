package com.compose.jetnote

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration

@HiltAndroidApp
class NoteApplication : Application() {

    private val realmVersion = 1L

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

}