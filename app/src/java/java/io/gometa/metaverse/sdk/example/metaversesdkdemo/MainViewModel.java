package io.gometa.metaverse.sdk.example.metaversesdkdemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.annotation.NonNull;

import java.util.HashMap;

import io.gometa.sdk.Meta;
import io.gometa.sdk.Result;
import io.gometa.sdk.model.StoryboardSummary;

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
