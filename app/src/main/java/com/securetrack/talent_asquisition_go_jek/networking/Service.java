package com.securetrack.talent_asquisition_go_jek.networking;

import com.securetrack.talent_asquisition_go_jek.models.contactListModel;
import com.securetrack.talent_asquisition_go_jek.networking.NetworkError;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by heru.permana03 on 8/3/2017.
 */

public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getContactList(final GetContactListCallBack callback) {
        return networkService.getContactList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends contactListModel>>() {
                    @Override
                    public Observable<? extends contactListModel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                }).subscribe(new Subscriber<contactListModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(contactListModel contactListModel) {

                        callback.onSuccess(contactListModel);

                    }
                });
    }

    public interface GetContactListCallBack {
        void onSuccess(contactListModel contactListModel);

        void onError(NetworkError networkError);
    }
}
