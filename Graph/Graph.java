package Graph;

import java.util.*;
public class Graph
{
   // Number vertices
   private int vertex;
   // Adjacency matrix
   private int [][] adj;
  
   public Graph(int n)
    {
       vertex = n;
       adj = new int[vertex][vertex];
       Random rand = new Random();
       for(int i=0; i<vertex; i++)
       {
           // No self loop
           adj[i][i] = 0;
           for(int j=i+1; j<vertex; j++)
           {
               // Choosing the probability of having as edge between vertex i and j as 0.25
               // If you want to increase prob. decrease the value in rand.nextInt( )
               int temp = rand.nextInt(4);
               // temp can have 0, 1, 2 and 3. If temp is 0, then there is edge between vertex i and j
               if(temp == 0)
                   adj[j][i] = adj[i][j] = rand.nextInt( 5*vertex ) + 1;
               else
                   adj[i][j] = adj[j][i] = 0;
                  
               // adj[i][j] is same as adj[j][i] since the graph is undirected
           }
       }
    }

   // Printing function
   public void printGraph()
   {
       System.out.print("\n\nNode list:{");
       for(int i=0; i<vertex; i++)
           System.out.print((i+1)+", ");
       System.out.println("\b\b}");
      
       System.out.print("\n\nEdge list:{");
       for(int i=0; i<vertex; i++)
           for(int j=i+1; j<vertex; j++)
               if( adj[i][j] != 0 )
                   System.out.print("("+(i+1)+","+(j+1)+","+adj[i][j]+"), ");
       System.out.println("\b\b}");
   }
  
   // Finding minimun in a arraylist
private int findMinDist(ArrayList<Integer> d)
{
   int m, index;
   m = Integer.MAX_VALUE;
   index = -1;
   for(int i=0; i<d.size(); i++)
       if( d.get(i) < m )
       {
           m = d.get(i);
           index = i;
       }
   return index;
}

   // Function that implements Dijkstra's single source widest path
// algorithm for a graph represented using adjacency matrix
// representation            
   public void dijkstra(int source, int destination)
   {
       // To keep track of widest distance
       int []dist = new int[vertex];
      
       // To get the path at the end of the algorithm
       int []parent = new int[vertex];
      
       for(int i=0; i<vertex; i++)
       {
           dist[i] = Integer.MIN_VALUE;
       }
       dist[source] = Integer.MAX_VALUE;
       parent[source] = -1;
      
       // Use of arraylist to maintain Minimum Priority Queue to keep track minimum widest distance vertex so far
       // c for distance, v for the vertex
       ArrayList<Integer> v = new ArrayList<Integer>();
       ArrayList<Integer> c = new ArrayList<Integer>();
      
       // Adding the initial vertex and distance 0
       v.add(source);
       c.add(0);
       while( v.size() != 0 )
       {
           int index = findMinDist(c);
           int tv, tc;
           // tv is the chosen vertex and tc is the smallest value in c arraylist
           tv = v.get(index);
           tc = c.get(index);
           v.remove(index);
           c.remove(index);

           for(int j=0; j<vertex; j++)
           {
               // Finding the widest distance to the vertex using current_source vertex's widest distance
       // and its widest distance so far           
               if( adj[tv][j] != 0 )
               {
                   int d = Math.max(dist[j], Math.min( dist[tv], adj[tv][j]) );
                   // Relaxation of edge and adding into Priority Queue
                   if( d > dist[j] )
                   {
                       // Updating bottle-neck distance                  
                       dist[j] = d;
                      
                       // To keep track of parent
                       parent[j] = tv;
                      
                       // Adding the relaxed edge in the prority queue
                       c.add(d);
                       v.add(j);
                   }
               }
           }
       }
      
       if(dist[destination] == Integer.MIN_VALUE)
       {
           System.out.println("No path exist");
           return;
       }
      
       // Calculating the path
       int []path = new int[vertex];
       int temp;
       temp = destination;
       int n = 0;
       while( parent[temp] != -1 )
       {
           path[n++] = temp;
           temp = parent[temp];
       }
       path[n++] = source;

       // Printing path
       System.out.print("Path: ");
       for(int i=n-1; i>=0; i--)
           System.out.print((path[i]+1)+"-");
       System.out.println("\b \n\nBottleneck "+dist[destination]);
   }
   
    // Driver Function
    public static void main(String args[])
    {

        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Enter the value of n:");
        // n stores number edges
        n = in.nextInt();
        Graph ob = new Graph(n);
       int s,d;
       // Printing the graph
       ob.printGraph();
      
       //s for source and d for destination
       System.out.println("Enter source and destination:");
       s = in.nextInt();
       d = in.nextInt();
      
       // calling dijkstra function to find widest path from s to d
       ob.dijkstra(s-1, d-1);
    }
}