package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.StudentDTO;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentSelectService {
	
	private StudentDao studentDao;
	
	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public StudentDTO select(String sNum) {
		if(verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is not available");
		}
		
		return null;
	}
	
	public boolean verify(String sNum) {
		StudentDTO student = studentDao.select(sNum);
		return student != null ? true : false;
	}
}