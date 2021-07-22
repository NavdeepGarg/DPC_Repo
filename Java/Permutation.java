package com.program;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	List<List<String>> permuteStringList = new ArrayList<>();
	List<String> tempList = new ArrayList<>();
	
	public String permuteString(String str,String original,List<String> tempList) {
		
		if(str.length()==0) {
			  
			 return "";
		}
		if(str.length()==1)
		{
			return str;
			
		}
		String s ="";
		
		for(int i = 0 ; i <str.length();i++) {
			char firstLetter = str.charAt(i);
		 
		s= firstLetter+ permuteString(str.substring(0, i)+str.substring(i+1, str.length()),original );
		 System.out.println(s);
		 tempList.add(s);
		if(s.length()==str.length()-1) {
			
		
		permuteStringList.add(s);
			
		}
		 
		 return s;
		
	}
	
	
	public static void main(String[] args) { 
		 
	 
		Permutation obj = new Permutation();
		System.out.println(obj.permuteStringList.size());
		obj.permuteString("abc","abc",new ArrayList<String>());
	 
		System.out.println(obj.permuteStringList);
		System.out.println("end");
		
	 
		 	
			
			
	} 
	

}
