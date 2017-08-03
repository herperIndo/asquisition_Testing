package com.securetrack.talent_asquisition_go_jek.networking;


import com.securetrack.talent_asquisition_go_jek.models.contactListModel;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by heru.permana03 on 8/3/2017.
 */

public interface NetworkService {
    @GET("/contacts.json")
    Observable<contactListModel> getContactList();
}
