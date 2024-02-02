package ch04_pjt_ex05.ems.member.service;

import ch04_pjt_ex05.ems.member.MembershipDTO;
import ch04_pjt_ex05.ems.member.dao.MembershipDAO;

public class MembershipModify {
	
private	MembershipDAO membershipDao;
	
	public MembershipModify(MembershipDAO membershipDao) {
		this.membershipDao = membershipDao;
	}
	
	public void modify(MembershipDTO member) {
		if(verify(member.getUserId())) {
			membershipDao.update(member);
		} else {
			System.out.println("member information is not avilable");
		}
	}
	
	public boolean verify(String userId) {
		MembershipDTO member = membershipDao.select(userId);
		return member != null ? true : false;
	}
}
