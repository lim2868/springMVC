package ch02_pjt_04;

public class CalMulImpl implements ICalculator {
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}
}
