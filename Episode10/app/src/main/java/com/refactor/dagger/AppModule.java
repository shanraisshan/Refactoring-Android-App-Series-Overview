package com.refactor.dagger;

import android.content.Context;
import com.refactor.App;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.DatabaseBooksRepository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final App application;

    public AppModule(App app) {
        this.application = app;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    BooksRepository providesBooksRepository() {
        return new DatabaseBooksRepository();
    }
}
