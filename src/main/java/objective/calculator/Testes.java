package objective.calculator;

public class Testes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("JoaoPereira");
		System.out.println(sb);
		sb.insert(4, " ");
		System.out.println(sb);
		sb.insert(5, "Cesar ");
		System.out.println(sb);
		sb.insert(0, ">");
		System.out.println(sb);
		sb.replace(0, 1, "|");
		System.out.println(sb);
		System.out.println(sb.substring(sb.length()-1, sb.length()));
		
		String s1 = "123";
		String s2 = "456";
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s1));
	}

}
