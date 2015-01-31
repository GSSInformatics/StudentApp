/**
 * 
 */
package com.gss.student.books;

import java.util.Date;

/**
 * 
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public interface IBook {

	/**
	 * Returns the title of the book.
	 * @return book title
	 */
	String getTitle();
	
	/**
	 * Returns the author of the book.
	 * @return book author
	 */
	String getAuthor();
	
	/**
	 * Returns the ISBN number of the book.
	 * @return ISBN number
	 */
	String getISBNNumber();
	
	/**
	 * Returns the book return date from the library.
	 * @return return date of the book
	 */
	Date getSubmissionDate();
}
