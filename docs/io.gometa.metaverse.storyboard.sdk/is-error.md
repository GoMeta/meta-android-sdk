---
title: isError - Metaverse SDK
---

[Metaverse SDK](../index.html) / [io.gometa.metaverse.storyboard.sdk](index.html) / [isError](./is-error.html)

# isError

`fun <T> `[`Result`](-result/index.html)`<`[`T`](is-error.html#T)`>?.isError(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Tests a nullable [Result](-result/index.html) for error. This method will only return `true` if the [Result](-result/index.html) is
non-null and its status is [Result.Status.ERROR](-result/-status/-e-r-r-o-r.html).

**Return**
True if the result is non-null and is in an error state.

