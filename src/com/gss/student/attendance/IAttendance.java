/**
 * 
 */
package com.gss.student.attendance;

import java.util.List;

/**
 * Contains the attendance information of the student for each month of the
 * year.
 * 
 * @author AjaykumarVasireddy
 * @version 1.0
 */
public interface IAttendance {

	/**
	 * Returns the list of {@link IAbsent}s.
	 * @return list of {@link IAbsent}
	 */
	List<IAbsent> getMonthlyAbsentees();

}
