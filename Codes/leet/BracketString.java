package com.leet;

import java.util.Stack;

public class BracketString {
	
	
	public static boolean function(Stack<Character> stack , String str, int index) {
		
		if(index==str.length() && !stack.isEmpty()) {
			return false;
		}
		if(index==str.length()&&stack.isEmpty()) {
			return true;
		}
		
		Character c = str.charAt(index);
		if(c=='(') {
			stack.push(c);
			return function(stack,str,++index);
			
		}
		
		else if(c==')') {
			if(!stack.isEmpty()) {
			stack.pop();
			return function(stack,str,++index);
			}
			else {
				return false;
			}
		}
		else {
			
			//*
			 
		//	Stack<Character> stack2 = (Stack<Character>)stack.clone();
			 
			return function(stack, str.substring(0,index)+str.substring(index+1,str.length()), index)
					|function(stack, str.substring(0,index)+")"+str.substring(index+1,str.length()), index)
					|function(stack, str.substring(0,index)+"("+str.substring(index+1,str.length()), index);
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		String str = "(*))";
		/*System.out.println(str.substring(0, 1)+str.substring(2,str.length()));
		System.out.println(str.substring(0, 1)+"("+str.substring(2,str.length()));
		System.out.println(str.substring(0, 1)+")"+str.substring(2,str.length()));*/
		 Stack<Character> stack = new Stack<>();
		System.out.println(function(stack, str, 0)); 
	 
		 
	}

}
