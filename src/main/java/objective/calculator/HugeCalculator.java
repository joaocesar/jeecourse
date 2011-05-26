package objective.calculator;

public class HugeCalculator implements Calculator {

	
	public String addR(String left, String right){
		
		return "";
	}
	
	
	@Override
	public String add(String left, String right) {
		
		int rest = 0;
		int sum = 0;
		int bigSize,smallSize;
		String bigString;
		String smallString;
		int sizeLeft = left.length();
		int sizeRight = right.length();
		if (sizeLeft < sizeRight) {
			bigString = right;
			smallString = left;
		} else {
			bigString = left;
			smallString = right;
		}
		bigSize = bigString.length();
		smallSize = smallString.length();
		
		StringBuffer majorString = new StringBuffer();
		
		for(int i = smallSize - 1; i >= 0; i--){
			int j = bigSize - smallSize + i;
			sum = Integer.parseInt(smallString.substring(i, i+1)) + Integer.parseInt(bigString.substring(j,j+1)) + rest;
			if(sum > 9){
				sum = sum - 10;
				rest = 1;
			} else {
				rest = 0;
			}
			majorString.append(sum);
		}
		if (rest > 0)
			majorString.append(rest);
		
		
		return bigString.substring(0, bigSize - smallSize) + majorString.reverse().toString();
	}

	@Override
	public String subtract(String left, String right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compare(String left, String right) {
		// TODO Auto-generated method stub
		return 0;
	}

}
