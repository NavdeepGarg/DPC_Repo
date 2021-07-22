package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

interface ABC{
	public void method();
	default void defaultABC()
    {
        System.out.println("Default Method");
    }
}

public class Java8Features {
	
	
	
		static class StaticInner{
			public void show() {
				System.out.println("hello");
			}
		}
		
		class NonStaticInner{
			public void show() {
				System.out.println("hello NonStaticInner");
			}
		}
		
	
	public static void main(String[] args) { 
		
		Java8Features obj = new Java8Features();
		Java8Features.StaticInner o2 = new Java8Features.StaticInner();
		o2.show();
		
		Java8Features.NonStaticInner o3=  obj.new NonStaticInner();
		o3.show();
		
		//Anonymous class
		ABC abc = new ABC() {
			@Override
			public void method() {
				System.out.println("Anonymous Class");			
			}	
			 @Override
			public void defaultABC() {
			//It is Overriding of defaultABC method
				System.out.println("defaultABC Class");			
			}	 
		};		
		abc.method();
		abc.defaultABC();
		//Lambda Expression
		ABC abc2= ()->System.out.println("Lambda Implementation Class");		
		abc2.method();
		
		
		//STREAM Concept
		ArrayList<Integer> original= new ArrayList<>();
		original.add(0);original.add(10);original.add(15);original.add(20);
		
		List<Integer> l1 =original.stream().filter(I->I%2==0).collect(Collectors.toList());
		System.out.println(l1);
		
		List<Integer> l2 = original.stream().map(i->i*2).collect(Collectors.toList());
		System.out.println(l2);
		
		//Consumer Functional Interface
		 Consumer<Integer> consumer= i-> System.out.print(" "+i);
		 for(Integer i : l2)
			 consumer.accept(i);
		 
		 //Supplier Functional Interface
		 Supplier<Integer> supplier =() -> l2.size();
			System.out.println("\n"+supplier.get());
				
		//Date Time API
		 LocalDate date = LocalDate.now(); //JODA time API
		 System.out.println(date);
		 
		 LocalTime time = LocalTime.now();
		 System.out.println(time);
		 
		 
		 //HETREOGENOUS THINGS ADDED ---NOT RECOMMENDED
		 List obj4 = new ArrayList();
		 obj4.add("hello");
		 obj4.add(1);
		 System.out.println(obj4);;
		 
	}

}
