package com.mif50.madarsoftkotlin.app.helper.rx

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  @name Time viewer
 * Copyrights (c) 10/1/18 Created By BeinMedia
 **/
class AppSchedulerProvider : SchedulerProvider {

    override fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }


    override fun ioToMainCompletableScheduler(): CompletableTransformer = CompletableTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }


    override fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> = FlowableTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }

    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }


    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }
}