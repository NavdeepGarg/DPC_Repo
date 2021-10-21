package twopointers;

import java.util.Arrays;

//correct
public class TriangleCount {



	public int triangleCount(int S[]) {

		Arrays.sort(S);
		int targetSum=0;
		int output=0;
		for(int l=0, r = 2; r <S.length;r++ ) {

			targetSum=S[r]; 

			output+=countTargetSum(l,r-1,targetSum,S);

		}

		return output;
	}

	private int countTargetSum(int l, int r, int targetSum, int[] S) {

		int tempSum=0;
		int output=0;
		while(l<r) {

			tempSum= S[l]+S[r];
			 
			if(tempSum > targetSum) {
				output+=r-l;
				r--;
				
			}else {
				l++;
			}
			 
		}

		return output;
	}

	public static void main(String[] args) {

		
		int[]  S= {3,4,6,7};
		//int[]  S= {4,4,4,4};
		TriangleCount obj = new TriangleCount();
		System.out.println(obj.triangleCount(S));
	}

}
