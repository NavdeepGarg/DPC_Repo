package structural.adapterPattern.adapter.external;

public class JustPayUAPI {

	
	
	public String provideLink() {
		
	return "URL API";	
	}
	
	public boolean payment(long value) {
		return true;
	}
	
}
