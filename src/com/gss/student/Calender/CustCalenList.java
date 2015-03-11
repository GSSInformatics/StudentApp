/**
 * 
 */
package com.gss.student.Calender;

import java.util.List;

import com.gss.sliderexample.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustCalenList extends ArrayAdapter<IAcademicCal> {

	private Activity context;
	private List<IAcademicCal> calList;

	public CustCalenList(Activity context, List<IAcademicCal> calList) {
		super(context, R.layout.academicalendarow, calList);
		this.context = context;
		this.calList = calList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.academicalendarow, null, true);
		TextView description = (TextView) rowView
				.findViewById(R.id.description);
		description.setText(calList.get(position).getDescription());

		TextView fromDate = (TextView) rowView.findViewById(R.id.fromdate);
		fromDate.setText(calList.get(position).getFromDate());

		TextView toDate = (TextView) rowView.findViewById(R.id.todate);
		toDate.setText(calList.get(position).getToDate());

		TextView weeks = (TextView) rowView.findViewById(R.id.week);
		weeks.setText(calList.get(position).getWeeks());

		return rowView;
	}

}
