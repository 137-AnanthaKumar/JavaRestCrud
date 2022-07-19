package Java8;

import java.util.ArrayList;
import java.util.List;

public class Stream {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Ajeet");
		names.add("Negan");
		names.add("Aditya");
		names.add("Steve");
		int count = 0;
		for (String str : names) {
		   if (str.length() < 6) 
//			   System.out.println(str.compareTo("HI"));
			count++; 
		}
		
		//Normal ForEach
	        System.out.println("There are "+count+" strings with length less than 6");
		long count1=names.stream().filter(str->str.length()<6).count();
		
        System.out.println(" USING STREAM :There are "+count1+" strings with length less than 6");

	}

}
