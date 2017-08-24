package com.refactor.presenter;

import com.refactor.view.BooksActivityView;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.model.Book;
import java.util.List;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

public class BooksActivityPresenter {

    private BooksActivityView view;
    private BooksRepository bookRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BooksActivityPresenter(BooksActivityView view, BooksRepository bookRepository) {
        this.view = view;
        this.bookRepository = bookRepository;
    }

    public void loadBooks() {
        compositeDisposable.add(bookRepository.getBooks()
                .subscribeWith(new DisposableSingleObserver<List<Book>>() {
                    @Override
                    public void onSuccess(List<Book> bookList) {
                        if (bookList.isEmpty()) {
                            view.displayNoBooks();
                        } else {
                            view.displayBooks(bookList);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        view.displayError();
                    }
                }));
    }

    public void destroy() {
        bookRepository.closeBookRepository();
    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }
}
