package solution;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test3 {

	public static void main(String[] args) {
//		#1 일반 큐. 
//		Queue<Integer> queue = new LinkedList<>();
//		#2 우선순위 큐. 		
//		PriorityQueue< Integer> queue = new PriorityQueue<>();
//		#3 오름차순, 내림차순. 
	
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() 
		{
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		// 큐로만 동작하게 쓰겠다. 
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
