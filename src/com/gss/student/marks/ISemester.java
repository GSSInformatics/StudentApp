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
public interface ISemester {
 
	String getSemester();
	
	int getPercentage();
	
	Map<String,Integer> getSubjectMarks();
}
