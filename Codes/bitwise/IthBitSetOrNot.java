package bitwise;

public class IthBitSetOrNot {

	
	public static void main(String[] args) {
		
		int N = 8;
		int checkingBit = 3;
		
		 if(( N & (1 << checkingBit)) != 0)
	            System.out.println("OK");
	        else
	        	System.out.println("noT");
		
	}
}
