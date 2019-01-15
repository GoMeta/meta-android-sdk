---
title: Result.Success - MetaverseSDK
---

[MetaverseSDK](../../../index.html) / [io.gometa.sdk](../../index.html) / [Result](../index.html) / [Success](./index.html)

# Success

`data class Success<out T> : `[`Result`](../index.html)`<`[`T`](index.html#T)`>`

Reports a success state for a pending result.

### Constructors

| [&lt;init&gt;](-init-.html) | `Success(data: `[`T`](index.html#T)`)`<br>Reports a success state for a pending result. |

### Properties

| [data](data.html) | `val data: `[`T`](index.html#T)<br>The data reported by the opration. |
| [isDone](is-done.html) | `val isDone: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether or not this result reports a completed operation |

