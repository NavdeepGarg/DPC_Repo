package structural.adapterPattern.adapter.paymentAdapter;

import structural.adapterPattern.adapter.external.RazorPayAPI;

public class RazorPaymentAdapter implements PaymentProviderInterface {

	
	RazorPayAPI obj;
	
	public RazorPaymentAdapter(RazorPayAPI obj){
		this.obj=obj;
		
	}
	@Override
	public String provideLink() {
		
		obj.provideLink();
		// and do the stuffs
		
		return null;
	}

	@Override
	public boolean payment(long value) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
