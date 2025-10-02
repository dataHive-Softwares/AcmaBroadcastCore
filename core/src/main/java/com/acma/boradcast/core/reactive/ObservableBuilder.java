package com.acma.boradcast.core.reactive;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ObservableBuilder {

    public static <T> Observable<T> createObservable(ObservableOnSubscribe<T> observableOnSubscribe) {
        return Observable.create(observableOnSubscribe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public static <T> void subscribeIOWithDefaultObserver(ObservableOnSubscribe<T> observableOnSubscribe) {
        Observable.create(observableOnSubscribe)
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseObserver<>() {
                });
    }
}