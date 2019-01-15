---
title: Meta.CloseReason - MetaverseSDK
---

[MetaverseSDK](../../../index.html) / [io.gometa.sdk](../../index.html) / [Meta](../index.html) / [CloseReason](./index.html)

# CloseReason

`object CloseReason`

The various reasons a storyboard's activity might finish. These are the possible values that
may be returned via the [Meta.StoryboardResult.CLOSE_REASON](../-storyboard-result/-c-l-o-s-e_-r-e-a-s-o-n.html) key.

### Properties

| [CANCELED_CAMERA_IN_USE](-c-a-n-c-e-l-e-d_-c-a-m-e-r-a_-i-n_-u-s-e.html) | `const val CANCELED_CAMERA_IN_USE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Specifies that the storyboard ended due to the camera being used by another app or view. |
| [CANCELED_INVALID_SCENE](-c-a-n-c-e-l-e-d_-i-n-v-a-l-i-d_-s-c-e-n-e.html) | `const val CANCELED_INVALID_SCENE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Specifies that the storyboard ended due to an invalid scene. |
| [CANCELED_REPORT](-c-a-n-c-e-l-e-d_-r-e-p-o-r-t.html) | `const val CANCELED_REPORT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Specifies that the user left the storyboard early via reporting it as either broken or inappropriate. |
| [CANCELED_USER_ACTION](-c-a-n-c-e-l-e-d_-u-s-e-r_-a-c-t-i-o-n.html) | `const val CANCELED_USER_ACTION: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Specifies that the user left the storyboard early via either the back button or the menu. |
| [COMPLETION](-c-o-m-p-l-e-t-i-o-n.html) | `const val COMPLETION: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Specifies that the user completed the storyboard by executing an `end` transition. |
| [SUSPEND](-s-u-s-p-e-n-d.html) | `const val SUSPEND: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Specifies that the user completed the storyboard by executing a `suspend` transition. |

