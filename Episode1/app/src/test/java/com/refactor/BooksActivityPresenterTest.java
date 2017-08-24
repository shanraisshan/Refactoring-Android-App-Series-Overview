package com.refactor;

import com.refactor.presenter.BooksActivityPresenter;
import com.refactor.repository.Book;
import com.refactor.repository.BooksRepository;
import com.refactor.view.BooksActivityView;
import junit.framework.Assert;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class BooksActivityPresenterTest {

    @Test
    public void shouldPassBooksToView() {
        //3 parts to test
        //given (initial condition)
        BooksActivityView view  = new  MockView();
        BooksRepository bookRepository = new MockBooksRepository(true);

        //when (action to trigger)
        BooksActivityPresenter presenter = new BooksActivityPresenter(view, bookRepository);
        presenter.loadBooks();

        //then (did it work or not)
        Assert.assertEquals(true, ((MockView)view).displayBooksWithBooksCalled);
    }

    @Test
    public void shouldHandleNoBooksFound() {
        BooksActivityView view  = new  MockView();
        BooksRepository bookRepository = new MockBooksRepository(false);

        BooksActivityPresenter presenter = new BooksActivityPresenter(view, bookRepository);
        presenter.loadBooks();

        Assert.assertEquals(true, ((MockView)view).displayBooksWithNoBooksCalled);
    }


    //________________________________________________ MANUAL MOCKING
    //manually creating the interface implementation
    //later use the Mocking library
    private class MockView implements BooksActivityView {
        boolean displayBooksWithBooksCalled;
        boolean displayBooksWithNoBooksCalled;
        @Override
        public void displayBooks(List<Book> bookList) {
            if(bookList.size()==3)
                displayBooksWithBooksCalled = true;
        }
        @Override
        public void displayNoBooks() {
            displayBooksWithNoBooksCalled = true;
        }
    }

    private class MockBooksRepository implements BooksRepository {
        private boolean returnSomeBooks;
        MockBooksRepository(boolean returnSomeBooks) {
            this.returnSomeBooks = returnSomeBooks;
        }
        @Override
        public List<Book> getBooks() {
            if(returnSomeBooks) {
                return Arrays.asList(new Book(), new Book(), new Book());
            } else {
                return Collections.emptyList();
            }
        }
    }

}