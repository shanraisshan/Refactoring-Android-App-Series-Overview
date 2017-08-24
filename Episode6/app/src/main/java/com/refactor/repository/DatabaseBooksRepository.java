package com.refactor.repository;

import com.refactor.repository.model.Book;
import java.util.List;
import java.util.concurrent.Callable;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmResults;

public class DatabaseBooksRepository implements BooksRepository {

    private Realm realm;

    public DatabaseBooksRepository() {
        realm = Realm.getDefaultInstance();
        //dummy book insertion
        insertNewBook();
    }

    //dummy book
    private void insertNewBook() {
        Book book = new Book();
        book.setId(1);
        book.setName("Refactor Android App series overview");
        realm.beginTransaction();
        realm.copyToRealm(book);
        realm.commitTransaction();
    }

    @Override
    public Single<List<Book>> getBooks() {
        return Single.fromCallable(new Callable<List<Book>>() {
            @Override
            public List<Book> call() throws Exception {
                try {
                    RealmResults<Book> results = realm.where(Book.class).findAll();
                    return realm.copyFromRealm(results);
                } catch (Exception e) {
                    throw new RuntimeException("boom!");
                }
            }
        });
    }

    @Override
    public void closeBookRepository() {
        realm.close();
    }
}
