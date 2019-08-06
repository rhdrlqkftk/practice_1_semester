package solution;

import solution.Test1.MyQueue;
//ť�� ��ȿ���� ����� . ( ������ ��ĭ�� ��ܾ��ϴ� ������ ) 
// �̸� ���ؼ� ���� ť�� ������ �ȴ�.
// ��ĭ�� ������Ѵ�.  
// why? ������ ����ִ� ǥ�� �ؾ��ϴµ�, ������ �Ǿ �����µ� �̰ŵ� ����ִٰ� �Ǵ��Ѵ�./ 
// so rear�� front�� 1�� ���̰� ���� �� á�ٰ� �Ǵ��Ѵ�. 
public class Test2 {
	static class MyQueue
	{
		private int[]  data = new int[100];
		int mod = data.length;
		private int front = -1, rear =-1; 
		boolean isEmpty()
		{
			if( rear ==  front ) {return true;}
			else return false;
		}
		void enQueue(int d) throws Exception
		{ 
			if( isFull())
			{	
				throw new Exception("ť����");			
			}
			rear++; 
			rear = rear% mod;
			data[rear] = d; 
		}
		int deQueue() throws Exception
		{	
			if( isEmpty())
			{
				throw new Exception("���� �� ����");
			}
			front = (front +1) % mod;
			return data[++front];
		}
		
		boolean isFull()
		{
			if((rear+1)%mod == front)
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
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		while(!queue.isEmpty())
		{
			System.out.println(queue.deQueue());		
		}	
		
		
	}
}
