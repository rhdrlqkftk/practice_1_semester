package solution;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test3 {

	public static void main(String[] args) {
//		#1 �Ϲ� ť. 
//		Queue<Integer> queue = new LinkedList<>();
//		#2 �켱���� ť. 		
//		PriorityQueue< Integer> queue = new PriorityQueue<>();
//		#3 ��������, ��������. 
	
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() 
		{
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		// ť�θ� �����ϰ� ���ڴ�. 
		queue.add(10);
		queue.add(100);
		queue.add(150);
		queue.add(10);
		queue.add(10);
		while(!queue.isEmpty())
		{
			System.out.println(queue.poll());
		}
	}

}
