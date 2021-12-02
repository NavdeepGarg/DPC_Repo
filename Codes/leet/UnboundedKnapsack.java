package com.leet;



public class UnboundedKnapsack {
	
	
	public int possibleCombinations(int[] arr, int sum, int n) {
		
		if(sum==0 || n==0) {
			return 0;
		}
		
		if(sum<arr[n-1]) {
			return possibleCombinations(arr, sum, n-1);
		}
		
		if(sum==arr[n-1]) {
			return 1+ possibleCombinations(arr, sum, n-1);
		}
		
		return possibleCombinations(arr, sum-arr[n-1], n-1)+possibleCombinations(arr, sum-arr[n-1], n);
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr= {1,2};
		int sum =10;
		UnboundedKnapsack obj = new UnboundedKnapsack();
		System.out.println(obj.possibleCombinations(arr, sum, arr.length)); 
		
		
	}

}

/*
	F(10,3)
	
		3
		F(5,2)+				F(5,3)
		
		F(3,1)+				F(3,2)--2
		
		F(2,1)+				F(2,0)--0
		
		F(1,1)+       		F(1,0)--0
		
		1+ f(1,0)--0
		
		
		
		
  F(3,2)
  	F(1,2) +			 F(1,1)1
  	F(1,1)
  	1
  	
  	
  	F(5,3)
  	1+		F(5,2)
  			F(3,1)--1  +    F(3,2)---2
  			*/
  			
  	
  	
  		