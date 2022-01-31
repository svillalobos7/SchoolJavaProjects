//Node for SLL
public class Node
{
	//Data
	Object data;
		
	//Link
	Node next;
		
	//Constructor
	public Node(Object data)
	{
		this.data = data; 		
		this.next = null; 		
	}
		
	//Creates a node and points it to another node
	public Node(Object data, Node next)
	{
		this.data = data; 		
		this.next = next; 
	}
		
}
