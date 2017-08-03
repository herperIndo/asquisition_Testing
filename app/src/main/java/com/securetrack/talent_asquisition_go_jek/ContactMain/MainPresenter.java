package com.securetrack.talent_asquisition_go_jek.ContactMain;

import com.securetrack.talent_asquisition_go_jek.models.contactListModel;
import com.securetrack.talent_asquisition_go_jek.networking.NetworkError;
import com.securetrack.talent_asquisition_go_jek.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by heru.permana03 on 8/3/2017.
 */

public class MainPresenter {

    private final Service service;
    private final MainView mainView;
    private final CompositeSubscription subscriptions;

    public MainPresenter(Service service, MainView mainView) {
        this.service = service;
        this.mainView = mainView;
        this.subscriptions = new CompositeSubscription();
    }



    public void getContactList(){
        mainView.showWait();
        Subscription subscription = service.getContactList(new Service.GetContactListCallBack() {
            @Override
            public void onSuccess(contactListModel contactListModel) {
                mainView.removeWait();
                mainView.getityListSuccess(contactListModel);
            }

            @Override
            public void onError(NetworkError networkError) {
                mainView.removeWait();
                mainView.onFailure(networkError.getAppErrorMessage());
            }
        });
        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}
