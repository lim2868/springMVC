package ch04_pjt_ex05.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_ex05.ems.member.MembershipDTO;
import ch04_pjt_ex05.ems.member.service.MembershipDelete;
import ch04_pjt_ex05.ems.member.service.MembershipModify;
import ch04_pjt_ex05.ems.member.service.MembershipRegister;
import ch04_pjt_ex05.ems.member.service.MembershipSelect;
import ch04_pjt_ex05.ems.member.service.PrintMembershipInformation;
import ch04_pjt_ex05.ems.utils.InitSampleData;

public class mainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
	
		
		InitSampleData initSampleData = ctx.getBean("initSampleData",InitSampleData.class);
		String[] userId = initSampleData.getUserIds();
		String[] userPw = initSampleData.getUserPws();
		String[] userTel = initSampleData.getUserTels();
		String[] userEmail = initSampleData.getUserEmails();
		String[] newSineup = initSampleData.getNewSineups();
		String[] lastMf = initSampleData.getLastMfs();
		
		//데이터베이스에 샘플 데이터 등록
		MembershipRegister registerService =
				ctx.getBean("membershipRegister", MembershipRegister.class);
		
		for(int i = 0; i < userId.length; i++) {
			registerService.register(new MembershipDTO(userId[i], userPw[i], userTel[i],
					userEmail[i], newSineup[i],lastMf[i]));
				}
				
				// 학생 리스트
		PrintMembershipInformation printMembershipInformation =
				ctx.getBean("printMembershipInformation",
							PrintMembershipInformation.class);
		printMembershipInformation.printMembershipInfo();
		
		// 학생 등록
		registerService = ctx.getBean("membershipRegister",
				MembershipRegister.class);
		registerService.register(new MembershipDTO("gumin006", "p0006","010-2131-3874", "ff@naver.com", "2022-12-22",
				 "2023-12-10"));
		
		printMembershipInformation.printMembershipInfo();
		
		// 학생 출력
		MembershipSelect membershipSelect =
				ctx.getBean("membershipSelect", MembershipSelect.class);
		MembershipDTO selectedMember = membershipSelect.select("gumin005");
		
		System.out.println("STUDENT START --------------------");
		System.out.print("userId : " + selectedMember.getUserId() + "\t");
		System.out.print("|userPw : " + selectedMember.getUserPw() + "\t");
		System.out.print("|userTel : " + selectedMember.getUserTel() + "\t");
		System.out.print("|userEmai : l" + selectedMember.getUserEmail() + "\t");
		System.out.print("|newsingup : " + selectedMember.getNewSineup() + "\t");
		System.out.print("|last : " + selectedMember.getLastMf() + "\t");
		System.out.println("EMD-----------------------------");
		
		// 학생 수정
		MembershipModify modifyService =
				ctx.getBean("membershipModify", MembershipModify.class);
		modifyService.modify(new MembershipDTO("gumin006", "p0006","010-2131-3874", "ff@naver.com", "2022-12-22",
				 "2023-12-10"));
		
		// 학생 삭제
		MembershipDelete deleteService = 
				ctx.getBean("membershipDelete", MembershipDelete.class);
		deleteService.delete("gumin005");
		
		printMembershipInformation.printMembershipInfo();
	}
}