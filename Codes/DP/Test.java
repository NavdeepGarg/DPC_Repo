package DP;

public class Test {

int maxSum=0;
	public int maxProfit(int[] prices) {

		int min = prices[0];
		int profit=0;
		for(int i =1 ; i < prices.length;i++) {

			min=Math.min(min, prices[i]);

			profit=Math.max(profit, prices[i]-min);


		}
		return profit;
	}



	public int splitArray(int[] nums, int m) {

		int left = 0 ; int right = nums.length;


		return splitArray(nums, m,left,right,0);
	}


	private int splitArray(int[] nums, int m, int left, int right, int partitionmaxsum) {

		
		if(m==0) {
			
			int arrsum=0;
			for( int k = left; k < right;k++) {

				arrsum+=nums[k];


			}
			
			maxSum=Math.max(maxSum, arrsum);
			return maxSum;
		}
		
		int mid = (right-left)/2+left;
		int sumUpperBound = 0;
		for(int i = left; i <= mid;i++) {
			sumUpperBound+=nums[i];
		}
		int leftsum =0 ,  j=left;
		int cutAllowed=m;
		while(cutAllowed>0) {
  
			for( int k = left; k < right;k++) {

				//left-k , k+1--right
				while(j<=k) {
					leftsum+=nums[j];j++;
				}
				
				if(leftsum>sumUpperBound) {
					break;
				}
				
				leftsum = Math.min(leftsum,splitArray(nums, --m, k+1, right,leftsum));


			}
			cutAllowed--;
		}

		maxSum=Math.min(maxSum, leftsum);
		return maxSum;
	}



	public static void main(String[] args) {
		//int[] prices = {7,1,5,3,6,4};
		 int[] prices = {7,2,5,10,8};
		
		

		Test o = new Test();
	//	System.out.println(o.maxProfit(prices));
		
		int[] nums  = {7,2,5,10,8};
		int m =2;
		System.out.println(o.splitArray(nums, m));
	}

}
