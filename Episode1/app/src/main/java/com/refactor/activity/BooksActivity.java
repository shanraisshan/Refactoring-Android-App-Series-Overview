package com.refactor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.refactor.repository.Book;
import com.refactor.view.BooksActivityView;
import com.refactor.R;
import com.refactor.presenter.BooksActivityPresenter;
import java.util.List;

public class BooksActivity extends AppCompatActivity implements BooksActivityView {

    //SHORTCUTS
    //Alt + Enter (field name)
    //Alt + Insert (constructors)
    //Ctrl + Space (missing classes)
    //Ctrl + Shift + T (create test)
    //Ctrl + Shift + F10 (run test)
    //.var    new Book().var    =>    Book book = new Book();

    BooksActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BooksActivityView booksActivityView = this;
        presenter = new BooksActivityPresenter(booksActivityView, null);
    }

    //______________________________________________________________________________________________
    @Override
    public void displayBooks(List<Book> bookList) {
    }

    @Override
    public void displayNoBooks() {
    }
}
