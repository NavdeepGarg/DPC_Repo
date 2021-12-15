package decemberCircuit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;

class TreeNode{
	
	
	int index;
	int value;
	public TreeNode(int index,int value) {
		super(); 
		this.index = index;
		this.value = value;
	}
	
	
}



public class SmallestPathProb {
	
	ArrayList<Integer>[] graph ;
	
	public void initializeGraph( int[] arr) {
		graph = new ArrayList[arr.length+1];
		for(int i =0 ; i <= arr.length;i++) {
			 
			graph[i]= new ArrayList<>();
			
		} 	 
	}
	
	public int findKthSmallestNode(int src, int dest, int k, int[] arr) {
		
		ArrayList<Integer> path= new ArrayList<>();
		ArrayList<Integer> output= new ArrayList<>();
		//PriorityQueue<Integer> path2= new PriorityQueue<>();
		boolean[] visited= new boolean[graph.length];
			dfs(graph,visited,src,dest,path,output);
			System.out.println(output);
			if(output.size()<k) {
				return -1;
			}
			else {
				
				for(int i =0 ; i < output.size();i++) {
					
					int x = arr[output.get(i)];
					output.set(i, x);
				}
				
				Collections.sort(output);
				System.out.println(output);
				System.out.println("k"+output.get(k-1));
				
				return output.get(k-1);
			}
		
	}

	private void dfs(ArrayList<Integer>[] graph, boolean[] visited, int src, int dest, ArrayList<Integer> path,ArrayList<Integer> output) {
		
			 
			visited[src]=true;
			path.add(src); 
			if(src==dest) {
				output.addAll(path);
				return ;
			}
			if(graph[src].size()==0) {
				return;
			}
			 
			for(int nbr : graph[src]) { 
				 if(!visited[nbr]) {
				 
					 dfs(graph,visited,nbr,dest,path,output);
				 }
				
			}
			 
			path.remove(path.size()-1);
			 
			return;
	}
	
	public static void main(String[] args) throws IOException {
			
		SmallestPathProb obj = new SmallestPathProb();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String file ="src/decemberCircuit/input.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
        String name = br.readLine();
 		String[] splitarray= name.split(" ");
 	int V = Integer.parseInt(splitarray[0]);		
 	int K = Integer.parseInt(splitarray[1]);
		/*
		int V=br.re();
		int K=br.read();*/
 	 	name = br.readLine();
 	 	splitarray= name.split(" ");
		int[] arr = new int[V+1];
		int j =0;
		arr[0]=0;
		j=1;
		for(String temp : splitarray) {
			
			arr[j++]=Integer.parseInt(temp);
		
		}
		obj.initializeGraph(arr);
		int  u =0 , v=0;
		  
		for(int i =0 ; i < V-1; i++) {
			name = br.readLine();
	 	 	splitarray= name.split(" ");
			u = Integer.parseInt(splitarray[0]);
			v=Integer.parseInt(splitarray[1]);
			
			/*uNode= new TreeNode(u-1, arr[u-1]);
			vNode= new TreeNode(v-1, arr[v-1]);*/
			obj.graph[u].add(v);
			obj.graph[v].add(u);
		}
		
		System.out.println(obj.findKthSmallestNode(8, 7, 5,arr));
		
	}
	

}
