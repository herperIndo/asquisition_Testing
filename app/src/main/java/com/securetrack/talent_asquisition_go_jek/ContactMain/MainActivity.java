package com.securetrack.talent_asquisition_go_jek.ContactMain;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.securetrack.talent_asquisition_go_jek.BaseApp;
import com.securetrack.talent_asquisition_go_jek.R;
import com.securetrack.talent_asquisition_go_jek.models.contactListModel;
import com.securetrack.talent_asquisition_go_jek.networking.Service;

import javax.inject.Inject;

public class MainActivity extends BaseApp implements MainView {

    private RecyclerView list;
    @Inject
    public Service service;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        ReaderView();
        init();
        MainPresenter presenter = new MainPresenter(service, this);
        presenter.getContactList();
    }

    private void init() {
    }

    private void ReaderView() {
        setContentView(R.layout.activity_main);
        list = (RecyclerView)findViewById(R.id.rvContactDetails);
    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getityListSuccess(contactListModel cityListResponse) {

    }
}
