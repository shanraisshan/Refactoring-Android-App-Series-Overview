package com.refactor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.refactor.view.BooksActivityView;
import com.refactor.R;
import com.refactor.presenter.BooksActivityPresenter;
import com.refactor.repository.BooksRepository;
import com.refactor.repository.DatabaseBooksRepository;
import com.refactor.repository.model.Book;
import java.util.List;

public class BooksActivity extends AppCompatActivity implements BooksActivityView {

    BooksActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BooksActivityView booksActivityView = this;
        BooksRepository booksRepository = new DatabaseBooksRepository();
        presenter = new BooksActivityPresenter(booksActivityView, booksRepository);
        presenter.loadBooks();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    //______________________________________________________________________________________________
    @Override
    public void displayBooks(List<Book> bookList) {
        ((TextView)findViewById(R.id.txtView)).setText(R.string.books_found);
    }

    @Override
    public void displayNoBooks() {
        ((TextView)findViewById(R.id.txtView)).setText(R.string.no_books_found);
    }
}
