package structuralPattern;

import structuralPattern.adapter.external.RazorPayAPI;
import structuralPattern.adapter.paymentAdapter.PaymentProviderInterface;
import structuralPattern.adapter.paymentAdapter.RazorPaymentAdapter;

public class Client {
	
	
	public static void main(String[] args) {
		PaymentProviderInterface paymentProInstance = new RazorPaymentAdapter(new RazorPayAPI());
		
		
		Swiggy s= new Swiggy(paymentProInstance);
		
		
	}

}
