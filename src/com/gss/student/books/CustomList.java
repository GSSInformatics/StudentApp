/**
 * 
 */
package com.gss.student.books;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gss.sliderexample.R;

/**
 * @author Ajaykumar Vasireddy
 * @version 0.1
 * @since 2014
 */
public class CustomList extends ArrayAdapter<IBook> {

	private final Activity context;

	private final List<IBook> books;

	public CustomList(Activity context, int resource, List<IBook> books) {
		super(context, resource, books);
		this.books = books;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.
				inflate(R.layout.book_list_row, null, true);
		TextView bookTitle = (TextView) rowView.findViewById(R.id.title);
		bookTitle.setText(books.get(position).getTitle());

		TextView bookAuthor = (TextView) rowView.findViewById(R.id.author);
		bookAuthor.setText(books.get(position).getAuthor());

		TextView bookISBN = (TextView) rowView.findViewById(R.id.ISBN);
		bookISBN.setText(books.get(position).getISBNNumber());

		TextView returnDate = (TextView) rowView
				.findViewById(R.id.submissionDate);
		returnDate.setText(books.get(position).getSubmissionDate().toString());

		return super.getView(position, convertView, parent);
	}
}
