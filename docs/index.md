---
title: Metaverse SDK
---

[Metaverse SDK](./index.html)

![Meta Android SDK](logo.png?taw=true)

Render [Metaverse](https://gometa.io) experiences inside of your own app or framework. Build, test,
and iterate with Metaverse Studio  and Metaverse Browser, and then render in your own app.

[**Full Documentation**](https://gometa.github.io/meta-android-sdk/io.gometa.metaverse.storyboard.sdk/-meta/index.html)

## Prerequisites

* Android API 19 or higher
* Create a Metaverse account and log in to [Metaverse Studio](https://studio.gometa.io)

## Gradle Setup

Add the GoMeta Maven repository to your root project's gradle.build:

``` groovy
allprojects {
    repositories {
        jcenter()
        mavenCentral()
        google()
        maven { url 'http://maven2.gometa.io' }
    }
    // If using a -SNAPSHOT build include the following if you'd like to get new builds as soon as
    // they come out.
    configurations.all {
        resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
    }
}
```

In your app's module's gradle.build, include the following dependency:

``` groovy
dependencies {
    implementation 'io.gometa.metaverse:sdk:1.0.0-alpha2'
}
```

Alternatively, replace `-alpha1` with `-SNAPSHOT` to get the latest build (may be unstable).

## Proguard

When using proguard nothing special needs to be done directly due to this SDK, though our SDK does
depend on both `Guava` and and `okhttp3` for which the proguard rules (as far as we've been able to
test) are:



``` proguard
# okhttp3 (https://github.com/square/okhttp#proguard)
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Guava
-dontwarn java.lang.ClassValue
-dontwarn afu.org.checkerframework.**
-dontwarn org.checkerframework.**
-dontwarn com.google.errorprone.annotations.**

# Metaverse SDK
-keep class io.gometa.metaverse.storyboard.sdk.internal.cloud.** { *; }
```

## Configure the SDK

To use the SDK we require an API key. You can find your API key in Metaverse Studio on the
[SDK Page](https://studio.gometa.io/sdk/keys). If any of the storyboards will show YouTube videos,
you'll also need to get a YouTube API key which you can do by
[Registering your app](https://developers.google.com/youtube/android/player/register).

The easiest way to provide both keys in your `AndroidManifest.xml` like so:

``` xml
<application>
    <meta-data android:name="io.gometa.metaverse.sdk.API_KEY" android:value="my_api_key"/>
    <meta-data android:name="io.gometa.metaverse.sdk.YOUTUBE_API_KEY" android:value="my_youtube_api_key"/>
</application>
```

## Load a storyboard's summary

The Metaverse SDK allows you to access your storyboard's summary details via an endpoint,
[Meta.loadStoryboardSummary](https://gometa.github.io/meta-android-sdk/io.gometa.metaverse.storyboard.sdk/-meta/load-storyboard-summary.html).
For this endpoint to work, [Meta.initialize](https://gometa.github.io/meta-android-sdk/io.gometa.metaverse.storyboard.sdk/-meta/initialize.html)
must be called prior. Normally this is done automatically when presenting a storyboard, but if your
app hasn't presented one yet you'll need to call the initialize method (usually in your app's
`Application` class' `onCreate` method). Note that you can also pass your API key via this endpoint,
passing `null` will default to searching for the API key in your application's manifest.

## Present a storyboard

Obtain an intent from `Meta.getStoryboardIntent(Context context, String storyboardId)` and launch it
as you would any other intent. If you'd like to receive a result from the storyboard, start the
intent with `Context.startActivityForResult(Intent,int)`.

## Get the result

If you've started the `StoryboardActivity` via `startActivityForResult` you'll get a call back to
your Activity or Fragment's `onActivityResult()`.

* If resultCode == `Activity.RESULT_OK` then the storyboard finished with either a completion or
suspend.
* If resultCode == `Activity.RESULT_CANCEL` then the storyboard finished with either the user
choosing to exit early (by either navigating back or selecting to exit from the menu) or the user
reporting the storyboard as broken/inappropriate.


### Get the close reason.



 In either case (`Activity.RESULT_OK` or `Activity.RESULT_CANCEL`) the `data` field of the result
 will be non-null. From the `data` Intent developers can obtain two pieces of information:

* `data.getStringExtra(Meta.StoryboardResult.STORYBOARD_ID)` to get the storyboard's ID.
* `data.getIntExtra(Meta.StoryboardResult.CLOSE_REASON)` to get the reason the storyboard ended.

## Identifying Users

If you would like to store persistent user data, use `Meta.identify(String userId)` to associate 
your app user with the Meta SDK. Identifying users allows you to do things like save and track user
properties across experiences, and to give and request items from users' inventories.

You can identify a user using some unique piece of information known by your application. For
instance, if your app requires accounts, you can invoke this method at the time of sign in and
provide your user ID as the argument (or, if you require unique usernames, the username; or another
piece of information like phone number or email address) to create a persistent MEtaverse account
linked to their user profile within your app.

You can also invoke this method with `null` to allow the Meta SDK to auto-generate a unique
identifier for the app instance. Note that this identifier will not be the same if the same user is
active across multiple devices.

This method only needs to be invoked once. It writes the user's identification key to your app's
shared preferences, and references it when loading subsequent storyboards.

Note that, at this time, if you are unable to identify a user, or choose not to, all Metaverse
activity within your app will appear to be coming from the account associated with your API key.
This is fine for testing, but might lead to collisions and weird things when dealing with items and
user properties in production. We recommend at least identifying a user by using the `null`
argument.

## Extras

If you create something awesome, we'd love to see it and feature it here! Create a PR on this Readme
to add your project, or let us know about it via email (support@gometa.io) or Facebook/Twitter.

### Packages

| [io.gometa.metaverse.storyboard.sdk](io.gometa.metaverse.storyboard.sdk/index.html) | This package provides the entry point for the Metaverse SDK via the [Meta](https://gometa.github.io/meta-android-sdk/io.gometa.metaverse.storyboard.sdk/-meta/index.html) class. |
| [io.gometa.metaverse.storyboard.sdk.model](io.gometa.metaverse.storyboard.sdk.model/index.html) | This package provides all the public models used by the Metaverse SDK. |

### Index

[All Types](alltypes/index.html)