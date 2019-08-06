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
		// ť�� ��ȿ���� ����� . ( ������ ��ĭ�� ��ܾ��ϴ� ������ ) 
		// �̸� ���ؼ� ���� ť�� ������ �ȴ�. 
		
	}
}