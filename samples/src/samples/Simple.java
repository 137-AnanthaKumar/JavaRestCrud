package samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simple {

	public static void main(String[] args) {
		int a=50;
		int b=10;
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER No");
		int abs=sc.nextInt();
		System.out.println(abs);
		List<Integer> list=new ArrayList<Integer>();
		int c=0;
		int i;
		for(i=0;a>b;i++) {
			a=a-1;
			b=b+1;
			list.add(c+1);
			c=c+1;	
			System.out.println(list.size());
		}
		if(a<b) {
			
			System.out.println("Hello 1");
		}
		
		System.out.println(list.size());
		System.out.println("Hello");
	}

}
