package com.mif50.madarsoftkotlin.app.helper.rx

import io.reactivex.*

/**
 * @name Time viewer
 * Copyrights (c) 10/1/18 Created By BeinMedia
 **/
interface SchedulerProvider {
    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T>

    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T>

    fun ioToMainCompletableScheduler(): CompletableTransformer

    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T>

    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T>
}