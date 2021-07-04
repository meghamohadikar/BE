package programs;

public class Palindrome {
	
	public  static void main(String[] args) {
		String str="aba";
		System.out.println("is given string palindrome:"+palindrome(str));
		System.out.println("after removing given char from string="+removeChar( str, 'b'));
		
	}

	private static boolean palindrome(String str) {
		//StringBuilder->unsynchronized
		StringBuilder strb=new StringBuilder(str);
		strb.reverse(); //will reverse str
		return ((strb.toString()).equals(str));
	}
	
	private static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
        System.out.println(length / 2);
        for (int i = 0; i < length / 2; i++) {

            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }
	
	public static boolean isPalindrome(String s)
    {   // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1)
            return true; 
        if(s.charAt(0) == s.charAt(s.length()-1))
        /* check for first and last char of String:
         * if they are same then do the same thing for a substring
         * with first and last char removed. and carry on this
         * until you string completes or condition fails
         * Function calling itself: Recursion
         */
        return isPalindrome(s.substring(1, s.length()-1));

        /* If program control reaches to this statement it means
         * the String is not palindrome hence return false.
         */
        return false;
    }
	
	public static String reverse(String input){
		if(input == null || input.isEmpty()){ 
			return input; 
			} 
		return input.charAt(input.length()- 1) + reverse(input.substring(0, input.length() - 1)); 
	}

	public static boolean isPalindromeMethod(String input) {
		if (input == null || input.isEmpty()) {
			return true; 
			} 
		char[] array = input.toCharArray(); 
		StringBuilder sb = new StringBuilder(input.length());
		for (int i = input.length() - 1; i >= 0; i--) {
			sb.append(array[i]); 
			} 
		String reverseOfString = sb.toString(); 
		return input.equals(reverseOfString); 
		}
	
	public static String reverse1(String source){
        if(source == null || source.isEmpty()){
            return source;
        }      
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }
     
        return reverse;
    }

	private static String removeChar(String str, char c) {
        if (str == null)
            return null;
        return str.replaceAll(Character.toString(c), "");
    }

}
