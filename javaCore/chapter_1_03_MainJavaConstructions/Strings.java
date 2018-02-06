package chapter_1_03_MainJavaConstructions;

public class Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0123456".substring(2, 3));
		System.out.println("aavvVV".equalsIgnoreCase("AAVvvv"));
		System.out.println("asdsa".codePointCount(0, "asdsa".length()));
		
		String codePoints = "Î is the set of octonions";
		System.out.println(codePoints.charAt(2));
		System.out.println('\u00ea');
		System.out.println(Character.isSurrogate('\udc01'));
		System.out.println(Character.isSupplementaryCodePoint('\udc01'));
		
		StringBuilder sb = new StringBuilder();
		sb.append("semo");
		System.out.println(sb);
		sb.delete(2, 3);
		System.out.println(sb);
		
	}

}
