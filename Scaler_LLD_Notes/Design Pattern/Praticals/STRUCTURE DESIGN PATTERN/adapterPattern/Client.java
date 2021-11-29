package structural.adapterPattern;

import structural.adapterPattern.adapter.external.RazorPayAPI;
import structural.adapterPattern.adapter.paymentAdapter.PaymentProviderInterface;
import structural.adapterPattern.adapter.paymentAdapter.RazorPaymentAdapter;

public class Client {
	
	
	public static void main(String[] args) {
		PaymentProviderInterface paymentProInstance = new RazorPaymentAdapter(new RazorPayAPI());
		
		
		Swiggy s= new Swiggy(paymentProInstance);
		
		
	}

}
