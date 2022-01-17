package com.leet.jan;

public class MatrixChainMultiplication {

	
	public int matrixMultiplications(int[] arr) {
		
		int dp[][] = new int[arr.length-1][arr.length-1];
		
		for(int gap =0 ; gap<dp.length;gap++) {
			
			for(int i =0 , j =gap; j < dp.length;j++,i++) {
				
				if(gap==0) {
					dp[i][j]=0;
				}
				if(gap==1) {
					dp[i][j]=arr[i]*arr[j]*arr[j+1];
				}
				else {
					int min = Integer.MAX_VALUE;
					for(int k =i; k <j;k++ ) {
						
						int leftPart=dp[i][k];
						int rightPart= dp[k+1][j];
						
						int calc = arr[i]*arr[k+1]*arr[j+1];
						int tc =leftPart+rightPart+calc;
						if(tc<min) {
							min=tc;
						}
						
					}
					dp[i][j]=min;
				}
			}
			
		}
		
		
		
		return dp[0][dp.length-1];
		
	}
	
}
