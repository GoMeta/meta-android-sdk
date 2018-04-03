---
title: isDone - Metaverse SDK
---

[Metaverse SDK](../index.html) / [io.gometa.metaverse.storyboard.sdk](index.html) / [isDone](./is-done.html)

# isDone

`fun <T> `[`Result`](-result/index.html)`<`[`T`](is-done.html#T)`>?.isDone(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Tests a nullable [Result](-result/index.html) for a completed state. This method will only return `true` if the
[Result](-result/index.html) is non-null and its status is either [Result.Status.SUCCESS](-result/-status/-s-u-c-c-e-s-s.html) or [Result.Status.ERROR](-result/-status/-e-r-r-o-r.html).

**Return**
True if the result is non-null and is in a completed state.

