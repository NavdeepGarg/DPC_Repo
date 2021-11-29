package structural.decoratorPattern;

public class Client {

	
	
	public static void main(String[] args) {
		
		Pizza pizza = new PaneerTopping( new CheeseTopping(new PizzaBase()));
		
		
	}
}
