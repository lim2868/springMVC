package ch02_pjt_04;

public class CalDivImpl implements ICalculator {
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return secondNum != 0 ? (firstNum / secondNum) : 0;
	}
}
