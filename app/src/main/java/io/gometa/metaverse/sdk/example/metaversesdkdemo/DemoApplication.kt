package io.gometa.metaverse.sdk.example.metaversesdkdemo

import androidx.multidex.MultiDexApplication
import io.gometa.sdk.Meta
import timber.log.Timber

/**
 *
 */
class DemoApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        Meta.initialize(this, null)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}