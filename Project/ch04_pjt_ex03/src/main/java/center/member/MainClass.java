package center.member;

import org.springframework.context.support.GenericXmlApplicationContext;

import center.member.model.MemberVO;
import center.member.service.EMSInformationService;
import center.member.service.MemberDeleteService;
import center.member.service.MemberModifyService;
import center.member.service.MemberRegisterService;
import center.member.service.MemberSelectService;
import center.member.service.PrintMemberInformationService;
import center.member.utils.InitSampleData;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
            	new GenericXmlApplicationContext("classpath:applicationContext.xml");

	// 샘플 데이터
	InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
	String[] mIds = initSampleData.getmIds();
	String[] mPws = initSampleData.getmPws();
	String[] mTels = initSampleData.getmTels();
	String[] mMails = initSampleData.getmMails();
	String[] mRDs = initSampleData.getmRDs();
	String[] mMDs = initSampleData.getmMDs();

	// 데이터베이스에 샘플 데이터 등록
	MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
	for (int i = 0; i < mIds.length; i++) {
		registerService.register(new MemberVO(mIds[i],mPws[i],mTels[i],mMails[i],mRDs[i],mMDs[i]));
	}
	// 학생 리스트
	PrintMemberInformationService printMemberInformatinService = ctx.getBean("printMemberInformationService",
			PrintMemberInformationService.class);
	printMemberInformatinService.printMembersInfo(); // 학생 리스트

	// 학생 등록
	registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
	registerService.register(new MemberVO("deer", "p0006", "melissa", "26", "w", "Music"));

	printMemberInformatinService.printMembersInfo(); // 학생 리스트
	

	// 학생 출력
	MemberSelectService selectService = ctx.getBean("memberSelectService", MemberSelectService.class);
	MemberVO selectedmember = selectService.select("hbs006");

	System.out.println("STUDENT START ------------------");
	System.out.print("|sId:" + selectedmember.getmId() + "\t");
	System.out.print("|sPw:" + selectedmember.getmPw() + "\t");
	System.out.print("|sName:" + selectedmember.getmTel() + "\t");
	System.out.print("|sAge:" + selectedmember.getmMail() + "\t");
	System.out.print("|sGender:" + selectedmember.getmRD() + "\t");
	System.out.println("|sMajor:" + selectedmember.getmMD());
	System.out.println("END ----------------------------");

	// 학생 수정
	MemberModifyService modifyService = ctx.getBean("memberModifyService", MemberModifyService.class);
	modifyService.modify(new MemberVO("pig", "p0066", "melissa", "27", "w", "Computer"));

	printMemberInformatinService.printMembersInfo(); // 학생 리스트

	// 학생 삭제
	MemberDeleteService deleteService = ctx.getBean("memberDeleteService", MemberDeleteService.class);
	deleteService.delete("hbs005");

	printMemberInformatinService.printMembersInfo(); // 학생 리스트

	// 시스템 정보
	EMSInformationService emsInformationService = ctx.getBean("emsInformationService", EMSInformationService.class);
	emsInformationService.printEMSInformation();

	ctx.close();
	}

}
