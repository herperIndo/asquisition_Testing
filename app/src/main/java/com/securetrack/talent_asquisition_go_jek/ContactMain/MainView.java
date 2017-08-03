package com.securetrack.talent_asquisition_go_jek.ContactMain;

import com.securetrack.talent_asquisition_go_jek.models.contactListModel;

/**
 * Created by heru.permana03 on 8/3/2017.
 */

public interface MainView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getityListSuccess(contactListModel cityListResponse);
}
