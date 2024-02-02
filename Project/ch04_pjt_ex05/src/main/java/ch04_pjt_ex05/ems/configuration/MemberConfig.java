package ch04_pjt_ex05.ems.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch04_pjt_ex05.ems.member.dao.MembershipDAO;
import ch04_pjt_ex05.ems.member.service.MembershipAllSelect;
import ch04_pjt_ex05.ems.member.service.MembershipDelete;
import ch04_pjt_ex05.ems.member.service.MembershipModify;
import ch04_pjt_ex05.ems.member.service.MembershipRegister;
import ch04_pjt_ex05.ems.member.service.MembershipSelect;
import ch04_pjt_ex05.ems.member.service.PrintMembershipInformation;
import ch04_pjt_ex05.ems.utils.InitSampleData;

@Configuration
public class MemberConfig {
	
	
	@Bean
	public MembershipDAO membershipDao() {
		return new MembershipDAO();
	}
	
	@Bean
	public MembershipDelete membershipDelete() {
		return new MembershipDelete(membershipDao());
	}
	
	@Bean
	public MembershipModify membershipModify() {
		return new MembershipModify(membershipDao());
	}
	
	@Bean
	public MembershipRegister membershipRegister() {
		return new MembershipRegister(membershipDao());
	}
	
	@Bean
	public MembershipSelect membershipSelect() {
		return new MembershipSelect(membershipDao());
	}
	
	@Bean 
	public MembershipAllSelect membershipAllSelect() {
		return new MembershipAllSelect(membershipDao());
	}
	
	@Bean
	public PrintMembershipInformation printMembershipInformation() {
		return new PrintMembershipInformation(membershipAllSelect());
	}
	
	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		
		String[] userIds =  {"gumin001", "gumin002", "gumin003", "gumin004", "gumin005"};
		initSampleData.setUserIds(userIds);
		
		String[] userPws = {"p0001", "p0002", "p0003", "p0004", "p0005"};
		initSampleData.setUserPws(userPws);
		
		String[] userTels = {"010-1234-5678", "010-3333-1111", "010-2222-1232", "010-2832-2875", "010-2826-2823"};
		initSampleData.setUserTels(userTels);
		
		String[] userEmails = {"aa@naver.com", "bb@naver.com", "cc@naver.com", "dd@naver.com", "ee@naver.com"};
		initSampleData.setUserEmails(userEmails);
		
		String[] newSineups = {"2022-11-22", "2022-10-30", "2022-12-21", "2022-10-11", "2022-11-10"};
		initSampleData.setNewSineups(newSineups);
		
		String[] lastMfs = {"2023-11-10", "2023-11-10", "2023-11-10", "2023-11-10", "2023-11-10"};
		initSampleData.setLastMfs(lastMfs);
		
		return initSampleData;
		
	}
}
