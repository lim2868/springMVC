package ch02_pjt_03;

public class CalSubImpl implements ICalculator {
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}
}