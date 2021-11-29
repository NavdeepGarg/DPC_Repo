package structuralPattern;

import structuralPattern.adapter.paymentAdapter.PaymentProviderInterface;

public class Swiggy {

	PaymentProviderInterface obj;
	
	
	Swiggy(PaymentProviderInterface paymentProvObj){
		this.obj=paymentProvObj;
		
	}
	
	
}
