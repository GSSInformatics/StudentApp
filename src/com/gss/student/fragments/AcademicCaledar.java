package com.gss.student.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gss.sliderexample.R;
import com.tyczj.extendedcalendarview.ExtendedCalendarView;

public class AcademicCaledar extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_academicalendar,
				container, false);
		ExtendedCalendarView calendar = (ExtendedCalendarView) rootView
				.findViewById(R.id.calendar);
		adaptCalendar(calendar);
		return rootView;
	}

	private void adaptCalendar(ExtendedCalendarView calendar) {
		// sets the first day of week according to Calendar.
		// here we set Monday as the first day of the Calendar
		// calendar.

		// sets whether to show the week number.
		// calendar.setShowWeekNumber(true);

		// //The background color for the selected week.
		// calendar.setSelectedWeekBackgroundColor(Color.WHITE);

		// calendar.

	}
}
