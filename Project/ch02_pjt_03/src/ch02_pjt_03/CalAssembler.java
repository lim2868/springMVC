package ch02_pjt_03;

public class CalAssembler {
	
	MyCalculator calculator;
	CalAddImpl calAdd;
	CalSubImpl calSub;
	CalMulImpl calMul;
	CalDivImpl calDiv;
	
	public CalAssembler() {
		calculator = new MyCalculator();
		calAdd = new CalAddImpl();
		calSub = new CalSubImpl();
		calMul = new CalMulImpl();
		calDiv = new CalDivImpl();
		
		assemble();
	}
	
	public void assemble() {
		calculator.calculate(10, 5, calAdd);
		calculator.calculate(10, 5, calSub);
		calculator.calculate(10, 5, calMul);
		calculator.calculate(10, 5, calDiv);
	}
}
