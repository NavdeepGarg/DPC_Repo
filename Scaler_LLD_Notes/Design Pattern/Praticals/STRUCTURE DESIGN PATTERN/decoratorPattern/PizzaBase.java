package structural.decoratorPattern;

public class PizzaBase implements Pizza{
	
	

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public String getComposition() {
	 
		return "PizzaBase";
	}

}

