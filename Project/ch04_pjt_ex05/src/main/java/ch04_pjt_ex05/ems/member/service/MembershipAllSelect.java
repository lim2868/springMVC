package ch04_pjt_ex05.ems.member.service;

import java.util.Map;

import ch04_pjt_ex05.ems.member.MembershipDTO;
import ch04_pjt_ex05.ems.member.dao.MembershipDAO;


public class MembershipAllSelect {

private MembershipDAO membershipDao;
	
	public MembershipAllSelect(MembershipDAO membershipDao) {
		this.membershipDao = membershipDao;
	}
	
	public Map<String, MembershipDTO> allSelect(){
		return membershipDao.getMembershipDB();
	}
}