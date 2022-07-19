package FileHandLing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file=new File("C:\\Users\\thanga.kumar\\Documents\\anand.txt");
		
		 BufferedReader br = new BufferedReader(new FileReader(file));
     
      String st;
    
      try {
		while ((st = br.readLine()) != null)

		     
		      System.out.println(st);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
}
