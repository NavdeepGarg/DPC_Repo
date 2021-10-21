package graph; 

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Graph{

	public int V;
	public LinkedList<Integer>[] adjList;


	
	public Graph(int v) {
		super();
		V = v;
	}
	public int getV() {
		return V;
	}
	public void setV(int v) {
		V = v;
	}
	public void initializeGraph() {

		this.adjList=new LinkedList[this.V];

		for(int i =0; i < adjList.length ;i++) {

			adjList[i]= new LinkedList<>();

		}

	}
	public void createEdge(LinkedList<Integer> a[], int source, int dest) {

		a[source].add(dest);

	}

	public void bfstraversal(LinkedList<Integer> a[], int root) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		Set<Integer> vistedVertex = new HashSet<>();
		
		queue.add(root);
		
		
		while(!queue.isEmpty()) {
			
			int temp   = queue.poll();
			
			if(!vistedVertex.contains(temp)) {
				System.out.println(temp);
			for(int x : a[temp]) {
				queue.add(x);
			}
			}
			
			vistedVertex.add(temp);
			
		}
		
		
	}

}

public class GraphTraversal {
	
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.initializeGraph();
		g.createEdge(g.adjList, 0, 1);
	    g.createEdge(g.adjList, 0, 2);
	    g.createEdge(g.adjList, 1, 2);
	    g.createEdge(g.adjList, 2, 0);
	    g.createEdge(g.adjList, 2, 3);
	    g.createEdge(g.adjList, 3, 3);
	    
	    
	    g.bfstraversal(g.adjList, 0);
		
	}
	
	
	
   

}
