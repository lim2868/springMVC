package ch04_pjt_ex05.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_ex05.ems.member.MembershipDTO;

public class PrintMembershipInformation {
	
	MembershipAllSelect membershipAllSelect;
	
	public PrintMembershipInformation(MembershipAllSelect membershipAllSelect) {
		this.membershipAllSelect = membershipAllSelect;
	}
	
	public void printMembershipInfo() {
		
		Map<String, MembershipDTO> allMembership = membershipAllSelect.allSelect();
		Set<String> keys = allMembership.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("MEMBER LIST START -------------");
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			MembershipDTO member = allMembership.get(key);
			System.out.print("userId : " + member.getUserId() + "\t");
			System.out.print("|userPw : " + member.getUserPw() + "\t");
			System.out.print("|userTel : " + member.getUserTel() + "\t");
			System.out.print("|userEmail : " + member.getUserEmail() + "\t");
			System.out.print("|newSineup : " + member.getNewSineup() + "\t");
			System.out.println("|lastMf : " + member.getLastMf() + "\t");
			
		}
		System.out.println("END ------------------------");
	}
}
