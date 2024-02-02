package center.member.service;

import center.member.model.MemberDAO;
import center.member.model.MemberVO;

public class MemberSelectService {

	private MemberDAO memberDAO;

	public MemberSelectService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public MemberVO select(String mId) {
		if (verify(mId)) {
			return memberDAO.select(mId);

		} else {
			System.out.println("Student information is not available.");
		}

		return null;
	}

	public boolean verify(String mId) {
		MemberVO student = memberDAO.select(mId);
		return student != null ? true : false;
	}

}