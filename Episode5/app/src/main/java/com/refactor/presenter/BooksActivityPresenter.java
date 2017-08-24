package com.refactor.presenter;

import com.refactor.view.BooksActivityView;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.model.Book;
import java.util.List;

import io.reactivex.functions.Consumer;

public class BooksActivityPresenter {

    private BooksActivityView view;
    private BooksRepository bookRepository;

    public BooksActivityPresenter(BooksActivityView view, BooksRepository bookRepository) {
        this.view = view;
        this.bookRepository = bookRepository;
    }

    public void loadBooks() {
        bookRepository.getBooks()
                .subscribe(new Consumer<List<Book>>() {
                    @Override
                    public void accept(List<Book> bookList) throws Exception {
                        if (bookList.isEmpty())
                            view.displayNoBooks();
                        else
                            view.displayBooks(bookList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.displayError();
                    }
                });
    }

    public void destroy() {
        bookRepository.closeBookRepository();
    }
}
