package b2b;

import java.util.ArrayList;
import java.util.List;

class Node{
	int value;
	List<Node> neighbourList;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Node> getNeighbourList() {
		return neighbourList;
	}
	public void setNeighbourList(List<Node> neighbourList) {
		this.neighbourList = neighbourList;
	}
	public Node(int value, List<Node> neighbourList) {
		super();
		this.value = value;
		this.neighbourList = neighbourList;
	}
	@Override
	public String toString() {
		 
		StringBuilder str = new StringBuilder();
		str.append(this.getValue());str.append("--");
		str.append(this.getNeighbourList().toString());
		return str.toString();
	}




}
public class NandKQuest {







	public static void solve(int startPoint, int K, int N, List<List<Integer>> global, List<Integer> partial, int orig) {


		if(startPoint==N) {
			//if(K==0) {
			List<Integer> newPartial= new ArrayList<>();
			newPartial.addAll(partial);
			global.add(newPartial);
			return;
		}


		for(int i = startPoint;i<startPoint+K;i++) {

			partial.add(i);
			solve(i+1,K-1,N,global,new ArrayList<Integer>(),orig);
			partial.remove(partial.size()-1);
		}


	}
	
	public static void customDFS(Node root, int K , List<Integer> partial) {
		
		
		if(root==null) return;
		
		int startPoint = root.getValue(); 
		System.out.println("startPoint-- "+startPoint);
		partial.add(startPoint);
		if(K==1) {
			System.out.println(partial.toString());
			return;
		}
		for(Node neighbour : root.getNeighbourList()) {
		//	System.out.println("neighbour-- "+neighbour.getValue());
			customDFS(neighbour,K-1,partial);
			partial.remove(partial.size()-1);
		}
		
	}

	
	public static void createNarryTree(int N, int startPoint,Node input) {
		
		Node  parent=null ;
		parent=input;
		 
	 
		for(int i =startPoint; i <= N; i++) {

			
		 
			for(int j = parent.value+1; j <=N;j++) {
				parent.getNeighbourList().add(new Node(j, new ArrayList<Node>()));
				parent.setNeighbourList(parent.getNeighbourList()); 
			}
			if(parent.getNeighbourList().size()!=0) {
			//parent=root.getNeighbourList().get(i-1);
				Node toSend=parent.getNeighbourList().get(i-1);
				int toSendValue= toSend.getValue();
				createNarryTree(N,toSendValue,toSend);
			}
			
		}
		//return root;
	}
	public static void solve2(int N , int K ) {

		Node root=null, parent=null ;
		boolean rootElementAssigned=false;
		//create the N-ary tree
		for(int i =1; i <= N; i++) {

			if(!rootElementAssigned) {
				root = new Node(i, new ArrayList<Node>());
				parent=root;
				rootElementAssigned=true; 
				 
			}
		 
			for(int j = parent.value+1; j <=N;j++) {
				parent.getNeighbourList().add(new Node(j, new ArrayList<Node>()));
				parent.setNeighbourList(parent.getNeighbourList()); 
			}
			if(parent.getNeighbourList().size()!=0)
			parent=root.getNeighbourList().get(i-1);
			
		}
	  System.out.println(root.toString());
		//   customDFS(root,K,new ArrayList<Integer>());
	}



	public static void main(String[] args) {

		int N=4;int K=3;
	 
	 Node root = new Node(1,new ArrayList<Node>());
	 int rootValue=root.getValue();
		//solve2(N,K);
		createNarryTree(N,rootValue,root);
		
	 

	}

}
