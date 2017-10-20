package com.core.domain.usecase

import dagger.internal.Preconditions
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import com.core.domain.usecase.UseCaseObserver

abstract class UseCase<T> {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun execute(disposableObserver: UseCaseObserver<T>?) {
        Preconditions.checkNotNull(disposableObserver)
        val observable = this.createObservableUseCase()
                .subscribeOn(getSubscribeOn())
                .observeOn(getObserveOn())
        val observer = observable.subscribeWith(disposableObserver)
        compositeDisposable.add(observer)
    }

    open fun getSubscribeOn(): Scheduler? =Schedulers.io()
    open fun getObserveOn(): Scheduler? =AndroidSchedulers.mainThread()

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    protected abstract fun createObservableUseCase(): Observable<T>
}