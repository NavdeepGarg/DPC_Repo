package fundamentals;

public class CloningExample {
	
	
	public static void main(String[] args) {
		
		int[][] x= {{10,20,30},{1,2,3}};
		int [][]y = x.clone();
	//	x[0]= new int[] {7,77,777};
		
		System.out.println(x.equals(y));
		System.out.println(x==y);
		System.out.println(x[0]==y[0]);
		
	}

}
