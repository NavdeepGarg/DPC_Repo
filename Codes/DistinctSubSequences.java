package DP;


public class DistinctSubSequences {
	
	


	//passing positions
	 int numDistinctUtilMemoize(int[][] m, String S, String T, int i, int j) {
		 
		 if(m[i][j]!=-1) {
			 return m[i][j];
		 }
		 if(i==0) {
			 return m[i][j]=0;
		 }
		 if (S.charAt(i-1)==T.charAt(j-1)) { 
			    if (j-1 == 0) 
			      return  m[i][j]=numDistinctUtilMemoize(m,S, T, i-1, j) + 1; 
			    else {
			      return m[i][j]= numDistinctUtilMemoize(m,S, T, i-1, j) +
			    		  numDistinctUtilMemoize(m,S, T, i-1, j-1);
			    }      
			  } 
		 return m[i][j]= numDistinctUtilMemoize(m,S, T, i-1, j); 
	 }
	 
		//passing positions
		int numDistinctUtil(String S, String T, int i, int j) { 
			  if (i < 1 || j < 1 || i < j) 
			    return 0; 
			 
			  if (S.charAt(i-1)==T.charAt(j-1)) { 
				  // B has no more characters left, so solution will be 1
			    if (j-1 == 0) // means first character
			      return numDistinctUtil(S, T, i-1, j) + 1; 
			    else {
			      return numDistinctUtil(S, T, i-1, j) +
				  numDistinctUtil(S, T, i-1, j-1);
			    }      
			  } 
			  return numDistinctUtil(S, T, i-1, j); 
			}
	
	public  int solve(String A, String B, int positionA, int positionB) { 

		if(positionA==0 || positionB==0   || positionB>positionA) {
			return 0;
		}
	  
		if(A.charAt(positionA-1)==B.charAt(positionB-1)) {
			if(positionB-1 ==0) {
				return solve(A, B, positionA-1, positionB) +1;
			}else {
				return solve(A, B, positionA-1, positionB) +  solve(A, B, positionA-1,positionB-1);	
			}
			
			 

		} 
			return solve(A, B, positionA-1, positionB); 
	}


	public static void main(String[] args) {
		/*String A="rabbbit";
		String B="rabbit";*/
		 String A="rabt";
		String B="rat"; 
		DistinctSubSequences o = new DistinctSubSequences();
		System.out.println(o.solve(A, B, A.length(), B.length()));
		System.out.println(o.numDistinctUtil(A, B, A.length(), B.length()));
		int[][] t = new int[A.length()+1][B.length()+1];
		for(int i =0 ; i < t.length;i++) {
			 if(i==0) {
				 t[i][0]=0;
			 }
			for(int j =0 ; j < t[0].length;j++) {
				if(j==0) {
					t[i][j]=1;
				}
				else
					t[i][j]=-1;
			}
				
		}
		 
		
		System.out.println(o.numDistinctUtilMemoize(t, A, B, A.length(), B.length()));
		
	} 



}