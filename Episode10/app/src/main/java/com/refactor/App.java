package com.refactor;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.refactor.dagger.AppComponent;
import com.refactor.dagger.AppModule;
import com.refactor.dagger.DaggerAppComponent;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;
import io.realm.Realm;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //Realm
        Realm.init(this);

        //Stetho
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this)
                        )
                        .enableWebKitInspector(
                                RealmInspectorModulesProvider
                                        .builder(this)
                                        .build()
                        )
                        .build());



        //Dagger
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component.inject(this);
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
