package structuralPattern.adapter.paymentAdapter;

public interface PaymentProviderInterface {
	
	public String provideLink() ;
	public boolean payment(long value);

}
