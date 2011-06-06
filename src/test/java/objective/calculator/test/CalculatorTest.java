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

		valuerLeft = "12345678910123456";
		valueRight = "90000000000002000";
		result = calc.add(valuerLeft, valueRight);
		
		assertEquals("Result Expected","102345678910125456",result);

	}
	
	@Test
	public void subtract() {
		Calculator calc = new HugeCalculator();
		
		String valuerLeft = "12345678910123456";
		String valueRight = "4000";
		String result = calc.subtract(valuerLeft, valueRight);
		
		assertEquals("Result Expected","12345678910119456",result);

		valuerLeft = "10000000000000000";
		valueRight = "40000000000000000";
		result = calc.subtract(valuerLeft, valueRight);
		
		assertEquals("Result Expected","-30000000000000000",result);
	}

	@Test
	public void compare() {
		Calculator calc = new HugeCalculator();
		
		String valuerLeft = "12345678910123456";
		String valueRight = "12345678910123456";
		int result = calc.compare(valuerLeft, valueRight);
		
		assertEquals("Result Expected",0,result);

		valuerLeft = "12345678910123456";
		valueRight = "12345678910123450";
		result = calc.compare(valuerLeft, valueRight);
		
		assertEquals("Result Expected",1,result);

		valuerLeft = "12345678910123000";
		valueRight = "12345678910123450";
		result = calc.compare(valuerLeft, valueRight);
		
		assertEquals("Result Expected",-1,result);

	}
}
