package com.gss.student.fragments;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gss.sliderexample.R;
import com.gss.student.events.CustomList;
import com.gss.student.events.GridCellAdapter;
import com.gss.student.events.ICollegeEvent;
import com.gss.student.events.ICollegeEvent1;
import com.gss.student.events.IEventTime;

@TargetApi(3)
public class EventFragment extends Fragment implements OnClickListener {
	private static final String tag = "MyCalendarActivity";

	private TextView currentMonth;
	private ImageView prevMonth;
	private ImageView nextMonth;
	private GridView calendarView;
	private GridCellAdapter adapter;
	private Calendar _calendar;
	private int month, year;

	private ListView eventTimeView;
	private static final String dateTemplate = "MMMM yyyy";

	/**
	 * Called when the activity is first created.
	 * 
	 * @param addEvent
	 */
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		getActivity().setContentView(R.layout.my_calendar_view);
//
//		_calendar = Calendar.getInstance(Locale.getDefault());
//		month = _calendar.get(Calendar.MONTH) + 1;
//		year = _calendar.get(Calendar.YEAR);
//		Log.d(tag, "Calendar Instance:= " + "Month: " + month + " " + "Year: "
//				+ year);
//
//		prevMonth = (ImageView) getActivity().findViewById(R.id.prevMonth);
//		prevMonth.setOnClickListener(this);
//
//		currentMonth = (TextView) getActivity().findViewById(R.id.currentMonth);
//		currentMonth.setText(DateFormat.format(dateTemplate,
//				_calendar.getTime()));
//
//		nextMonth = (ImageView) getActivity().findViewById(R.id.nextMonth);
//		nextMonth.setOnClickListener(this);
//
//		calendarView = (GridView) getActivity().findViewById(R.id.calendar);
//
//		eventTimeView = (ListView) getActivity().findViewById(R.id.eventTimes);
//		adapter = new GridCellAdapter(getActivity(),
//				R.id.calendar_day_gridcell, month, year, createEvents1(),
//				eventTimeView);
//		adapter.notifyDataSetChanged();
//		calendarView.setAdapter(adapter);
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.my_calendar_view, container,
				false);

		_calendar = Calendar.getInstance(Locale.getDefault());
		month = _calendar.get(Calendar.MONTH) + 1;
		year = _calendar.get(Calendar.YEAR);
		Log.d(tag, "Calendar Instance:= " + "Month: " + month + " " + "Year: "
				+ year);

		prevMonth = (ImageView) rootView.findViewById(R.id.prevMonth);
		prevMonth.setOnClickListener(this);

		currentMonth = (TextView) rootView.findViewById(R.id.currentMonth);
		currentMonth.setText(DateFormat.format(dateTemplate,
				_calendar.getTime()));

		nextMonth = (ImageView) rootView.findViewById(R.id.nextMonth);
		nextMonth.setOnClickListener(this);

		calendarView = (GridView) rootView.findViewById(R.id.calendar);

		eventTimeView = (ListView) rootView.findViewById(R.id.eventTimes);
		adapter = new GridCellAdapter(this.getActivity(),
				R.id.calendar_day_gridcell, month, year, createEvents1(),
				eventTimeView);
		adapter.notifyDataSetChanged();
		calendarView.setAdapter(adapter);

		return rootView;

	}

	private ICollegeEvent1 createEvents1() {
		final Map<String, List<IEventTime>> event = new HashMap<String, List<IEventTime>>();
		List<IEventTime> timings = new ArrayList<IEventTime>();
		List<IEventTime> timings2 = new ArrayList<IEventTime>();

		timings.add(createEvent());
		timings.add(createEvent3());
		timings.add(createEvent2());
		timings2.add(createEvent4());

		event.put("23-2-2015", timings);
		event.put("24-2-2015", timings);
		event.put("25-2-2015", timings);
		event.put("26-2-2015", timings);
		event.put("27-2-2015", timings);
		event.put("28-2-2015", timings);
		event.put("1-3-2015", timings);
		event.put("24-3-2015", timings2);

		ICollegeEvent1 collegeEvent1 = new ICollegeEvent1() {

			@Override
			public Map<String, List<IEventTime>> getEvents() {
				return event;
			}
		};
		return collegeEvent1;
	}

	private List<ICollegeEvent> createEvents() {
		List<ICollegeEvent> events = new ArrayList<ICollegeEvent>();
		ICollegeEvent collegeEvent = new ICollegeEvent() {

			@Override
			public String getDate() {
				return "23-02-2015";
			}

			@Override
			public List<IEventTime> getEvents() {
				List<IEventTime> events = new ArrayList<IEventTime>();
				events.add(createEvent());
				events.add(createEvent2());
				events.add(createEvent3());
				events.add(createEvent4());
				return events;
			}
		};
		ICollegeEvent collegeEvent1 = new ICollegeEvent() {

			@Override
			public String getDate() {
				return "10-03-2015";
			}

			@Override
			public List<IEventTime> getEvents() {
				// TODO Auto-generated method stub
				return Collections.singletonList(createEvent());
			}
		};
		ICollegeEvent collegeEvent2 = new ICollegeEvent() {

			@Override
			public String getDate() {
				return "28-04-2015";
			}

			@Override
			public List<IEventTime> getEvents() {
				// TODO Auto-generated method stub
				return Collections.singletonList(createEvent());
			}
		};
		ICollegeEvent collegeEvent3 = new ICollegeEvent() {

			@Override
			public String getDate() {
				return "25-02-2015";
			}

			@Override
			public List<IEventTime> getEvents() {
				// TODO Auto-generated method stub
				return Collections.singletonList(createEvent());
			}
		};
		ICollegeEvent collegeEvent4 = new ICollegeEvent() {

			@Override
			public String getDate() {
				return "24-03-2015";
			}

			@Override
			public List<IEventTime> getEvents() {
				// TODO Auto-generated method stub
				return Collections.singletonList(createEvent());
			}
		};

		events.add(collegeEvent);
		events.add(collegeEvent1);
		events.add(collegeEvent2);
		events.add(collegeEvent3);
		events.add(collegeEvent4);

		return events;
	}

	/**
	 * 
	 * @param month
	 * @param year
	 */
	private void setGridCellAdapterToDate(int month, int year) {
		adapter = new GridCellAdapter(getActivity(),
				R.id.calendar_day_gridcell, month, year, createEvents1(),
				eventTimeView);
		_calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
		currentMonth.setText(DateFormat.format(dateTemplate,
				_calendar.getTime()));
		adapter.notifyDataSetChanged();
		calendarView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		if (v == prevMonth) {
			CustomList eventCusList = new CustomList(getActivity(),
					Collections.<IEventTime> emptyList());
			eventCusList.notifyDataSetChanged();
			eventTimeView.setAdapter(eventCusList);
			if (month <= 1) {
				month = 12;
				year--;
			} else {
				month--;
			}
			Log.d(tag, "Setting Prev Month in GridCellAdapter: " + "Month: "
					+ month + " Year: " + year);
			setGridCellAdapterToDate(month, year);
		}
		if (v == nextMonth) {
			CustomList eventCusList = new CustomList(this.getActivity(),
					Collections.<IEventTime> emptyList());
			eventCusList.notifyDataSetChanged();
			eventTimeView.setAdapter(eventCusList);
			if (month > 11) {
				month = 1;
				year++;
			} else {
				month++;
			}
			Log.d(tag, "Setting Next Month in GridCellAdapter: " + "Month: "
					+ month + " Year: " + year);
			setGridCellAdapterToDate(month, year);
		}
	}

	@Override
	public void onDestroy() {
		Log.d(tag, "Destroying View ...");
		super.onDestroy();
	}

	IEventTime createEvent() {
		return new IEventTime() {

			@Override
			public String getTimeRange() {
				return "10:00Am - 1:30Pm";
			}

			@Override
			public String getEventName() {
				return "Online Exam in C,C#";
			}
		};
	}

	IEventTime createEvent3() {
		return new IEventTime() {

			@Override
			public String getTimeRange() {
				return "1:30PM - 02:00PM";
			}

			@Override
			public String getEventName() {
				return "Results";
			}
		};
	}

	IEventTime createEvent2() {
		return new IEventTime() {

			@Override
			public String getTimeRange() {
				return "2:00PM - 04:00PM";
			}

			@Override
			public String getEventName() {
				return "Online Exam in java,php";
			}
		};
	}

	IEventTime createEvent4() {
		return new IEventTime() {

			@Override
			public String getTimeRange() {
				return "4:00PM - 5:00PM";
			}

			@Override
			public String getEventName() {
				return "Winners";
			}
		};
	}

}
