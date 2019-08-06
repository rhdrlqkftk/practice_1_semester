package solution;

import solution.Test1.MyQueue;
//큐의 비효율이 생긴다 . ( 앞으로 한칸씩 당겨야하는 문제점 ) 
// 이를 통해서 원형 큐가 나오게 된다.
// 한칸을 비워야한다.  
// why? 만난걸 비어있다 표현 해야하는데, 꽉차게 되어도 만나는데 이거도 비어있다고 판단한다./ 
// so rear와 front가 1개 차이가 나면 꽉 찼다고 판단한다. 
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
				throw new Exception("큐꽉참");			
			}
			rear++; 
			rear = rear% mod;
			data[rear] = d; 
		}
		int deQueue() throws Exception
		{	
			if( isEmpty())
			{
				throw new Exception("나올 거 없음");
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
