package structural.decoratorPattern;

public class PaneerTopping implements Pizza{
	Pizza pizza;
	
	PaneerTopping(Pizza pizza){
		this.pizza=pizza;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost()+50;
	}

	@Override
	public String getComposition() {
		// TODO Auto-generated method stub
		return  pizza.getComposition()+"Paneer";
	}
	

}
