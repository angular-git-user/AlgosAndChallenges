import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ScaleFactor {

	public static void stringManipulation(String s) {

		char[] array = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {

			Integer value = map.get(array[i]);
			if(value == null) {
				value = new Integer(0); 
			}
			value++;
			map.put(array[i], value);
		}
		
		int previousMax = 100;
		int currentMax = 0;
		StringBuilder stringBuilder = new StringBuilder();
		
		
		for(int t = 0; t <= map.keySet().size(); t++) {
			List<Character> keys = new ArrayList<>();
			for (Character key : map.keySet()) {
			    int value = map.get(key);
				if(value >= currentMax && value < previousMax) {
					
					if(value == currentMax) {
						keys.add(key);
					}else {
						currentMax = value;
						keys = new ArrayList<>();
						keys.add(key);
					}
				}
			}
			t = t + keys.size() ;
			previousMax = currentMax;
			currentMax = 0;
			for(Character c: keys) {
				for(int i = 0; i < previousMax; i++) {					
					stringBuilder.append(c);
				}
			}
		}
		System.out.println(stringBuilder);
	}

	public static void main(String[] args) {

		stringManipulation("axabbxbzxzzx");
	}

}
