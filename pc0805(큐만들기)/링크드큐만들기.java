package solution;

public class LinkedQueue {
	private Node front, rear; 
	private int size; 
	public void enQueue(int d)
	{
		Node newNode = new Node(d, null); 
		if( isEmpty())
		{
			front = rear = newNode; 
		}
		else 
		{
			rear.next= newNode; 
			rear= newNode;
		}
		size++;
	}
	public int deQueue()
	{
		if(isEmpty())
		{
			return  -1; 
		}
		else
		{ 
			size--; 
			int d = front.Data; 
			front = front.next; 
			return d; 
		}
		
	}	
	public boolean isEmpty()
	{
		if( size == 0)
		{
			return true; 
		}
		return false; 
	}
	public int size()
	{
		return size; 
	}
	class Node
	{
		int Data; 
		Node next; 
		Node( int Data, Node next)
		{
			this.Data= Data; 
			this.next = next; 
		}
	}
}
