package javaExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapsAndDictionaries {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String,String> myMap = new HashMap<String,String>();
		
		for(int i =1; i<=n; i++){
			String name = sc.next();
			int phoneNumber = sc.nextInt();
			myMap.put(name, Integer.toString(phoneNumber));
		}
		
		while(sc.hasNext()){
			String s = sc.next();
			
			if(myMap.containsKey(s)){
				System.out.println(s+"="+ myMap.get(s));
			}
			else{
				System.out.println("Not found");
			}	
		}
		
		sc.close();
	}

}
