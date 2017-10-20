package com.core.domain.usecase

import io.reactivex.observers.DisposableObserver

abstract class UseCaseObserver<T> : DisposableObserver<T>() {

    override fun onComplete() {}

    override fun onError(e: Throwable) {}

    override fun onNext(result: T) {}
}