package programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {
	public  static void main(String[] args) {
		String word="maha";
	System.out.println("First non-repeating char is: "+ firstNonRepeatedCharacter(word));
	}

	private static char firstNonRepeatedCharacter(String word) {
		HashMap<Character,Integer> map=new HashMap();
		for(int i=0;i<word.length();i++) {
			char c=word.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		// since HashMap doesn't maintain order, going through string again 
		for (int i = 0; i < word.length(); i++) { 
			char c = word.charAt(i);
			if (map.get(c) == 1) { 
				return c; 
			}
		}
		return 0;
	}
	
	public static char getFirstNonRepeatedChar(String str) {
		Map<Character,Integer> counts = new LinkedHashMap<>(str.length());  //as LinkedHashMap maintains insertion order
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1); 
			} 
		for (Entry<Character,Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) { 
				return entry.getKey();
				} 
			} throw new RuntimeException("didn't find any non repeated Character"); 
			}


}
