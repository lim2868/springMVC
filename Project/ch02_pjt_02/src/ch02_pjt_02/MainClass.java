package ch02_pjt_02;

public class MainClass {
	
	public static void main(String[] args) {
	
		MyCalculator calculator = new MyCalculator();
		calculator.calculate(10, 5, new CalAddImpl());
		calculator.calculate(10, 5, new CalSubImpl());
		calculator.calculate(10, 5, new CalMulImpl());
		calculator.calculate(10, 5, new CalDivImpl());
	}
}