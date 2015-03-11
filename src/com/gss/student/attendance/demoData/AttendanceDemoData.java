/**
 * 
 */
package com.gss.student.attendance.demoData;

import java.util.ArrayList;
import java.util.List;

import android.util.SparseArray;

import com.gss.student.attendance.IAbsent;
import com.gss.student.attendance.IAttendance;
import com.gss.student.attendance.SerializableSparseArray;

/**
 * @author admin
 *
 */
public class AttendanceDemoData implements IAttendance {

	@Override
	public List<IAbsent> getMonthlyAbsentees() {
		List<IAbsent> absents = new ArrayList<IAbsent>();
		absents.add(new AbsentsDemo(1, 10));
		absents.add(new AbsentsDemo(2, 20));
		absents.add(new AbsentsDemo(3, 30));
		absents.add(new AbsentsDemo(4, 40));
		absents.add(new AbsentsDemo(5, 50));
		absents.add(new AbsentsDemo(6, 60));
		absents.add(new AbsentsDemo(7, 60));
		absents.add(new AbsentsDemo(8, 50));
		absents.add(new AbsentsDemo(9, 40));
		absents.add(new AbsentsDemo(10, 30));
		absents.add(new AbsentsDemo(11, 20));
		absents.add(new AbsentsDemo(12, 10));
		return absents;
	}

	class AbsentsDemo implements IAbsent {

		private int month;
		private int percent;

		public AbsentsDemo(int month, int percent) {
			this.month = month;
			this.percent = percent;
		}

		@Override
		public int getMonth() {
			return month;
		}

		@Override
		public SerializableSparseArray<List<Integer>> getDailyAbsentees() {
			return createDummyData();
		}

		@Override
		public int getMonthlyPercentage() {
			return percent;
		}

		@Override
		public String getMonthName() {
			switch (getMonth()) {
			case 1:
				return "JAN";
			case 2:
				return "FEB";
			case 3:
				return "MAR";
			case 4:
				return "APR";
			case 5:
				return "MAY";
			case 6:
				return "JUN";
			case 7:
				return "JUL";
			case 8:
				return "AUG";
			case 9:
				return "SEP";
			case 10:
				return "OCT";
			case 11:
				return "NOV";
			case 12:
				return "DEC";
			default:
				return "UNKNOWN MONTH";
			}
		}

	}

	private SerializableSparseArray<List<Integer>> createDummyData() {
		SerializableSparseArray<List<Integer>> dailyAtt = new SerializableSparseArray<List<Integer>>();
		List<Integer> periods = new ArrayList<Integer>();
		for (int j = 1; j < 32; j++) {
			for (int i = 0; i < 8; i++) {
				periods.add(i);
				i++;
			}
			dailyAtt.put(j, periods);
			j = j + 7;
		}
		return dailyAtt;
	}

}
