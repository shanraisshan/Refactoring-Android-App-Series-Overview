package com.refactor.dagger;

import com.refactor.App;
import com.refactor.activity.BooksActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {
    void inject(App application);
    void inject(BooksActivity booksActivity);
}