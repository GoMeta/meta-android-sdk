---
title: Meta.initialize - Metaverse SDK
---

[Metaverse SDK](../../index.html) / [io.gometa.metaverse.storyboard.sdk](../index.html) / [Meta](index.html) / [initialize](./initialize.html)

# initialize

`@JvmStatic fun initialize(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, apiKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Initialize the SDK. This method is automatically called when rendering a storyboard, but may
be called manually by the host app prior for the purpose of making other API calls such as
[loadStoryboardSummary](load-storyboard-summary.html).

When calling this endpoint, the application may pass it's API key. Alternatively, it may pass
null, at which point the SDK will attempt to locate the API key from the application
manifest's metadata `io.gometa.metaverse.sdk.API_KEY`.

### Parameters

`context` - The context used to initialize the SDK.

`apiKey` - An optional API key. If `null`, the SDK will search in the application's
manifest.