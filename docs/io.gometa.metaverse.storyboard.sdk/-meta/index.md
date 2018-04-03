---
title: Meta - Metaverse SDK
---

[Metaverse SDK](../../index.html) / [io.gometa.metaverse.storyboard.sdk](../index.html) / [Meta](./index.html)

# Meta

`object Meta`

The primary entry point to the Metaverse SDK.

To start a storyboard, it is recommended that you first identify the user. This can be done via
a unique identifier available to the host app such as the user's ID, or any other unique stirng
passed to [Meta.identify](identify.html). Alternatively, you may chose for the SDK to identify the user via a
local unique string which identifies this app instance (this is done by passing `null` to
[Meta.identify](identify.html)).

Next, get an intent for a storyboard by calling [Meta.getStoryboardIntent](get-storyboard-intent.html) and start it via
either [Context.startActivity](https://developer.android.com/reference/android/content/Context.html#startActivity(android.content.Intent)), [Activity.startActivity](https://developer.android.com/reference/android/app/Activity.html#startActivity(android.content.Intent)), or [Activity.startActivityForResult](https://developer.android.com/reference/android/app/Activity.html#startActivityForResult(android.content.Intent, int)).
If started for result, the returned `resultCode` may be either [Activity.RESULT_CANCELED](https://developer.android.com/reference/android/app/Activity.html#RESULT_CANCELED) or
[Activity.RESULT_OK](https://developer.android.com/reference/android/app/Activity.html#RESULT_OK). Additionally, the `data` field will contain an intent with the following
extras:

* [Meta.StoryboardResult.STORYBOARD_ID](-storyboard-result/-s-t-o-r-y-b-o-a-r-d_-i-d.html) (`String`) - the ID of the storyboard that finished.
* [Meta.StoryboardResult.CLOSE_REASON](-storyboard-result/-c-l-o-s-e_-r-e-a-s-o-n.html) (`int`) - the reason the storyboard finished (one of
[Meta.CloseReason](-close-reason/index.html)).

### Types

| [CloseReason](-close-reason/index.html) | `object CloseReason`<br>The various reasons a storyboard's activity might finish. These are the possible values that may be returned via the [Meta.StoryboardResult.CLOSE_REASON](-storyboard-result/-c-l-o-s-e_-r-e-a-s-o-n.html) key. |
| [StoryboardResult](-storyboard-result/index.html) | `object StoryboardResult`<br>The various keys returned by the storyboard activity's `data` [Intent](https://developer.android.com/reference/android/content/Intent.html). |

### Functions

| [getStoryboardIntent](get-storyboard-intent.html) | `fun getStoryboardIntent(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, storyboardId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)<br>Creates an intent for the storyboard activity for the given storyboard ID. |
| [identify](identify.html) | `fun identify(userId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Identifies the user in the scope of the provided API key. |
| [initialize](initialize.html) | `fun initialize(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, apiKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initialize the SDK. This method is automatically called when rendering a storyboard, but may be called manually by the host app prior for the purpose of making other API calls such as [loadStoryboardSummary](load-storyboard-summary.html). |
| [loadStoryboardSummary](load-storyboard-summary.html) | `fun loadStoryboardSummary(storyboardId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`Result`](../-result/index.html)`<`[`StoryboardSummary`](../../io.gometa.metaverse.storyboard.sdk.model/-storyboard-summary/index.html)`>>`<br>Load the [StoryboardSummary](../../io.gometa.metaverse.storyboard.sdk.model/-storyboard-summary/index.html) for a given storyboard ID. Note that the SDK performs no, caching. It is up the the host app to cache and re-use any data they'd like. |

