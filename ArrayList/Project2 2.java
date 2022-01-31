package Project2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Project2
{
	static Scanner user = new Scanner(System.in);
	static int node;
	static int [][] edge;

	public static void main(String [] args)
	{	int s = 0;
		int d = 0;
		NodeList();	
		EdgeList();	
		Dijkstra(s,d);
	}   
        
	//Printing node function
	public static void NodeList()
	{	
		while(true)
		{
			int neg = -999;
			System.out.println("Enter a positive integer: ");
			node = user.nextInt();
			
			if(node > 0 && node!= 0 && node!= neg)
			{   
				System.out.print("\nNode List: {");
				
				for(int i = 0; i < node;i++)
				{
					System.out.print((i+1)+ ",");
				}
				System.out.println("}");
				break;
			}
			else
			{
				System.out.println("\n ---------------Try again!----------------- \n");	
			}
		}		
	}
	
	//Printing Edge function
	public static void EdgeList()
	{		
		edge = new int [node][node];
		Random rand = new Random();
		System.out.print("Edge List: {");
		
		for(int i = 0; i < node; i++)
		{
			edge[i][i] = 0; // no self loop
			
			for(int j=i+1; j < node; j++)
			{
				int n = rand.nextInt(4); 
				
				if(n == 0)
				{
					edge[j][i] = edge[i][j] = rand.nextInt(node * 5)+ 1;
				}
				else
				{
					edge[i][j] = edge[j][i] = 0;
				}
				if(edge[i][j] != 0)
				{
					System.out.print("(" + (i+1) + "," + (j+1) + "," + edge[i][j] + "),");
				}
			}
		}
		System.out.println("}");
	}
	
	public static int MinimumDistance(ArrayList<Integer> data)
	{
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i < data.size(); i++)
		{
			if(data.get(i) < min)
			{
				min = data.get(i);
				index = i;
			}
		}
		return index;
	}
	
	
	public static void Dijkstra(int source, int destination)
	{ 
		//printing source and destination
		System.out.println("\nEnter source node: ");
		node = user.nextInt();
				
		System.out.println("Enter source destination: ");
		node = user.nextInt();
		
		int []widestdistance = new int[node]; // keep track of widest distance
		int []parent = new int[node]; // path at the end of the algorithm

		ArrayList<Integer> distance = new ArrayList<Integer>(); // d for distance
		ArrayList<Integer> corner = new ArrayList<Integer>(); // corner for nodes
		
		
		corner.add(source);
		distance.add(0);
		
		while(corner.size() !=0)
		{
			int index = MinimumDistance(distance);
			int c; // c = chosen node 
			int s; //s = smallest value
			c = corner.get(index);
			s = distance.get(index);
			corner.remove(index);
			distance.remove(index);
			
			for(int j = 0; j< node; j++)
			{
				if(edge[c][j] != 0) 
				{
					int d  = Math.max(widestdistance[j], Math.min(widestdistance[c],edge[c][j]));
					//Relaxation of edge & adding into Priority Queue
					if(d > widestdistance[j])
					{
						widestdistance[j] = d; //bottleneck distance
						parent[j] = c; // track of parent
						distance.add(d); // Add relaxed edge in priority queue
						corner.add(j);
					}
				}
			}
		}
		
		int [] path = new int[node];
		int temp;
		temp = destination;
		int num = 0;
		
		//calculate the path 
		while(parent[temp] != -1)
		{
			path[num++] = temp;
			temp = parent[temp];
		}
		path[num++] = source;
		System.out.println("Path: ");
		
		for(int i = num-1; i>=0; i--)
		{
			System.out.print((path[i]+1) + "-");
			System.out.println("Bottleneck: " + widestdistance[destination]);
		}
	
	}
}
