/**
 * 
 */
package com.gss.student.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gss.sliderexample.R;
import com.gss.student.attendance.AbsentInfo;
import com.gss.student.attendance.AttendanceInfo;
import com.gss.student.attendance.IAbsent;
import com.gss.student.attendance.SerializableSparseArray;
import com.gss.student.fragments.MainActivity;
import com.gss.student.webservice.AbsentDetail;
import com.gss.student.webservice.DailyAbsents;
import com.gss.student.webservice.IWsdl2CodeEvents;
import com.gss.student.webservice.StudentDetails;
import com.gss.student.webservice.VectorAbsentDetail;
import com.gss.student.webservice.VectorDailyAbsents;
import com.gss.student.webservice.VectorInt32;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class LoadStudentDetails implements IWsdl2CodeEvents {

	private String studentRegNo;
	private ProgressBar progressBar;
	private Button loginButton;
	private Activity activity;
	
	public LoadStudentDetails() {
	}

	public LoadStudentDetails(String studentId, Activity loginActivtiy) {
		this.studentRegNo = studentId;
		this.progressBar = (ProgressBar) loginActivtiy
				.findViewById(R.id.login_progress);
		this.loginButton = (Button) loginActivtiy
				.findViewById(R.id.email_sign_in_button);
		this.activity = loginActivtiy;
	}

	@Override
	public void Wsdl2CodeStartedRequest() {
		loginButton.setEnabled(false);
		progressBar.setVisibility(View.VISIBLE);
		progressBar.animate();

	}

	@Override
	public void Wsdl2CodeFinished(String methodName, Object Data) {
		VectorAbsentDetail monthlyAbsentList = (VectorAbsentDetail) Data;
		List<IAbsent> absentInfoList = getMonthlyAbsentList(monthlyAbsentList);

		progressBar.clearAnimation();
		loginButton.setEnabled(true);
		progressBar.setVisibility(View.VISIBLE);
		Intent mainActivity = new Intent(activity, MainActivity.class);
		mainActivity.putExtra("attendanceInfo", new AttendanceInfo(
				absentInfoList));
		mainActivity.putExtra("regId", studentRegNo);
		activity.startActivity(mainActivity);
	}

	private List<IAbsent> getMonthlyAbsentList(
			VectorAbsentDetail monthlyAbsentList) {
		List<IAbsent> absentInfoList = new ArrayList<>();
		Map<Integer, Integer> monthNPercentage = new HashMap<Integer, Integer>();
		Map<Integer, SerializableSparseArray<List<Integer>>> monthDayNPeriodAbsents = new HashMap<Integer, SerializableSparseArray<List<Integer>>>();
		for (AbsentDetail eachMonth : monthlyAbsentList) {
			int month = eachMonth.mMonth;
			monthNPercentage.put(month, eachMonth.mMonthlyPercent);
			SparseArray<List<Integer>> dayAttendanceMap = monthDayNPeriodAbsents
					.get(month);
			if (dayAttendanceMap == null) {
				monthDayNPeriodAbsents.put(month,
						new SerializableSparseArray<List<Integer>>());
			}
			SerializableSparseArray<List<Integer>> dayAttendance = monthDayNPeriodAbsents
					.get(month);
			VectorDailyAbsents eachDayAbsents = eachMonth.dailyAbsentList;
			for (DailyAbsents absentDay : eachDayAbsents) {
				int day = absentDay.mDay;
				VectorInt32 vectPeriods = absentDay.absentPeriods;
				List<Integer> periods = new ArrayList<>();
				for (Number period : vectPeriods) {
					periods.add(period.intValue());
				}
				dayAttendance.put(day, periods);
			}
		}
		for (int monthKey : monthNPercentage.keySet()) {
			Integer monthlyPercent = monthNPercentage.get(monthKey);
			SerializableSparseArray<List<Integer>> dayAndPeriodAbsents = monthDayNPeriodAbsents
					.get(monthKey);

			AbsentInfo absentInfo = new AbsentInfo(monthKey, monthlyPercent,
					dayAndPeriodAbsents);
			switch (monthKey) {
			case 1:
				absentInfo.setMonthName("JAN");
				absentInfoList.add(absentInfo);
				break;
			case 2:
				absentInfo.setMonthName("FEB");
				absentInfoList.add(absentInfo);
				break;
			case 3:
				absentInfo.setMonthName("MAR");
				absentInfoList.add(absentInfo);
				break;
			case 4:
				absentInfo.setMonthName("APR");
				absentInfoList.add(absentInfo);
				break;
			case 5:
				absentInfo.setMonthName("MAI");
				absentInfoList.add(absentInfo);
				break;
			case 6:
				absentInfo.setMonthName("JUN");
				absentInfoList.add(absentInfo);
				break;
			case 7:
				absentInfo.setMonthName("JUL");
				absentInfoList.add(absentInfo);
				break;
			case 8:
				absentInfo.setMonthName("AUG");
				absentInfoList.add(absentInfo);
				break;
			case 9:
				absentInfo.setMonthName("SEP");
				absentInfoList.add(absentInfo);
				break;
			case 10:
				absentInfo.setMonthName("OCT");
				absentInfoList.add(absentInfo);
				break;
			case 11:
				absentInfo.setMonthName("NOV");
				absentInfoList.add(absentInfo);
				break;
			case 12:
				absentInfo.setMonthName("DEC");
				absentInfoList.add(absentInfo);
				break;
			default:
				break;
			}
		}
		return absentInfoList;
	}

	@Override
	public void Wsdl2CodeFinishedWithException(Exception ex) {
		progressBar.clearAnimation();
		loginButton.setEnabled(true);
		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void Wsdl2CodeEndedRequest() {

	}

	public void callWebservice() {
		StudentDetails details = new StudentDetails(this);
		try {
			details.getStudentDetailsAsync(studentRegNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AttendanceInfo getAttendanceSync(String regdId) {
		StudentDetails details = new StudentDetails();
		VectorAbsentDetail absentDetail = details
				.getStudentDetails(regdId);
		List<IAbsent> absentInfoList = getMonthlyAbsentList(absentDetail);
		AttendanceInfo attendanceInfo = new AttendanceInfo(absentInfoList);
		return attendanceInfo;
	}
}
