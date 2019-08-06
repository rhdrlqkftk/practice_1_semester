package solution;

public class Test1 {
	static class MyQueue
	{
		private int[]  data = new int[100];
		private int front = -1, rear =-1; 
		void enQueue(int d)
		{ 
			data[++rear] = d; 
		}
		int deQueue()
		{	
			return data[++front];
		}
		boolean isEmpty()
		{
			if( rear ==  front ) {return true;}
			else return false;
		}
		boolean isFull()
		{
			if(rear == data.length-1)
			{
				return true;
			}
			else 
				return false; 
		}
		int peek()
		{
			return data[front];
		}

	}
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		while(!queue.isEmpty())
		{
			System.out.println(queue.deQueue());		
		}	
		// 큐의 비효율이 생긴다 . ( 앞으로 한칸씩 당겨야하는 문제점 ) 
		// 이를 통해서 원형 큐가 나오게 된다. 
		
	}
}