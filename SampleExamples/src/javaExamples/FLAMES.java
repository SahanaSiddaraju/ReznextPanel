package javaExamples;

import java.util.*;
import java.util.HashSet;
import java.util.Scanner;

public class FLAMES {
	
	public static String determineFlameType(String flameLetter){
		
		String flameType = "null";
		switch(flameLetter.charAt(0)){
			
		case 'F':
			flameType = "Friends";
			break;
			
		case 'L':
			flameType = "Love";
			break;
			
		case 'A':
			flameType = "Affection";
			break;
			
		case 'M':
			flameType = "Marriage";
			break;
			
		case 'E':
			flameType = "Enemies";
			break;
			
		case 'S':
			flameType = "Sibblings";
			break;
		}
		return flameType;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first name");
		String name1 = sc.next();
		
		System.out.println("Enter second name");
		String name2 = sc.next();
		
		char[] ch1 = name1.toCharArray();
		char[] ch2 = name2.toCharArray();
		
		int i,j = 0;
		List<Character> listC = new ArrayList<Character>();
		
		for( i =0; i< ch1.length; i++){
			boolean flag = true;
			
			for( j=0; j<ch2.length; j++){
				
				 if(ch1[i]!= '*'){
					if(flag){
						if(ch1[i]==ch2[j]){
							ch1[i] = '*';
							ch2[j] = '*';
							flag = false;
						}
					}
				}
			}
		}
		
		for (i = 0 ;i < ch1.length;i++) {
				if(ch1[i]!='*'){
					listC.add(ch1[i]);
					System.out.println(ch1[i]);
					}
		}
		for (j = 0 ;j < ch2.length;j++) {
				if(ch2[j]!= '*'){
					listC.add(ch2[j]);
					System.out.println(ch2[j]);
				}
			}
	     int count = listC.size();
	     
	     ArrayList<String> al = new ArrayList<String>();
	     al.add("F");
         al.add("L");
         al.add("A");
         al.add("M");
         al.add("E");
         al.add("S");
	     
        String temp = " ";
        
        if(count > 0){
        	
        	while(al.size()> 1){
        		
        		int templeng = (count % al.size());
        		if(templeng!=0)
        		{
        			templeng=templeng-1;
        		}
        		else
        		{
        			templeng=al.size()-1;
        		}
        		System.out.println(templeng);
        		
        		ArrayList<String> al1 = new ArrayList<String>();
        		al.remove(templeng);
        		
        		for(i=templeng;i<al.size();i++)
        		{
        			al1.add(al.get(i));
        		}
        		for(i=0;i<templeng; i++)
        		{
        				al1.add(al.get(i));
        		}
        		al.clear();
        		al.addAll(al1);
        		System.out.println(al);
        		
        	}
        }
         /*String ch1String = String.valueOf(ch1);
 		String ch2String = String.valueOf(ch2);
 		System.out.println(ch1String);
 		System.out.println(ch2String);*/
	     
	   /*for(i=al.size();i>1;i--){
	    	 int index = count % (i);
	    	 int temp = al.size()-index;
	    	 if(index==0){
	    		 al.remove(al.size()-1);
	    	 }
	    	 else{
	    		 al.remove(index-1);
	    	 }
	    	 for(int k=0; k<=temp && temp < al.size();k++){
	    		  al.add(k,al.get(al.size()-temp));
	    		  al.remove(al.size()-1);
	    		  temp--;
	    	 }
	     }
	     */
         /*int val = 0;
	     int val1 = 0;
	     
	     
	     while(al.size()>1){
	    	 val = val1;
	    	  int check=0;
	     for(i=0; i<count; i++){
	    	 
	    	 if(val==al.size()-1){
	    		 val = 0;
	    		 check=check+1;
	    		 
	    	 }
	    	 else
	    		 if(check==count-1)
	    		 {
	    			 break;
	    		 }
	    	 else if(al.size()>1){
	    		 val = val+1;
	    		 check=check+1;
	    	 }
	    	 else{
	    		 System.out.println("Actual value");
	    		 break;
	    	 }
	     }
	     
	    
	     System.out.println("removed value" +al.get(val));
	     al.remove(val);
	     System.out.println("After removal" +al.get(val));
	     
	     System.out.println("Size of the Array" +al.size());
	     
		 	if(val<=al.size()-1)
		     {
		 		val1=val;
		 		System.out.println("-----------------"+val1);
		     }
		 	else
		 	{
	    	 val1 = al.size();
	    	 System.out.println("-----------------"+val1);
		 	}
	     	}*/
	     //System.out.println(determineFlameType(al.get()));
		}
	}


