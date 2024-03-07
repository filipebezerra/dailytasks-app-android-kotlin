package com.github.filipebezerra.apps.dailytasks.domain.data

interface Mapper<F, T> {

    suspend fun map(from: F): T
}

suspend inline fun <F, T> Mapper<F, T>.mapList(list: List<F>): List<T> =
    list.map { item -> map(item) }

suspend inline fun <F, T> Mapper<F, T>.mapSet(set: Set<F>): Set<T> =
    set.map { item -> map(item) }.toSet()
