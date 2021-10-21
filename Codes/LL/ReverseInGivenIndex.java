package LinkedList;
 

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

	public static ListNode   revereLL(ListNode head){

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
		return prev;
	}

	public static ListNode revereLL(ListNode head, int length){

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
		int start=0;
		while(current!=null && start<=length) {
			next=current.next;
			current.next= prev;
			prev=current;
			current=next;
			start++;
		}
		System.out.println("after");
		currentemp=prev;
		while(currentemp!=null) {
			System.out.print(currentemp.value+",");
			currentemp=currentemp.next;
		}
		System.out.println("");
		return prev;
	}

	public static ListNode reverseBetween(ListNode head, int start, int end) {

		ListNode current = head;
	 
		ListNode next = null;
		ListNode prev=current;
		int startIndex=1;
		ListNode startref= null;
		
		if(start==1) {
			startref=new ListNode(-1);
			startref.next=head;
		}
		else {
		while( startIndex<start) {
			prev=current;
			current=current.next;

			startIndex++;
		}
		startref=prev;
		}

		
		ListNode endref=current;
	
		while(startIndex<end && endref!=null) {
			endref= endref.next ;
			startIndex++;
		}
		endref=endref.next;
		prev=revereLL(startref.next, end-start);
		startref.next=prev;
		while(prev.next!=null) {
			prev= prev.next;
		}
		prev.next=endref;


		//After required reversal;
		System.out.println("After required reversal ");
		ListNode temp =null;
		if(start==1) {
			temp=startref.next;
		}
		else {
			temp= head;
		}
		while(temp!=null) {
			System.out.print(temp.value+",");
			temp=temp.next;
		}

		return head;
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
