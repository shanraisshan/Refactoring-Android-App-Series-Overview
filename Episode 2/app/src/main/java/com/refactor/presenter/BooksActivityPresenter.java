package com.refactor.presenter;

import com.refactor.view.BooksActivityView;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.model.Book;
import java.util.List;

public class BooksActivityPresenter {

    private BooksActivityView view;
    private BooksRepository bookRepository;

    public BooksActivityPresenter(BooksActivityView view, BooksRepository bookRepository) {
        this.view = view;
        this.bookRepository = bookRepository;
    }

    public void loadBooks() {
        List<Book> bookList = bookRepository.getBooks();
        if(bookList.isEmpty())
            view.displayNoBooks();
        else
            view.displayBooks(bookList);
    }

    public void destroy() {
        bookRepository.closeBookRepository();
    }
}
