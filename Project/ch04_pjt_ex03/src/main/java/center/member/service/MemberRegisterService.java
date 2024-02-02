package center.member.service;

import center.member.model.MemberDAO;
import center.member.model.MemberVO;

public class MemberRegisterService {

	private MemberDAO memberDAO;

	public MemberRegisterService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void register(MemberVO student) {
		if (verify(student.getmId())) {
			memberDAO.insert(student);
		} else {
			System.out.println("The student has already been registered.");
		}
	}

	public boolean verify(String mId) {
		MemberVO student = memberDAO.select(mId);
		return student == null ? true : false;
	}

}