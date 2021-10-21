package DP;
//correct
import java.util.Arrays;

public class PalindromicPartition {
	
	static int[][] t;
	
	public int minimumCut(String s ,int left , int right,int[][] t) {
		
		if(left >=right)
			return 0;
		if(t[left][right]!=-1)
			return t[left][right];
		
		int ans=Integer.MAX_VALUE, tempAns;
		
		if(isPalindrome(s,left,right))
			return 0;
		 
		for( int k = left ; k < right;k++) {			
			int l=minimumCut(s, left, k,t);
			int r=minimumCut(s, k+1,right,t );
			tempAns=l+r+1;
			ans = Math.min(ans, tempAns);
		}
	 
		
		return t[left][right]= ans;
		
	}
	
	
	private boolean isPalindrome(String s, int left, int right) {
		 
		while(left<right) {
			if(s.charAt(left)==s.charAt(right)) {
				left++;right--;
				continue;
			}
			return false;
		}
		
		return true;
	}


	public static void main(String[] args) {
		
		String s = "aab";
		PalindromicPartition obj = new PalindromicPartition();
		PalindromicPartition.t= new int[s.length()+1][s.length()+1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				 t[i][j]=-1;
			}
		 
		}

		System.out.println( obj.minimumCut(s, 0, s.length()-1,t));
		
	} 
	

}
