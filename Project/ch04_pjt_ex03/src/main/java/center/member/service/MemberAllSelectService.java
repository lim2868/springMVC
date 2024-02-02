package center.member.service;

import java.util.Map;

import center.member.model.MemberDAO;
import center.member.model.MemberVO;


public class MemberAllSelectService {

	private MemberDAO memberDAO;

	public MemberAllSelectService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public Map<String, MemberVO> allSelect() {
		return memberDAO.getMemberDB();
	}

}