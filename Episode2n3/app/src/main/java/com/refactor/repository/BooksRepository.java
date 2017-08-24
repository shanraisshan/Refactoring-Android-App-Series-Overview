package com.refactor.repository;

import com.refactor.repository.model.Book;
import java.util.List;

public interface BooksRepository {
    List<Book> getBooks();
    void closeBookRepository();
}
