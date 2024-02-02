package language;

import java.util.Scanner;

public class kr_eng {
	
	Scanner sc = new Scanner(System.in);
	
	public void bb() {
		System.out.println("Select language! 1.korea, 2.english");
		int a = sc.nextInt();
		
		switch(a) {
		case 1: System.out.println("안녕하세요"); break;
		case 2: System.out.println("Hello"); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
}
