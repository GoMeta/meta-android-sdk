---
title: Result - MetaverseSDK
---

[MetaverseSDK](../../index.html) / [io.gometa.sdk](../index.html) / [Result](./index.html)

# Result

`sealed class Result<out T>`

Possible results that may be reported by Metaverse.

### Types

| [Error](-error/index.html) | `class Error<out T> : `[`Result`](./index.md)`<`[`T`](-error/index.html#T)`>`<br>Reports an error state for a pending result. |
| [Loading](-loading/index.html) | `data class Loading<out T> : `[`Result`](./index.md)`<`[`T`](-loading/index.html#T)`>`<br>Reports a loading state for a pending result. |
| [Success](-success/index.html) | `data class Success<out T> : `[`Result`](./index.md)`<`[`T`](-success/index.html#T)`>`<br>Reports a success state for a pending result. |

### Properties

| [isDone](is-done.html) | `abstract val isDone: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether or not this result reports a completed operation |

### Inheritors

| [Error](-error/index.html) | `class Error<out T> : `[`Result`](./index.md)`<`[`T`](-error/index.html#T)`>`<br>Reports an error state for a pending result. |
| [Loading](-loading/index.html) | `data class Loading<out T> : `[`Result`](./index.md)`<`[`T`](-loading/index.html#T)`>`<br>Reports a loading state for a pending result. |
| [Success](-success/index.html) | `data class Success<out T> : `[`Result`](./index.md)`<`[`T`](-success/index.html#T)`>`<br>Reports a success state for a pending result. |

