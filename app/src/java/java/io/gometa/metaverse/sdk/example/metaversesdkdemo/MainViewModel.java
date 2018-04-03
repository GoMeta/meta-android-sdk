package io.gometa.metaverse.sdk.example.metaversesdkdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.HashMap;

import io.gometa.metaverse.storyboard.sdk.Meta;
import io.gometa.metaverse.storyboard.sdk.Result;
import io.gometa.metaverse.storyboard.sdk.model.StoryboardSummary;

/**
 *
 */
public class MainViewModel extends ViewModel {

    private final HashMap<String, LiveData<Result<StoryboardSummary>>> mStoryboardSummaryMap =
            new HashMap<>();
    private final HashMap<String, MutableLiveData<String>> mStoryboardIds =
            new HashMap<>();

    @NonNull
    /* package */ LiveData<Result<StoryboardSummary>> get(String storyboardId) {
        LiveData<Result<StoryboardSummary>> value = mStoryboardSummaryMap.get(storyboardId);
        if (value == null) {
            value = Transformations.switchMap(getStoryboardId(storyboardId),
                    Meta::loadStoryboardSummary);
            mStoryboardSummaryMap.put(storyboardId, value);
        }
        return value;
    }

    /* package */ void loadStoryboardSummary(String storyboardId) {
        getStoryboardId(storyboardId).setValue(storyboardId);
    }

    @NonNull
    private MutableLiveData<String> getStoryboardId(String storyboardId) {
        MutableLiveData<String> value = mStoryboardIds.get(storyboardId);
        if (value == null) {
            value = new MutableLiveData<>();
            mStoryboardIds.put(storyboardId, value);
        }
        return value;
    }
}
