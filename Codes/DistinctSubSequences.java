package DP;

 

public class DistinctSubSequences {
	
	public  int solve(String A, String B, int positionA, int positionB) {
		
		if(positionA==0 || positionB==0 || positionA==A.length()) {
			return 0;
		}
		if(A.charAt(positionA-1)!=B.charAt(positionB-1) && (positionA==A.length()|| positionB==B.length()) ) {
			return 0;
		}
		if(A.charAt(positionA-1)==B.charAt(positionB-1) && positionB==B.length()) {
			return 1;
		}
		 
		 if(A.charAt(positionA-1)==B.charAt(positionB-1)) {
			 return solve(A, B, positionA++, positionB++) +  solve(A, B, positionA++, positionB); 
			 
		 }else {
			 return solve(A, B, positionA++, positionB);
		 }
		
		
		
	}
	
	
	public static void main(String[] args) {
		String A="rabbbit";
		String B="rabbit";
		DistinctSubSequences o = new DistinctSubSequences();
		System.out.println(o.solve(A, B, 1, 1));
	} 
	
	

}
