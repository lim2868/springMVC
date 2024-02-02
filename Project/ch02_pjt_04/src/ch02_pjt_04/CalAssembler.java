package ch02_pjt_04;

import java.util.Scanner;

public class CalAssembler {
	
	MyCalculator calculator;
	CalAddImpl calAdd;
	CalSubImpl calSub;
	CalMulImpl calMul;
	CalDivImpl calDiv;
	CalremainImpl calrem;
	Scanner sc = new Scanner(System.in);
	
	public CalAssembler() {
		calculator = new MyCalculator();
		calAdd = new CalAddImpl();
		calSub = new CalSubImpl();
		calMul = new CalMulImpl();
		calDiv = new CalDivImpl();
		calrem = new CalremainImpl();
		
		assemble();
	}
	
	public void assemble() {
		System.out.print("first 연산자 : ");
		int a = sc.nextInt();
		System.out.print("second 연산자 : ");
		int b = sc.nextInt();
		System.out.print("operation 연산자 : ");
		String c = sc.next();
			switch(c) {
			case "+": calculator.calculate(a,b,calAdd); break;
			case "-": calculator.calculate(a,b,calSub); break;
			case "*": calculator.calculate(a,b,calMul); break;
			case "/": calculator.calculate(a,b,calDiv); break;
			case "%": calculator.calculate(a,b,calrem); break;
			default : System.out.println("입력된 연산자가 다릅니다!!");
			} 
		}
	}