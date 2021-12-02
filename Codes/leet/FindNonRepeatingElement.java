package com.leet;

public class FindNonRepeatingElement {
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {2,2,1,1,3};
		
		int val=0;
		for(int i =0 ; i < arr.length;i++) {
			val=val^arr[i];
		}
			System.out.println(val);
		
		
	} 
	

}
