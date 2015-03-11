/**
 * 
 */
package com.gss.student.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gss.sliderexample.R;
import com.gss.student.Calender.CustCalenList;
import com.gss.student.Calender.IAcademicCal;

public class AcademiCalendar extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.academicalendar, container,
				false);
//		super.onCreate(savedInstanceState);
		ListView list = (ListView) rootView.findViewById(R.id.academicList);
		CustCalenList custCalist = new CustCalenList(this.getActivity(),
				createAcademiCalendarList());
		list.setAdapter(custCalist);
		return rootView;
	}

	private List<IAcademicCal> createAcademiCalendarList() {
		List<IAcademicCal> calist = new ArrayList<IAcademicCal>();
		IAcademicCal cal = new IAcademicCal() {

			@Override
			public String getWeeks() {
				// TODO Auto-generated method stub
				return "1";
			}

			@Override
			public String getToDate() {
				// TODO Auto-generated method stub
				return "25-3-2015";
			}

			@Override
			public String getFromDate() {
				// TODO Auto-generated method stub
				return "20-3-2015";
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Sample";
			}
		};
		calist.add(cal);
		return calist;
	}

	private List<IAcademicCal> createAcademiCalendarList1() {
		List<IAcademicCal> calist = new ArrayList<IAcademicCal>();
		IAcademicCal cal = new IAcademicCal() {

			@Override
			public String getWeeks() {
				// TODO Auto-generated method stub
				return "2";
			}

			@Override
			public String getToDate() {
				// TODO Auto-generated method stub
				return "1-3-2015";
			}

			@Override
			public String getFromDate() {
				// TODO Auto-generated method stub
				return "7-3-2015";
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "mid exams";
			}
		};
		calist.add(cal);
		return calist;
	}

}
