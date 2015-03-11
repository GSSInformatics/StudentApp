/**
 * 
 */
package com.gss.student.marks;

import java.util.Map;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class Semester implements ISemester {
	
	private String semester;
	private int percent;
	private Map<String, Integer> subjectMarks;

	public Semester(String sem, int percent, Map<String, Integer> subjMarks ) {
		this.semester = sem;
		this.percent = percent;
		this.subjectMarks = subjMarks;
	}

	/* (non-Javadoc)
	 * @see com.gss.student.marks.ISemester#getSemester()
	 */
	@Override
	public String getSemester() {
		return semester;
	}

	/* (non-Javadoc)
	 * @see com.gss.student.marks.ISemester#getPercentage()
	 */
	@Override
	public int getPercentage() {
		return percent;
	}

	/* (non-Javadoc)
	 * @see com.gss.student.marks.ISemester#getSubjectMarks()
	 */
	@Override
	public Map<String, Integer> getSubjectMarks() {
		return subjectMarks;
	}

}
