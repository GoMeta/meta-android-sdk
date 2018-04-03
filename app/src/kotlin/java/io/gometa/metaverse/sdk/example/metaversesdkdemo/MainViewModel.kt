package io.gometa.metaverse.sdk.example.metaversesdkdemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import io.gometa.metaverse.storyboard.sdk.Meta
import io.gometa.metaverse.storyboard.sdk.Result
import io.gometa.metaverse.storyboard.sdk.model.StoryboardSummary

/**
 *
 */
class MainViewModel : ViewModel() {
    private val storyboardSummaryMap = HashMap<String, LiveData<Result<StoryboardSummary>>>()
    private val storyboardIds = HashMap<String, MutableLiveData<String>>()

    operator fun get(storyboardId: String): LiveData<Result<StoryboardSummary>> =
        storyboardSummaryMap[storyboardId] ?:
        Transformations.switchMap(getStoryboardId(storyboardId),
            { Meta.loadStoryboardSummary(it) }).also { storyboardSummaryMap[storyboardId] = it }

    fun loadStoryboardSummary(storyboardId: String) {
        getStoryboardId(storyboardId).value = storyboardId
    }

    private fun getStoryboardId(storyboardId: String): MutableLiveData<String> =
        storyboardIds[storyboardId] ?: MutableLiveData<String>().also {
            storyboardIds[storyboardId] = it
        }
}