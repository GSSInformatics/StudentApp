/**
 * 
 */
package com.gss.student.marks.demoData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gss.student.marks.IResult;
import com.gss.student.marks.ISemester;

/**
 * @author AjaykumarVasireddy
 * @version 1.0
 *
 */
public class MarksDemo implements IResult {

	@Override
	public List<ISemester> getSemesterMarks() {
		List<ISemester> semesterMarkList = new ArrayList<ISemester>();
		int j= 10;
		for (int i = 1; i < 9; i++) {
			j = j+1;
			SemesterDemo semMarks = new SemesterDemo(i, j*2);
			semesterMarkList.add(semMarks);
		}

		return semesterMarkList;
	}

	class SemesterDemo implements ISemester {

		private int semester;
		private int percent;

		public SemesterDemo(int sem, int percent) {
			this.semester = sem;
			this.percent = percent;
		}

		@Override
		public String getSemester() {
			return ""+semester;
		}

		@Override
		public Map<String, Integer> getSubjectMarks() {
			Map<String, Integer> subjects = new HashMap<String, Integer>();
			subjects.put("ENG", 70);
			subjects.put("MAT", 66);
			subjects.put("TEL", 80);
			subjects.put("SAN", 70);
			subjects.put("R12", 60);
			subjects.put("R14", 60);
			subjects.put("Lab1", 80);
			subjects.put("Lab2", 100);
			return subjects;
		}

		@Override
		public int getPercentage() {
			return percent;
		}

	}

}
