package ch02_pjt_04;

public class MyCalculator {
	
	public void calculate(int fNum, int sNum, ICalculator calculaotr) {
		int value = calculaotr.doOperation(fNum,sNum);
		System.out.println("result : " + value);
	}
}