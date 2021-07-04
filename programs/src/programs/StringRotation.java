package programs;

public class StringRotation {
	public static void main(String[] args) {
		String original="abcd";
		String rotated="dabc";
		
		System.out.println(isRotated(original,rotated));
	}

	private static boolean isRotated(String original, String rotated) {
		String result = null;
		result=original.charAt(original.length()-1)+original.substring(0,original.length()-1);
		System.out.println(result);
		if(rotated.equals(result))
			return true;
		else 
			return false;
	}

}
