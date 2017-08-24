package com.refactor.repository;

import com.refactor.repository.model.Book;
import java.util.List;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmResults;

public class DatabaseBooksRepository implements BooksRepository {

    public DatabaseBooksRepository() {
        insertNewBook();
    }

    //dummy book
    private void insertNewBook() {
        Book book = new Book();
        book.setId(1);
        book.setName("Refactor Android App series overview");
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(book);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public Single<List<Book>> getBooks() {
        return Single.fromCallable(() -> {
            try {
                System.out.println("Thread db: " + Thread.currentThread().getId());
                //Since, getBooks() is now not called on UI thread, therefore
                Realm realm = Realm.getDefaultInstance();
                RealmResults<Book> results = realm.where(Book.class).findAll();
                List<Book> bookList = realm.copyFromRealm(results);
                realm.close();
                return bookList;
            } catch (Exception e) {
                //for Episode 6 implementation, realm throws
                //java.lang.IllegalStateException: Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.
                //therefore provided new implementation
                throw new RuntimeException(e);
            }
        });
    }
}
