/**
 * 
 */
package com.gss.student.fragments;

import com.gss.sliderexample.R;
import com.gss.student.books.CustomList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
//		CustomList list = new CustomList(Books.this, , books)
		return rootView;
	}
}
