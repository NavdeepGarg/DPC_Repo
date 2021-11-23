package fundamentals;

public class Palindorme {
	
	public boolean isPalindrome(String s ) {
		
		if(s==null)
			return false;
		if(s.length()==1)
			return true;
		//index nitin --odd --even aaaa
		int n = 0;
		while(n<s.length()/2) {
			if(s.charAt(n)!=s.charAt(s.length()-n-1)) {
				return false;
			}
			
			n++;
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		Palindorme o = new Palindorme();
		System.out.println(o.isPalindrome("aaaas"));
	}

}
