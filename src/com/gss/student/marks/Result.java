/**
 * 
 */
package com.gss.student.marks;

import java.util.List;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class Result implements IResult {
	
	private List<ISemester> semesters;

	public Result(List<ISemester> sem) {
		this.semesters = sem;
	}

	/* (non-Javadoc)
	 * @see com.gss.student.marks.IResult#getSemesterMarks()
	 */
	@Override
	public List<ISemester> getSemesterMarks() {
		return semesters;
	}

}
