package ch06_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ch06_pjt_01.ems.member.StudentDTO;

public class StudentDao {
	
	private Map<String, StudentDTO> studentDB = new HashMap<String, StudentDTO>();
	
	public void insert(StudentDTO student) {
		studentDB.put(student.getsNum(), student);
	}
	
	public StudentDTO select(String sNum) {
		return studentDB.get(sNum);
	}
	
	public void update(StudentDTO student) {
		studentDB.put(student.getsNum(), student);
	}
	
	public void delete(String sNum) {
		studentDB.remove(sNum);
	}
	
	public Map<String, StudentDTO> getStudentDB(){
		return studentDB;
	}
}