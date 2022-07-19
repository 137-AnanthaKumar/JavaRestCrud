package Dream11_AutomaticPrizeCalculation;

import java.util.HashMap;
import java.util.Map;

public class Welcome {

	public static void main(String args[]) {
		
		String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" }; 
	
	
	Map<String, Integer> nameAndCount = new HashMap<>(); 
	for (String name : names) { 
		Integer count = nameAndCount.get(name); 
		if (count == null) { 
			nameAndCount.put(name, 1); 
		
		}
		
		else { 
			nameAndCount.put(name, ++count); 
		
		} 
		} 

	System.out.println(nameAndCount);

	}
		
		
	
	}


