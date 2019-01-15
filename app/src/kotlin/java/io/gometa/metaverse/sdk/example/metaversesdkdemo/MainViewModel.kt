package io.gometa.metaverse.sdk.example.metaversesdkdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.gometa.sdk.Meta
import io.gometa.sdk.Result
import io.gometa.sdk.model.StoryboardSummary

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