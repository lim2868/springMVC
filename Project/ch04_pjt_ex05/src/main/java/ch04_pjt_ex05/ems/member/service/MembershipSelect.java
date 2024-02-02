package ch04_pjt_ex05.ems.member.service;

import ch04_pjt_ex05.ems.member.MembershipDTO;
import ch04_pjt_ex05.ems.member.dao.MembershipDAO;

public class MembershipSelect {
	
	private MembershipDAO membershipDao;
	
	public MembershipSelect(MembershipDAO membershipDao) {
		this.membershipDao = membershipDao;
	}
	
	public MembershipDTO select(String userId) {
		if(verify(userId)) {
			return membershipDao.select(userId);
		} else {
			System.out.println("Student information is not available");
		}
		
		return null;
	}
	
	public boolean verify(String userId) {
		MembershipDTO member = membershipDao.select(userId);
		return member != null ? true : false;
	}
}
