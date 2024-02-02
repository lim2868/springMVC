package ch02_pjt_04;

public class CalAddImpl implements ICalculator {
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}
}
