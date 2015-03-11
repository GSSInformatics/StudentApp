/**
 * 
 */
package com.gss.student.attendance;

import java.io.Serializable;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class AttendanceInfo implements IAttendance, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7617217981162273576L;
	private List<IAbsent> absentInfo;

	public AttendanceInfo(List<IAbsent> absentInfo) {
		this.absentInfo = absentInfo;
	}

	@Override
	public List<IAbsent> getMonthlyAbsentees() {
		return absentInfo;
	}

}
