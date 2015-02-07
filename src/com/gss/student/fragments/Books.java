/**
 * 
 */
package com.gss.student.fragments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gss.sliderexample.R;
import com.gss.student.books.CustomList;
import com.gss.student.books.IBook;

/**
 * @author admin
 *
 */
public class Books extends Fragment {

	public Books() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_books, container,
				false);
		ListView bookList = (ListView) rootView.findViewById(R.id.bookList);
		CustomList list = new CustomList(getActivity(), 0, createBooks());
		bookList.setAdapter(list);
		return rootView;
	}

	private List<IBook> createBooks() {
		List<IBook> bookList = new ArrayList<IBook>();
		for (int i = 1; i < 5; i++) {
			bookList.add(createBook(i));
		}
		return bookList;
	}

	private IBook createBook(final int i) {
		IBook book = new IBook() {

			@Override
			public String getTitle() {
				return "Book " + i;
			}

			@Override
			public String getSubmissionDate() {
				Date date = Calendar.getInstance().getTime();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				return formatter.format(date);
			}

			@Override
			public String getISBNNumber() {
				//Accession Number
				return "ISBN " + i;
			}

			@Override
			public String getAuthor() {
				return "Author " + i;
			}
		};
		return book;
	}
}
