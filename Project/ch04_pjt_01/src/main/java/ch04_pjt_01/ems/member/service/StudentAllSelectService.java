package ch04_pjt_01.ems.member.service;

import java.util.Map;

import ch04_pjt_01.ems.member.StudentDTO;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService {
	
	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, StudentDTO> allSelect(){
		return studentDao.getStudentDB();
	}
}
