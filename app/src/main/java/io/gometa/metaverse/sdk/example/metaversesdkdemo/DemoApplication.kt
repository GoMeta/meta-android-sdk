package io.gometa.metaverse.sdk.example.metaversesdkdemo

import android.support.multidex.MultiDexApplication
import io.gometa.metaverse.storyboard.sdk.Meta
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