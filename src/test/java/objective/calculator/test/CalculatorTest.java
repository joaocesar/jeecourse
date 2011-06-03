package objective.calculator.test;

import static org.junit.Assert.assertEquals;
import objective.calculator.Calculator;
import objective.calculator.HugeCalculator;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add() {
		Calculator calc = new HugeCalculator();
		
		String valuerLeft = "12345678910123456";
		String valueRight = "2000";
		String result = calc.add(valuerLeft, valueRight);
		
		assertEquals("Result Expected","12345678910125456",result);
	}
	
	@Test
	public void subtract() {
		Calculator calc = new HugeCalculator();
		
		String valuerLeft = "12345678910123456";
		String valueRight = "4000";
		String result = calc.subtract(valuerLeft, valueRight);
		
		assertEquals("Result Expected","12345678910119456",result);
	}

}
