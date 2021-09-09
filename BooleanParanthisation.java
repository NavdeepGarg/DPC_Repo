package DP;

public class BooleanParanthisation {
	
	public int booleanParanthisation(String s, int left, int right) {
		
		if(left==right && (s.charAt(left)=='T' ||s.charAt(left)=='F' )){
			
			if(s.charAt(left)=='T' ) {
				return 1;
			}else
				return 0;
			
			
		}
		int ans=Integer.MIN_VALUE;
		for(int k = left ;k < right;k++) {
			
			if(s.charAt(k)=='T' || s.charAt(k)=='F') {
				continue;
			}
			int l = booleanParanthisation(s, left, k);
			int r= booleanParanthisation(s, k+1, right);
		
			if(s.charAt(k)=='&') {
				ans=Math.max(ans, l&r);
			}
			if(s.charAt(k)=='^') {
				ans=Math.max(ans, l^r);
			}
			if(s.charAt(k)=='&') {
				ans=Math.max(ans, l|r);
			}
		}
		
		return ans;
		
	}
	
	
	
	public static void testBooleanOperators(int l, int r, char op) {
		if(op=='&') {
			System.out.print(op+", ");
			System.out.println(l&r);
		}
		if(op=='^') {
			System.out.print(op+", ");
			System.out.println(l^r);
		}
		if(op=='&') {
			System.out.print(op+", ");
			System.out.println(l|r);
		}
		
		
	}
	
	public static void main(String[] args) {
	
		testBooleanOperators(1, 2, '&');
		testBooleanOperators(1, 2, '^');
		testBooleanOperators(1, 2, '|');
	}

}
