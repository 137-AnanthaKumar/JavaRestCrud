package FileHandLing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileByScanner {

	public static void main(String[] args) throws Exception
	  {
	    // pass the path to the file as a parameter
	    File file = new File("C:\\Users\\thanga.kumar\\Documents\\anand.txt");
	    
	    Scanner sc = new Scanner(file);
	 
	    while (sc.hasNextLine())
	      System.out.println(sc.nextLine());
	  
	
	
	 try {
		 String a="anand";
	      FileWriter myWriter = new FileWriter("C:\\Users\\thanga.kumar\\Documents\\"+a+".txt");
	      myWriter.write("Hi THANGA!");
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}}
