package com.refactor;

import com.refactor.view.BooksActivityView;
import com.refactor.presenter.BooksActivityPresenter;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.model.Book;
import java.util.Arrays;
import java.util.List;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class BooksActivityPresenterTest {

    @Mock
    BooksRepository booksRepository;

    @Mock
    BooksActivityView view;

    private BooksActivityPresenter presenter;
    private final List<Book> MANY_BOOKS = Arrays.asList(new Book(), new Book(), new Book());

    @Before
    public void setUp() throws Exception {
        presenter = new BooksActivityPresenter(view, booksRepository);
    }

    @Test
    public void shouldPassBooksToView() {
        Mockito.when(booksRepository.getBooks()).thenReturn(MANY_BOOKS);
        presenter.loadBooks();
        Mockito.verify(view).displayBooks(MANY_BOOKS);
    }

    @Test
    public void shouldHandleNoBooksFound() {
        when(booksRepository.getBooks()).thenReturn(EMPTY_LIST);
        presenter.loadBooks();
        verify(view).displayNoBooks();
    }
}