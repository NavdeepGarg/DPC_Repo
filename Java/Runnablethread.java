package test;

public class Runnablethread {

	
	
	//Lambda Expression for anonymous Class
	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->{
			for (int i = 0 ;i < 5; i++) {
				System.out.println("Thread1");
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
					// TODO: handle exception
				} 
				
			}
			
		});
		
		Thread t2 = new Thread(()->{
			for (int i = 0 ;i < 5; i++) {
				System.out.println("Thread2");
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
					// TODO: handle exception
				} 
				
			}
			
		});
		
		
		t1.start();
		try {
			
			Thread.sleep(10);
			t2.start();
			//System.out.println("Bye");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
