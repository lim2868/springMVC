package ch06_pjt_01.ems;



import org.springframework.context.support.GenericXmlApplicationContext;

import ch06_pjt_01.ems.member.StudentDTO;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		
//		   첫번째 방법
		
//		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// spring 파일 설정을 한꺼번에 몰아서 사용하기
		// 단점 : 관리적인 측면에서 안좋음
		
//		   두번째 방법
//		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml");
		// spring 파일 설정을 Ctx1, Ctx2, Ctx3 로 분리해서 보관하기
		// 첫번째 방법보다 관리적인 측면이 좋음
		
//		   세번째 방법		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// spring 파일 설정을 CtxImport Ctx2,Ctx3를 임포트해서 사용하는 방법
		// 제일 좋은 방법
	
		
		InitSampleData initSampleData = ctx.getBean("initSampleData",InitSampleData.class);
		String[] sNums = initSampleData.getsNums();
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajors = initSampleData.getsMajors();
		
		//데이터베이스에 샘플 데이터 등록
		StudentRegisterService registerService =
				ctx.getBean("studentRegisterService", StudentRegisterService.class);
		
		for(int i = 0; i < sNums.length; i++) {
			registerService.register(new StudentDTO(sNums[i], sIds[i], sPws[i],
					sNames[i],sAges[i],sGenders[i], sMajors[i]));
		}
		
		// 학생 리스트
		PrintStudentInformationService printStudentInformationService =
				ctx.getBean("printStudentInformationService",
							PrintStudentInformationService.class);
		printStudentInformationService.printStudentsInfo();
		
		// 학생 등록
		registerService = ctx.getBean("studentRegisterService",
				StudentRegisterService.class);
		registerService.register(new StudentDTO("hbs006", "deer", "p0086", "melissa",
				24, 'W', "Music"));
		
		printStudentInformationService.printStudentsInfo();
		
		// 학생 출력
		StudentSelectService selectService =
				ctx.getBean("studentSelectService", StudentSelectService.class);
		StudentDTO selectedstudent = selectService.select("hbs006");
		
		System.out.println("STUDENT START --------------------");
		System.out.print("sNum" + selectedstudent.getsNum() + "\t");
		System.out.print("|sId" + selectedstudent.getsId() + "\t");
		System.out.print("|sPw" + selectedstudent.getsPw() + "\t");
		System.out.print("|sName" + selectedstudent.getsName() + "\t");
		System.out.print("|sAge" + selectedstudent.getsAge() + "\t");
		System.out.print("|sGender" + selectedstudent.getsGender() + "\t");
		System.out.println("|sMajor" + selectedstudent.getsMajor() + "\t");
		System.out.println("EMD-----------------------------");
		
		// 학생 수정
		StudentModifyService modifyService =
				ctx.getBean("studentModifyService", StudentModifyService.class);
		modifyService.modify(new StudentDTO("hbs006", "pig", "p0066", "melissa", 27,
				'W', "Computer"));
		
		// 학생 삭제
		StudentDeleteService deleteService = 
				ctx.getBean("studentDeleteService", StudentDeleteService.class);
		deleteService.delete("hbs005");
		
		printStudentInformationService.printStudentsInfo();
		
		//시스템 정보
		EMSInformationService emsInformationService =
				ctx.getBean("emsInformationService", EMSInformationService.class);
		emsInformationService.printEMSInformation();
		
		ctx.close();
	}
}