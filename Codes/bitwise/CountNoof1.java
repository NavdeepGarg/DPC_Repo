package bitwise;

public class CountNoof1 {

	
public static void main(String[] args) {
	
	int n = 23;
	int count =0;
	while(n!=0) {
		
		 n = n&(n-1);
         count++;
		
		
	}
	
	System.out.println(count);
}	 

}
