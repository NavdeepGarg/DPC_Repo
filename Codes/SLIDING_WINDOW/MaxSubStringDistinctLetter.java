package com.leet;

import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;

//correct
public class MaxSubStringDistinctLetter {
 
	
	public int solve(String s) {
		
		int left=0;
		int res=0;
		Set<Character> chSet=new HashSet<Character>();
		for(int r =0 ; r < s.length();r++) {
			
			while(chSet.contains(s.charAt(r))) {
				chSet.remove(s.charAt(left));
				left++;
			}
			chSet.add(s.charAt(r));
			res=Math.max(res, r-left+1);
			
		}
		return res;
	}
	

	public static void main(String[] args) {

		//	String str = "cbbebi";
	//	String str = "aab" ;
		//String str = "bbbbb" ; 
		String str="dvdf";

		MaxSubStringDistinctLetter obj = new MaxSubStringDistinctLetter();
		 
		System.out.println(obj.solve(str));



	}

}
