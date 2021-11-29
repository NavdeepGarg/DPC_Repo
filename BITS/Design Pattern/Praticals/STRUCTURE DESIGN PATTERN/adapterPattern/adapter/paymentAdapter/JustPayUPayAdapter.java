package structural.adapterPattern.adapter.paymentAdapter;

import structural.adapterPattern.adapter.external.JustPayUAPI;
import structural.adapterPattern.adapter.external.RazorPayAPI;

public class JustPayUPayAdapter implements PaymentProviderInterface {

	JustPayUAPI justPayAPI;
	
	public JustPayUPayAdapter(JustPayUAPI obj){
		this.justPayAPI=obj;
		
	}
	
	@Override
	public String provideLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean payment(long value) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
