package com.refactor;

import com.refactor.view.BooksActivityView;
import com.refactor.presenter.BooksActivityPresenter;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.model.Book;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.mockito.Mockito;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import io.reactivex.Single;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;

public class BooksActivityPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    BooksRepository booksRepository;

    @Mock
    BooksActivityView view;

    private BooksActivityPresenter presenter;
    private final List<Book> MANY_BOOKS = Arrays.asList(new Book(), new Book(), new Book());

    @Before
    public void setUp() throws Exception {
        presenter = new BooksActivityPresenter(view, booksRepository, Schedulers.trampoline());
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @After
    public void cleanUp() {
        RxJavaPlugins.reset();
    }

    @Test
    public void shouldPassBooksToView() {
        when(booksRepository.getBooks()).thenReturn(Single.just(MANY_BOOKS));
        presenter.loadBooks();
        verify(view).displayBooks(MANY_BOOKS);
    }

    @Test
    public void shouldHandleNoBooksFound() {
        when(booksRepository.getBooks()).thenReturn(Single.<List<Book>>just(EMPTY_LIST));
        presenter.loadBooks();
        verify(view).displayNoBooks();
    }

    @Test
    public void shouldHandleError() {
        when(booksRepository.getBooks()).thenReturn(Single.<List<Book>>error(new Throwable("boom!")));
        presenter.loadBooks();
        verify(view).displayError();
    }
}