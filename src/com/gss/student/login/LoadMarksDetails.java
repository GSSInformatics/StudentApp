/**
 * 
 */
package com.gss.student.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gss.sliderexample.R;
import com.gss.student.marks.ISemester;
import com.gss.student.marks.Semester;
import com.gss.student.webservice.IWsdl2CodeEvents;
import com.gss.student.webservice.SemesterMarks;
import com.gss.student.webservice.StudentDetails;
import com.gss.student.webservice.SubjectMarks;
import com.gss.student.webservice.VectorSemesterMarks;
import com.gss.student.webservice.VectorSubjectMarks;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class LoadMarksDetails implements IWsdl2CodeEvents {

	private String regdId;
//	private Activity activity;
//	private ProgressBar progressBar;
//	private Button loginButton;

	public LoadMarksDetails(String studentRegdId) {
		this.regdId = studentRegdId;
//		this.progressBar = (ProgressBar) loginActivity
//				.findViewById(R.id.login_progress);
//		this.loginButton = (Button) loginActivity
//				.findViewById(R.id.email_sign_in_button);
//		this.activity = loginActivity;
	}

	@Override
	public void Wsdl2CodeStartedRequest() {
//		loginButton.setEnabled(false);
//		progressBar.setVisibility(View.VISIBLE);
//		progressBar.animate();
	}

	@Override
	public void Wsdl2CodeFinished(String methodName, Object Data) {
		VectorSemesterMarks semMarkList = (VectorSemesterMarks) Data;
		getSemMarkList(semMarkList);

	}

	private List<ISemester> getSemMarkList(VectorSemesterMarks semMarkList) {
		List<ISemester> semList = new ArrayList<ISemester>();
		for (SemesterMarks semMark : semMarkList) {
			Map<String, Integer> marks = new HashMap<String, Integer>();
			int percent = semMark.mPercent;
			String semester = semMark.mSemster;
			VectorSubjectMarks subMarkList = semMark.subjectMarkList;
			for (SubjectMarks subMark : subMarkList) {
				String code = subMark.mSubjectCode;
				int mark = subMark.mMarks;
				marks.put(code, mark);
			}
			Semester sem = new Semester(semester, percent, marks);
			semList.add(sem);
		}
		return semList;
	}

	@Override
	public void Wsdl2CodeFinishedWithException(Exception ex) {
//		progressBar.clearAnimation();
//		loginButton.setEnabled(true);
//		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void Wsdl2CodeEndedRequest() {

	}

	public void callWebservice() {
		StudentDetails details = new StudentDetails(this);
		try {
			details.getMarksAsync(regdId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ISemester> getMarksSyn() {
		StudentDetails details = new StudentDetails(this);
		VectorSemesterMarks vectorMarks = details.getMarks(regdId);
		return getSemMarkList(vectorMarks);
	}

}
