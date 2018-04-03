---
title: isSuccess - Metaverse SDK
---

[Metaverse SDK](../index.html) / [io.gometa.metaverse.storyboard.sdk](index.html) / [isSuccess](./is-success.html)

# isSuccess

`fun <T> `[`Result`](-result/index.html)`<`[`T`](is-success.html#T)`>?.isSuccess(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Tests a nullable [Result](-result/index.html) for success. This method will only return `true` if the [Result](-result/index.html) is
non-null and its status is [Result.Status.SUCCESS](-result/-status/-s-u-c-c-e-s-s.html).

**Return**
True if the result is non-null and is in a success state.

