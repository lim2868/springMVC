package center.member.service;

import center.member.model.MemberDAO;
import center.member.model.MemberVO;

public class MemberDeleteService {

	private MemberDAO memberDAO;

	public MemberDeleteService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void delete(String mId) {
		if (verify(mId)) {
			memberDAO.delete(mId);
		} else {
			System.out.println("Member information is not available.");
		}
	}

	public boolean verify(String mId) {
		MemberVO member = memberDAO.select(mId);
		return member != null ? true : false;
	}

}