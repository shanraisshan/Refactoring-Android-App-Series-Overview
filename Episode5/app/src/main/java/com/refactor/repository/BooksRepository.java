package com.refactor.repository;

import com.refactor.repository.model.Book;
import java.util.List;
import io.reactivex.Single;

public interface BooksRepository {
    Single<List<Book>> getBooks();
    void closeBookRepository();
}
