package graph; 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	public void createEdge(LinkedList<Integer>[] adjList, int source, Integer dest) {

		adjList[source].add(dest);

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

	
	public void printAllPath(int src, int dest,LinkedList<Integer>[] graph) {
		
		List<List<Integer>> globalList= new ArrayList<List<Integer>>();
		Set<Integer> vistedVertex = new HashSet<>();
		
		ArrayList<Integer> partialList= new ArrayList<>();
		partialList.add(src);
		vistedVertex.add(src);
		 printAllPath( src,  dest, graph,partialList, globalList,vistedVertex);
		 
		 System.out.println("Global List");
		 System.out.println(globalList);
		 
		
	}
	private void printAllPath(int src, int dest, LinkedList<Integer>[] graph, ArrayList<Integer> partialList,
			List<List<Integer>> globalList, Set<Integer> vistedVertex) {
		 
		 
				 
				for(int neighbourEdge: graph[src]) {
					if(vistedVertex.contains(neighbourEdge)) {
						continue;
					}
					vistedVertex.add(neighbourEdge);
					if( dest==neighbourEdge) {
						partialList.add(neighbourEdge);
						globalList.add(partialList);
						partialList.remove(partialList.size()-1);
						continue;
					}
					partialList.add(neighbourEdge);
					printAllPath(neighbourEdge,dest,graph,partialList,globalList,vistedVertex);
				}
				partialList.remove(partialList.size()-1);
		
	}
	
	
}

public class GraphTraversal {
	
	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.initializeGraph();
/*		g.createEdge(g.adjList, 0, 1);
	    g.createEdge(g.adjList, 0, 2);
	    g.createEdge(g.adjList, 1, 2);
	    g.createEdge(g.adjList, 2, 0);
	    g.createEdge(g.adjList, 2, 3);
	    g.createEdge(g.adjList, 3, null);*/
		
		g.createEdge(g.adjList, 0, 1);
		g.createEdge(g.adjList, 0, 2);
		g.createEdge(g.adjList, 1, 3);
		g.createEdge(g.adjList, 2, 0);
		g.createEdge(g.adjList, 2, 4);
		g.createEdge(g.adjList, 4, 3);
		g.createEdge(g.adjList, 3, null);
	    
	    
	//    g.bfstraversal(g.adjList, 0);
	    g.printAllPath(0, 3, g.adjList);
		
	}
	
	
	
   

}
