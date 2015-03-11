package com.gss.student.fragments;

import java.util.List;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.gss.sliderexample.R;
import com.gss.student.attendance.AttendanceInfo;
import com.gss.student.attendance.IAttendance;
import com.gss.student.login.LoadMarksDetails;
import com.gss.student.login.LoadStudentDetails;
import com.gss.student.marks.ISemester;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	private IAttendance attendance;

	private String regId;

	public MainActivity() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new
				StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
				StrictMode.setThreadPolicy(policy);
		
		attendance = (AttendanceInfo) getIntent().getSerializableExtra(
				"attendanceInfo");
		regId = getIntent().getStringExtra("regId");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {

		switch (position) {
		case 0: {
			LoadStudentDetails attendanceDetails = new LoadStudentDetails();
			AttendanceInfo attendanceInfo = attendanceDetails.getAttendanceSync(regId);
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new Attendance(attendanceInfo))
					.commit();
		}
			break;
		case 1: {
			LoadMarksDetails mrksDetails = new LoadMarksDetails(regId);
			List<ISemester> marksSyn = mrksDetails.getMarksSyn();
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new Marks(marksSyn)).commit();
		}
			break;
		case 2: {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new Books()).commit();
		}
			break;
		case 3: {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new Profile()).commit();
		}
			break;
		case 4: {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new EventFragment()).commit();
		}
			break;
		case 5: {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new AcademiCalendar()).commit();
		}
			break;
		case 6: {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new Settings()).commit();
		}
			break;
		case 7: {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.container, new About()).commit();
		}
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
