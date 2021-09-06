package LinkedList;

import javax.swing.plaf.synth.SynthSpinnerUI;

class ListNode{
	
	int value;
	ListNode next;
	public ListNode(int value) {
		super();
		this.value = value;
		this.next=null;
	}
	
	
}

public class ReverseInGivenIndex {
	
	public static void revereLL(ListNode head){
		
		ListNode current = head;
		ListNode currentemp = head;
		ListNode next = null;
		ListNode prev=null;
		
		System.out.println("before");
		while(currentemp!=null) {
			System.out.print(currentemp.value+",");
			currentemp=currentemp.next;
		}
		System.out.println("");
		currentemp = head;
		
		while(current!=null) {
		 next=current.next;
		 current.next= prev;
		 prev=current;
		 current=next;
		}
		System.out.println("after");
		currentemp=prev;
		while(currentemp!=null) {
			System.out.print(currentemp.value+",");
			currentemp=currentemp.next;
		}
		System.out.println("");
	}

	
	  public static void reverseBetween(ListNode head, int start, int end) {
			
			ListNode current = head;
			ListNode currentemp = head;
			ListNode next = null;
			ListNode prev=null;
			int startIndex=1;
			while( startIndex<start) {
				prev=current;
				current=current.next;
				 
				startIndex++;
			}
			ListNode endref=current;
			ListNode startref=current;
			while(startIndex<end && endref!=null) {
				endref= endref.next ;
				startIndex++;
			}
			prev=current;
			current=current.next;
			
			while(start <end && current!=null && endref!=current) {
				System.out.println("curr value "+current.value);
				 next=current.next;
				 current.next= prev;
				 prev=current;
				 current=next;
				 start++;
			}
			
			prev.next=endref;
			int temp=startref.value;
			startref.value= endref.value;
			endref.value=temp;
			
			System.out.println("after");
			currentemp=head;
			while(currentemp!=null) {
				System.out.print(currentemp.value+",");
				currentemp=currentemp.next;
			}
		  
		    
	  } 
	 
	 public static void main(String[] args) {
		
		 
		 ListNode node1= new ListNode(1);ListNode node2= new ListNode(2);
		 node1.next=node2;
		 ListNode node3= new ListNode(3);ListNode node4= new ListNode(4);ListNode node5= new ListNode(5);
		 node2.next=node3;
		 node3.next=node4;
		 node4.next=node5;
		 node5.next=null;
		 
		 
		 
	//	 revereLL(node1);
		 reverseBetween(node1,1,4);
		 
	}
}
