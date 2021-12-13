package com.leet;



public class KadanesAlgo {


	public static int maxSubArray(int[] arr) {

		int ans = Integer.MIN_VALUE;
		int a=0;
		for(int i=0; i < arr.length;i++) {
			a+=arr[i];
			ans = Math.max(ans, a);
			a=Math.max(a,0);

		}

		return ans;
	}



	public static int maxSubArray2(int[] arr) {

		int ans = Integer.MIN_VALUE;
		int csum=arr[0];
		int osum=arr[0];

		for(int i=1; i < arr.length;i++) {

			csum=Math.max(csum+arr[i],arr[i]);

			if(csum > osum) {
				osum= csum;
			}

		}

		return osum;
	}
	public static void main(String[] args) {

		int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
		System.out.println(maxSubArray2(arr));



	}

}
