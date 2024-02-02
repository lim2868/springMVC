package center.member.service;

import center.member.model.MemberDAO;
import center.member.model.MemberVO;

public class MemberModifyService {

	private MemberDAO memberDAO;

	public MemberModifyService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void modify(MemberVO member) {
		if (verify(member.getmId())) {
			memberDAO.update(member);
		} else {
			System.out.println("Student information is not available.");
		}
	}

	public boolean verify(String mId) {
		MemberVO member = memberDAO.select(mId);
		return member != null ? true : false;
	}

}