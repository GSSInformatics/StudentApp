/**
 * 
 */
package com.gss.student.attendance;

import java.io.Serializable;
import java.util.List;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class AbsentInfo implements IAbsent, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5613830738417462103L;
	private int month;
	private int percent;
	private SerializableSparseArray<List<Integer>> dailyAbsents;
	private String monthName;

	public AbsentInfo(int month, int percent,
			SerializableSparseArray<List<Integer>> dailyAbsents) {
		this.month = month;
		this.percent = percent;
		this.dailyAbsents = dailyAbsents;
	}

	@Override
	public int getMonth() {
		return month;
	}

	@Override
	public int getMonthlyPercentage() {
		return percent;
	}

	@Override
	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	@Override
	public SerializableSparseArray<List<Integer>> getDailyAbsentees() {
		return this.dailyAbsents;
	}

}
