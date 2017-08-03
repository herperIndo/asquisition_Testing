package com.securetrack.talent_asquisition_go_jek.deps;

import com.securetrack.talent_asquisition_go_jek.ContactMain.MainActivity;
import com.securetrack.talent_asquisition_go_jek.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by heru.permana03 on 8/3/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(MainActivity mainActivity);
}
