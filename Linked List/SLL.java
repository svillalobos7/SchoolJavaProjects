
/*Author: Stephanie Villalobos
 * Date: 9/16/19
 * Topic: Linked List
 * CSC 311
 * Assignment #2
 *
 * Use the code provided in the slides and implement the following functionality. You can use your main function to test the implementation functionality below. 
	
	–Add a new first element
	–Add a new last element
	–Add Before a given node (specified by a reference)
	–Add After a given node
	–Add Before a given value
	–Add After a given value
	- Print all node values from the first element
	- Print all node values from the last element
	 
 */
//Linked List Implementation
public class SLL
{
	private Node curr;		
	private int size;		
	
	
	//Constructor
	public SLL()
	{
		this.curr = new Node(null); 	
		this.size = 0; 				
	}
	
	//Add a new first element
	public void InsertAtFront(Object item)
	{
		Node first = new Node(item);	
		first.next = curr.next;			
		curr.next = first; 	
		
	}
	
	
	private Node getNode(int index)
	{
		
		if(index < 0)
		{
			if(index > size)
				
			return null;
		}
			Node iter = curr;
		
		for(int i = 0; i< index; i++) 
		{
			iter = iter.next;			
		}

		return iter;
	}	

	public void InsertAtLast()
	{
		if(size == 0)
		{
			InsertAtLast(curr.next);
		}
	}
	
	//Add a new last element
	public void InsertAtLast(Object item)
	{	
		Node last = new Node(item);
		
		if(last.next == null)
		{
			System.out.print(last.data + " | ");
			
			return;
		}
		
		else
		{
			InsertAtLast(last.next);
			System.out.print(last.data + " | ");
		}
		
		return;
	}	
	
		
	//Add Before a given node
	public void AddBeforeNode(Object item, Node target)
	{
		target = getNode(size);
		this.AddAfterNode(item,target);
	}
	
	//Add After a given node
	public void AddAfterNode(Object item, Node target)
	{
		
		Node insert = new Node(item);
		insert.next = target.next;
		target.next = insert;
		
	}
	
	//Add Before a given value
	public void AddBeforeValue(Object item, Node target)
	{
		target = getNode(size);		
		this.AddAfterNode(item,target);
	}
	
	//Add After a given value
	public void AddAfterValue(Object item, Node target)
	{
		for(Node here = this.curr; here != null; here = here.next)
		{
			if(here.data.equals(item))
			{
				target.next = here.next;
				here.next = target;
				return;
			}
		}
		
	}
	
	//Function to print Linked List
	public void PrintLinkedList()
	{
		Node temp = curr;
		while(temp.next != null)
		{
			System.out.print(temp.next.data+ " | ");
			temp = temp.next;
		}
		System.out.println();
	}
	

	//Print all node values from the first element and last element
	public static void main(String[] args)
	{
		SLL list = new SLL();
		
		list.InsertAtFront(7);
		list.InsertAtFront(6);
		list.InsertAtFront(5);
		list.InsertAtFront(4);
		list.InsertAtFront(3);
		list.InsertAtFront(2);
		list.InsertAtFront(1);			
		System.out.println("Values from the first element:");
		list.PrintLinkedList();
		
		System.out.println("Values from the last element");
		list.InsertAtLast(7);
		list.InsertAtLast(6);
		list.InsertAtLast(5);
		list.InsertAtLast(4);
		list.InsertAtLast(3);
		list.InsertAtLast(2);
		list.InsertAtLast(1);
		
		
	}
	
}