---
title: Meta.loadStoryboardSummary - MetaverseSDK
---

[MetaverseSDK](../../index.html) / [io.gometa.sdk](../index.html) / [Meta](index.html) / [loadStoryboardSummary](./load-storyboard-summary.html)

# loadStoryboardSummary

`@JvmStatic fun loadStoryboardSummary(storyboardId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`Result`](../-result/index.html)`<StoryboardSummary>>`

Load the [StoryboardSummary](#) for a given storyboard ID. Note that the SDK performs no,
caching. It is up the the host app to cache and re-use any data they'd like.

### Parameters

`storyboardId` - The ID of the storyboard to load.

**Return**
[LiveData](#) to report the state and result of the load operation.

