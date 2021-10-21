package DP;

public class BooleanParanthisation {
	
	public static int booleanParanthisation(String s, int left, int right) {
		
		if(left==right && (s.charAt(left)=='T' ||s.charAt(left)=='F' )){
			
			if(s.charAt(left)=='T' ) {
				return 1;
			}else
				return 0;
			
			
		}
		
	
		int ans=0;
		for(int k = left ;k < right;k++) {
			
			if(s.charAt(k)=='T' || s.charAt(k)=='F') {
				continue;
			}
			int l = booleanParanthisation(s, left, k-1);
			int r= booleanParanthisation(s, k+1, right);
		
			if(s.charAt(k)=='&') {
				if((l&r)==1) {
					ans++;
				}
				 
			}
			if(s.charAt(k)=='^') {
				if((l^r)==1) {
					ans++;
				}
			}
			if(s.charAt(k)=='|') {
				if((l|r)==1) {
					ans++;
				}
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
	
		/*testBooleanOperators(1, 2, '&');
		testBooleanOperators(1, 2, '^');
		testBooleanOperators(1, 2, '|');*/
		//String s = "T|F&T^F";
		//String s  ="T^F&T";
		String s ="T|T&F^T";
		System.out.println(booleanParanthisation(s,0,s.length()-1));
		
	}

}
