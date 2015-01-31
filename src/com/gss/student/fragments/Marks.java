package com.gss.student.fragments;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.LimitLine;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.XLabels.XLabelPosition;
import com.gss.sliderexample.R;
import com.gss.student.marks.IResult;
import com.gss.student.marks.ISemester;
import com.gss.student.marks.demoData.MarksDemo;

public class Marks extends Fragment {

	private BarChart chart;

	private View rootView;

	private IResult result;

	public Marks() {
		this.result = new MarksDemo();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_marks, container, false);
		chart = (BarChart) rootView.findViewById(R.id.chart);
		displaySemesterChart();
		return rootView;
	}

	private void displaySemesterChart() {
		ArrayList<String> xVals = new ArrayList<String>();
		ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
		for (ISemester sem : result.getSemesterMarks()) {
			xVals.add("" + sem.getSemester());
			BarEntry mat = new BarEntry(sem.getPercentage(),
					sem.getSemester() - 1);
			yVals.add(mat);
		}
		BarDataSet dataSet = new BarDataSet(yVals, "");
		BarData data = new BarData(xVals, dataSet);
		 chart.setDrawXLabels(true);
		XLabels xl = chart.getXLabels();
		xl.setPosition(XLabelPosition.BOTTOM_INSIDE); // set the position
		xl.setSpaceBetweenLabels(3);
		xl.setCenterXLabelText(true);
		chart.setDescription("Semester");

		LimitLine ll = new LimitLine(40);
		ll.setLineColor(Color.RED);
		ll.setLineWidth(4f);
		data.addLimitLine(ll);
		chart.animateY(3000);
		chart.setData(data);
		chart.fitScreen();

		chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

			@Override
			public void onValueSelected(Entry e, int semIndex) {
				displaySubjectChart(result.getSemesterMarks().get(semIndex));
			}

			@Override
			public void onNothingSelected() {

			}
		});
	}

	protected void displaySubjectChart(ISemester semMarks) {
		ArrayList<String> xVals = new ArrayList<String>();
		ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
		int idx = 0;
		for (String subj : semMarks.getSubjectMarks().keySet()) {
			xVals.add(subj);
			BarEntry mat = new BarEntry(semMarks.getSubjectMarks().get(subj),
					idx);
			yVals.add(mat);
			idx++;
		}
		BarDataSet dataSet = new BarDataSet(yVals, "");
		BarData data = new BarData(xVals, dataSet);
		XLabels xl = chart.getXLabels();
		xl.setPosition(XLabelPosition.BOTTOM_INSIDE); // set the position
		xl.setSpaceBetweenLabels(0);
		xl.setCenterXLabelText(true);
		chart.setDrawXLabels(true);
		chart.animateY(3000);
		chart.setData(data);
		chart.fitScreen();
		chart.setDescription("Subject");
	}

	/**
	 * This method is used to display attendance based on the month.
	 * 
	 * 
	 * @param dayAttendance
	 *            map containing daily attendance.
	 * @return
	 */
	public ScatterData getScatterDataBasedOnMonth(
			SparseArray<List<Integer>> dayAttendance) {
		String[] periodNames = new String[] { "1", "2", "3", "4", "5", "6",
				"7", "8" };
		ScatterData data = new ScatterData(periodNames);
		for (int i = 0; i < dayAttendance.size(); i++) {
			ArrayList<Entry> yVals = new ArrayList<>();
			int day = dayAttendance.keyAt(i);// Returns the day which is used as
												// key
			List<Integer> periodAbsentes = dayAttendance.get(day);
			for (int periodIdx : periodAbsentes) {
				yVals.add(new Entry(day, periodIdx));
			}
			ScatterDataSet dataSet = new ScatterDataSet(yVals, "");
			dataSet.setScatterShape(ScatterShape.CIRCLE);
			dataSet.setColor(Color.RED);
			dataSet.setScatterShapeSize(4);
			data.addDataSet(dataSet);
		}
		return data;
	}
}
