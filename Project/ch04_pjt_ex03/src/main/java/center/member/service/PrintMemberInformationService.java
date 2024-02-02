package center.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import center.member.model.MemberVO;


public class PrintMemberInformationService {

	MemberAllSelectService allSelectService;

	public PrintMemberInformationService(MemberAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

	public void printMembersInfo() {
		Map<String, MemberVO> allMember = allSelectService.allSelect();
		Set<String> keys = allMember.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("STUDENT LIST START -------------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			MemberVO member = allMember.get(key);
			System.out.print("mId:" + member.getmId() + "\t");
			System.out.print("|mPw:" + member.getmPw() + "\t");

		}
		System.out.println("END ----------------------------");
	}

}