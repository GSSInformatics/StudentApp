/**
 * 
 */
package com.gss.student.attendance;

import java.util.List;

import android.util.SparseArray;

/**
 * For each student the list of this object determines the absentees in a year.
 * Also each month percentage is available.
 * 
 * @author AjaykumarVasireddy
 */
public interface IAbsent {

	/**
	 * Returns the month to which this absent information belongs to.
	 * 
	 * @return month of the year
	 */
	int getMonth();

	/**
	 * Returns the monthly percentage that the student acquired. The formula for
	 * determining the percentage is done in .net application.
	 * 
	 * @return attendance percentage of the month
	 */
	int getMonthlyPercentage();

	/**
	 * Returns the name of the month.This value need not be set during the
	 * object creation.It is calculated, as the month value is set in
	 * {@link IAbsent#getMonth()}
	 * 
	 * @return name of the month to which this attendance belongs
	 */
	String getMonthName();

	/**
	 * Based on the month there are number of days. And in each day, there are 8
	 * periods.This information is returned in this method. So, for example:
	 * Student is absent on Jan 1st for 3,5,7 periods, this information is shown
	 * in this map.The key of the map is the day(1) of the month and the value
	 * contains list of absented periods(3,5,7) on that day.
	 * 
	 * 
	 * @return map containing day of the month as key and list of absented
	 *         periods as value.
	 */
	SerializableSparseArray<List<Integer>> getDailyAbsentees();
}
