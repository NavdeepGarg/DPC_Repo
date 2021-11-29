package structuralPattern.adapter.paymentAdapter;

import structuralPattern.adapter.external.JustPayUAPI;
import structuralPattern.adapter.external.RazorPayAPI;

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
