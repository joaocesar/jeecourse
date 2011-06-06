package objective.calculator;

public class CalculatorFactory {

	public static Calculator newCalculator() {
		return new HugeCalculator();
	}
}
