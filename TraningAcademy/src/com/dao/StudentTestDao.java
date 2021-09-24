package com.dao;

import java.util.List;
import java.util.Map;

import com.model.StudentTest;


public interface StudentTestDao {
	boolean addStudentMarks(StudentTest st);
	boolean deleteStudentMarks(int id);
	boolean updateStudentMarks(StudentTest st);
	public Map<String , Integer> getBatchwiseTop();
	List<StudentTest> getAllStudentTest();
}





		
		