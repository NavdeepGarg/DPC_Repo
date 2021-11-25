package pepcodingGraph;
//correct
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class GeneralGraph {
	
	
	static class Edge{
		
		int src;
		int dest;
		int weight;
		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		
	}
	public static void hamiltonianPathAndCycle(ArrayList<Edge> graph[],List<List<Integer>> pathList, List<Integer> localList,boolean[] visited,int src) {
		
		
		if(visited[src]) {
			return;
		}
		visited[src]=true;
		localList.add(src);
		if(localList.size()==graph.length) {
			// all vertex covered
			List<Integer> tempList = new ArrayList<>();
			tempList.addAll(localList);
			pathList.add(tempList);
			localList.remove(localList.size()-1);
			visited[src]=false;
			
			return;
		}
	 for(Edge edge: graph[src]) {
		 if(!visited[edge.dest]) {
			hamiltonianPathAndCycle(graph, pathList, localList, visited, edge.dest); 
		 }
		 
	 }
		
	 visited[src]=false;
	 return;
	}
	 
	public static void friendsPair(ArrayList<Edge> graph[],List<List<Integer>> globalList, List<Integer> localList,boolean[] visited) {
		
		getConnectedComponent(globalList, localList, visited, graph);
		int count=0;
		for(int i =1; i < globalList.size();i++) {
			
			List<Integer> l1 = globalList.get(i-1);
			List<Integer> l2 = globalList.get(i);
			
			count+=l1.size()*l2.size();
		}
		count+=globalList.get(0).size()*globalList.get(globalList.size()-1).size();
		System.out.println(count);
	}

	public static void getConnectedComponent(List<List<Integer>> globalList, List<Integer> localList,boolean[] visited,ArrayList<Edge> graph[]) {
		
		for (int i =0 ;i<graph.length;i++) {
			
			if(!visited[i]) {
			localList= new ArrayList<>();
			traverseDFSStyle(i,localList,graph,visited);
			globalList.add(localList);
			}
		}
		
		
	}
	
	private static void traverseDFSStyle(int src, List<Integer> localList, ArrayList<Edge>[] graph, boolean[] visited) {
		 
		List<Edge> edgeList = graph[src];
		visited[src]=true;
		localList.add(src);
		for(Edge e: edgeList) {
			
			if(!visited[e.dest]) {
				traverseDFSStyle(e.dest,localList,graph,visited);
			}
			
		}
		
		return;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("enter no of vertices");
		 int V= Integer.parseInt(br.readLine());
		ArrayList<Edge> graph[]= new ArrayList[V];
		for(int i =0 ; i < graph.length;i++) {
			graph[i] = new ArrayList<Edge>();
		}
		System.out.println("enter no of edges");
		 int E= Integer.parseInt(br.readLine());
		 for(int i =0 ; i < E;i++) {
			 System.out.println("enter edge details, src-dest-weight");
			 String parts[]= br.readLine().split(" ");
			 int src=Integer.parseInt(parts[0]);
			 int dest=Integer.parseInt(parts[1]);
			 int weight=Integer.parseInt(parts[2]);
			 graph[src].add(new Edge(src,dest,weight));
			 graph[dest].add(new Edge(dest,src,weight));
			 
		 }
		
		 List<List<Integer>> globalList = new ArrayList<>();
		 List<Integer> localList = new ArrayList<>();
		 boolean visited[]=new boolean[V];
		 
		 //getConnectedComponent(globalList, localList, visited, graph);
		// friendsPair(graph,globalList, localList, visited);
		 hamiltonianPathAndCycle(graph, globalList, localList, visited, 0);
		 
		 System.out.println(globalList);
		 
	}

}
