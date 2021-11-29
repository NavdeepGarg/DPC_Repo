package structural.adapterPattern;

import structural.adapterPattern.adapter.paymentAdapter.PaymentProviderInterface;

public class Swiggy {

	PaymentProviderInterface obj;
	
	
	Swiggy(PaymentProviderInterface paymentProvObj){
		this.obj=paymentProvObj;
		
	}
	
	
}
