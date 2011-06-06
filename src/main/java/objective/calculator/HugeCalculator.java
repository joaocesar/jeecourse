package objective.calculator;

public class HugeCalculator implements Calculator {

	private StringBuffer minuend, subtraend, parcelLeft, parcelRight;
	
	@Override
	public String add(String left, String right) {

		int sumDigit = 0, carryDigit = 0;
		StringBuffer sum = new StringBuffer();
		
		parcelLeft = new StringBuffer(left);
		parcelRight = new StringBuffer(right);

		if (parcelLeft.length() > parcelRight.length())
			fillLeftStringWithZeros(parcelRight, parcelLeft.length());
		else
			fillLeftStringWithZeros(parcelLeft, parcelRight.length());
		
		fillLeftStringWithZeros(sum, (parcelLeft.length() > parcelRight.length() ? parcelLeft.length() : parcelRight.length()));
		
		for(int i = parcelLeft.length() - 1; i >= 0; i--){
			sumDigit = Integer.parseInt(parcelLeft.substring(i, i+1)) + Integer.parseInt(parcelRight.substring(i,i+1)) + carryDigit;
			if(sumDigit > 9){
				sumDigit -= 10;
				carryDigit = 1;
			} else {
				carryDigit = 0;
			}
			sum.replace(i, i+1, Integer.toString(sumDigit));
		}
		if (carryDigit > 0)
			sum.insert(0,carryDigit);
		
		
		return sum.toString();

	}

	@Override
	public String subtract(String left, String right) {

		int auxDigit = 0, restDigit = 0, minuendDigit, subtraendDigit, originalMinuendDigit;
		StringBuffer rest = new StringBuffer();
		
		minuend = new StringBuffer(left);
		subtraend = new StringBuffer(right);
		
		if (minuend.length() > subtraend.length())
			fillLeftStringWithZeros(subtraend, minuend.length());
		else
			fillLeftStringWithZeros(minuend, subtraend.length());
		
		fillLeftStringWithZeros(rest, (minuend.length() > subtraend.length() ? minuend.length() : subtraend.length()));
		
		for (int i = minuend.length() - 1; i >= 0; i--) {
			minuendDigit = Integer.parseInt(minuend.substring(i, i+1));
			subtraendDigit = Integer.parseInt(subtraend.substring(i, i+1));
			if (((minuendDigit - auxDigit) < subtraendDigit) || auxDigit == 1) {
				originalMinuendDigit = minuendDigit;
				minuendDigit = (minuendDigit - auxDigit);
				if (minuendDigit < subtraendDigit)
					minuendDigit += 10;
				auxDigit = ((originalMinuendDigit - auxDigit) < subtraendDigit) ? 1 : 0;
			} else {
				auxDigit = 0;
			}
			restDigit = minuendDigit - subtraendDigit;
			rest.replace(i, i+1, Integer.toString(restDigit));
		}

		if (auxDigit == 1) {
			restDigit = 10 - Integer.parseInt(rest.substring(0, 1));
			rest.replace(0, 1, Integer.toString(restDigit));
			rest.insert(0, "-");
		}
		
		return rest.toString();
	}

	private void fillLeftStringWithZeros(StringBuffer value, int length) {

		int valueLength = value.length();
		
		for (int i = 0; i < length-valueLength; i++) {
			value.insert(0, "0");
		}
		
	}

	@Override
	public int compare(String left, String right) {

		int comparation = 0;
		
		if (left.equals(right))
			return comparation;

		parcelLeft = new StringBuffer(left);
		parcelRight = new StringBuffer(right);

		if (parcelLeft.length() > parcelRight.length())
			fillLeftStringWithZeros(parcelRight, parcelLeft.length());
		else
			fillLeftStringWithZeros(parcelLeft, parcelRight.length());

		comparation = (parcelLeft.toString().compareTo(parcelRight.toString())) > 0 ? 1 : -1;
		
		return comparation;
		
	}

}
