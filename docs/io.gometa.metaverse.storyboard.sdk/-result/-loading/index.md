---
title: Result.Loading - Metaverse SDK
---

[Metaverse SDK](../../../index.html) / [io.gometa.metaverse.storyboard.sdk](../../index.html) / [Result](../index.html) / [Loading](./index.html)

# Loading

`data class Loading<out T> : `[`Result`](../index.html)`<`[`T`](index.html#T)`>`

Reports a loading state for a pending result.

### Constructors

| [&lt;init&gt;](-init-.html) | `Loading(progress: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = null)`<br>Reports a loading state for a pending result. |

### Properties

| [isDone](is-done.html) | `val isDone: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether or not this result reports a completed operation |
| [progress](progress.html) | `val progress: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?`<br>The progress of the operation [0,1](#). This value may be null if the operation progress cannot be measured. |

