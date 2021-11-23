package fundamentals;

public class Fibonacci {

	
	public int fibonaaci(int N, int[] dp) {
		
		//Base
		if(N-1==0) {
			 dp[N-1]=0;
			 return N-1;
		}
			if(N-1==1) {
				 dp[N-1]=1;
				 return N-1;
		}
			dp[N-1]=  fibonaaci(N-1,dp)+fibonaaci(N-2,dp);
			 
			return dp[N-1];
			
	}
	
	public static void main(String[] args) {
		
		Fibonacci ob = new Fibonacci();
		int dp[] = new int[6];
		ob.fibonaaci(6,dp);
		for(int i : dp) {
			System.out.print(i+" ");
		}
		
	}
}
