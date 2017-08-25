package com.refactor.presenter;

import com.refactor.view.BooksActivityView;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.model.Book;
import java.util.List;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class BooksActivityPresenter {

    private BooksActivityView view;
    private BooksRepository bookRepository;
    private final Scheduler mainScheduler;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BooksActivityPresenter(BooksActivityView view, BooksRepository bookRepository, Scheduler mainScheduler) {
        this.view = view;
        this.bookRepository = bookRepository;
        this.mainScheduler = mainScheduler;
    }

    public void loadBooks() {
        compositeDisposable.add(bookRepository.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(mainScheduler)
                .subscribeWith(new DisposableSingleObserver<List<Book>>() {
                    @Override
                    public void onSuccess(List<Book> bookList) {
                        System.out.println("Thread subscribe(): " + Thread.currentThread().getId());
                        if (bookList.isEmpty()) {
                            view.displayNoBooks();
                        } else {
                            view.displayBooks(bookList);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Throwable: " + e.toString());
                        view.displayError();
                    }
                }));
    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }
}
