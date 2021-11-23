package fundamentals;

public class TowerOfHanoi {
	
	public void towerofHanoi(int n , char disk1, char disk2, char disk3) {
		
		if(n==0) {
			return;
		}
		
		towerofHanoi(n-1, disk1, disk3, disk2);
		System.out.println(n+"["+disk1+","+disk2+"]");
		towerofHanoi(n-1, disk3, disk2, disk1);
		
	}
	
	
	public static void main(String[] args) {
		
		TowerOfHanoi o = new TowerOfHanoi();
		o.towerofHanoi(3, 'A', 'B', 'C');
		
	}

}
