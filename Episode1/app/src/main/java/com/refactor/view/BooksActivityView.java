package com.refactor.view;

import com.refactor.repository.Book;
import java.util.List;

public interface BooksActivityView {
    void displayBooks(List<Book> bookList);
    void displayNoBooks();
}
