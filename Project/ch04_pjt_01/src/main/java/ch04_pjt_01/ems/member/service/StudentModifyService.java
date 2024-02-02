package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.StudentDTO;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentModifyService {
	
	private StudentDao studentDao;
	
	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void modify(StudentDTO student) {
		if(verify(student.getsNum())) {
			studentDao.update(student);
		} else {
			System.out.println("Student information is not avilable");
		}
	}
	
	public boolean verify(String sNum) {
		StudentDTO student = studentDao.select(sNum);
		return student != null ? true : false;
	}
}
