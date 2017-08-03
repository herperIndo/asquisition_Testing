package com.securetrack.talent_asquisition_go_jek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.securetrack.talent_asquisition_go_jek.deps.Deps;
import com.securetrack.talent_asquisition_go_jek.networking.NetworkModule;

import java.io.File;

/**
 * Created by heru.permana03 on 8/3/2017.
 */

public class BaseApp extends AppCompatActivity {
    Deps deps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDeps() {
        return deps;
    }
}
