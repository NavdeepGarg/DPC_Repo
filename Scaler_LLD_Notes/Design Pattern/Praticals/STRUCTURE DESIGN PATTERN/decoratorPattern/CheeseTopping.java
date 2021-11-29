package structural.decoratorPattern;

public class CheeseTopping implements Pizza{
	Pizza pizza;
	
	CheeseTopping(Pizza pizza){
		this.pizza=pizza;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost()+30;
	}

	@Override
	public String getComposition() {
		// TODO Auto-generated method stub
		return  pizza.getComposition()+"Cheese";
	}
	

}
