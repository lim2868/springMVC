package ch02_pjt_01;

public class MyCalculator {
	
	public void calAdd(int fNum, int sNum) {
		ICalculator calculator = new CalAddImpl();
		int value = calculator.doOperation(fNum,sNum);
		System.out.println("result : " + value);
	}
	
	public void calSub(int fNum, int sNum) {
		ICalculator calculator = new CalSubImpl();
		int value = calculator.doOperation(fNum,sNum);
		System.out.println("result : " + value);
	}
	
	public void calMul(int fNum, int sNum) {
		ICalculator calculator = new CalMulImpl();
		int value = calculator.doOperation(fNum,sNum);
		System.out.println("result : " + value);
	}
	
	public void calDiv(int fNum, int sNum) {
		ICalculator calculator = new CalDivImpl();
		int value = calculator.doOperation(fNum,sNum);
		System.out.println("result : " + value);
	}
	
}

// Mycalculator 클래스는 CalAddImpl, CalSubImpl, CalMulmpl, CalDivImpl
// 객체를 '이용한다'
// MyCalculator는 직접 계산을 할 수 없어서 CalAddImpl의 의존함