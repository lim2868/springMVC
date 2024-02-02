package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.StudentDTO;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentRegisterService {
	
	private StudentDao studentDao;
	
	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void register(StudentDTO student) {
		if(verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has alredy been registered");
		}
	}
	
	public boolean verify(String sNum) {
		StudentDTO student = studentDao.select(sNum);
		return student == null ? true : false;
	}
}