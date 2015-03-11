/**
 * 
 */
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
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.LimitLine;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.XLabels.XLabelPosition;
import com.github.mikephil.charting.utils.YLabels;
import com.github.mikephil.charting.utils.YLabels.YLabelPosition;
import com.gss.sliderexample.R;
import com.gss.student.attendance.IAbsent;
import com.gss.student.attendance.IAttendance;

/**
 * @author admin
 *
 */
public class Attendance extends Fragment {

	private BarChart chart;

	private View rootView;

	private IAttendance attendance;

	public Attendance(IAttendance attendance) {
		this.attendance = attendance;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_marks, container, false);
		chart = (BarChart) rootView.findViewById(R.id.chart);
		displayChart();
		return rootView;
	}

	private void displayChart() {
		ArrayList<String> xVals = new ArrayList<String>();
		ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
		for (IAbsent absent : attendance.getMonthlyAbsentees()) {
			xVals.add(absent.getMonthName());
			BarEntry mat = new BarEntry(absent.getMonthlyPercentage(),
					absent.getMonth() - 1);
			yVals.add(mat);
		}
		BarDataSet dataSet = new BarDataSet(yVals, "");
		BarData data = new BarData(xVals, dataSet);
		XLabels xl = chart.getXLabels();
		xl.setPosition(XLabelPosition.BOTTOM_INSIDE); // set the position
		xl.setSpaceBetweenLabels(3);
		xl.setCenterXLabelText(true);

		LimitLine ll = new LimitLine(30);
		ll.setLineColor(Color.RED);
		ll.setLineWidth(4f);
		data.addLimitLine(ll);
		chart.animateY(3000);
		chart.setData(data);
		chart.fitScreen();

		chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

			@Override
			public void onValueSelected(Entry e, int dataSetIndex) {
				IAbsent monthAbsents = attendance.getMonthlyAbsentees().get(
						e.getXIndex());
				displayMonthlyChart(monthAbsents);
			}

			@Override
			public void onNothingSelected() {

			}
		});
	}

	protected void displayMonthlyChart(IAbsent monthAbsents) {
		chart.setVisibility(View.GONE);

		ScatterChart scatterChart = new ScatterChart(getActivity());
		((RelativeLayout) rootView).addView(scatterChart);

		SparseArray<List<Integer>> dayAttendance = monthAbsents
				.getDailyAbsentees();
		scatterChart.setData(getScatterDataBasedOnMonth(dayAttendance));

		XLabels xl = scatterChart.getXLabels();
		xl.setPosition(XLabelPosition.BOTTOM); // set the position
		xl.setSpaceBetweenLabels(1);

		YLabels y1 = scatterChart.getYLabels();
		y1.setPosition(YLabelPosition.LEFT);
		y1.setShowOnlyMinMax(false);

		scatterChart.animateY(3000);
		scatterChart.fitScreen();
		scatterChart.setStartAtZero(false);
		scatterChart.setValueFormatter(new ValueFormatter() {

			@Override
			public String getFormattedValue(float value) {
				return Integer.toString((int) value);
			}
		});
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
		String[] periodNames = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		ScatterData data = new ScatterData(periodNames);
		for (int i = 0; i < dayAttendance.size(); i++) {
			int day = dayAttendance.keyAt(i);
			ArrayList<Entry> yVals = new ArrayList<>();
			List<Integer> periodAbsentes = dayAttendance.get(day);
			for (int periodIdx : periodAbsentes) {
				yVals.add(new Entry(day, periodIdx-1));
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
