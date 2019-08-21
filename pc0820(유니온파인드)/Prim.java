package Class;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 *1. ���� �߿��� ���� ���� ���� 
 *2. �� ������ ����� ������ �߿��� �ּҺ�� ���� ���� - �켱���� ť(Heap) ����غ���. 
 *   => ������ ���� �� ���� �Ŵ޸� ������ ���� ���� �ְ� ��.  
 *3. ������ ��� �����鿡 (���� ���� ���� �� ����) ����� ��� ������( ť�� �־ ) �� �ּҺ�� ������ ã�Ƽ� ���� 
 *4. ��� ������ �� ���õ� ������ 2,3�� �ݺ�. 
 * */
public class Prim {
	static int N , E; 
	static LinkedList<Edge>[] graph; // ���� ���� ����Ʈ 
	static boolean[] visit;  
	static ArrayList<Edge> mst;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  
		E = sc.nextInt();  
		graph = new LinkedList[N+1]; // ��ũ�� ����Ʈ ��ü �迭�̴�.// �̷��� ����߸� ���� �ִ�. 
		visit = new boolean[N+1];
		for(int i = 1; i<=N; i++)
		{
			graph[i] = new LinkedList<>();
		}
		for(int e =0; e<E; e++)
		{
			int v1 = sc.nextInt();  
			int v2 = sc.nextInt(); 
			int value = sc.nextInt(); 
			graph[v1].add(new Edge(v1, v2, value));
			graph[v2].add(new Edge(v2, v1, value));
		}
		makeMST();  
		System.out.println(mst);
	}
	
	static void makeMST()
	{
		mst = new ArrayList<>(); 
		PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
		Queue<Integer> q = new LinkedList<>();
		
		// ���� ���� ���Ƿ� �����ϱ�.  
		q.add(1);
		while(!q.isEmpty())
		{
			int now = q.poll(); 
			visit[now] = true;
			LinkedList<Edge> nowEdges = graph[now];
			for(Edge e : nowEdges)
			{
				// now�� ����� ��� ������ pq�� �ֱ� �Ҳ���, 
				// �ش� ������ ���� ���� �� ���� �Ǵ� ������ ���� �̹湮�� �����鿡�� ��������. 
				if( !visit[e.end])
				{
					pq.add(e);
				}
			}
			while(!pq.isEmpty()) // ��Ƶ� ������ �ϳ��� ������ �����ؾ��Ѵ�. 
			{
				Edge edge = pq.poll();  // ������ ���� ª�� �� ����.
				if (!visit[edge.end])
				{
					visit[edge.end] = true; // ���� ���� ���� �ѰŴϱ�.   
					q.add(edge.end);
					mst.add(edge);
				}
			}
			
			
		}
		
	}
	@Override
	public String toString() {
		return "Prim []";
	}
	static class Edge
	{
		
		int start, end, value;  
		Edge(int s, int e, int v)
		{
			start = s; end =e ; value =v; 
		}
		@Override
		public String toString() 
		{
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
	}
	static class EdgeComparator implements Comparator<Edge>
	{
		@Override
		public int compare(Edge o1, Edge o2) 
		{
			return o1.value - o2.value; //����ġ�� ���ϰڴ�. 
		}
	}
}
/*
7
11 
1 2 2
2 3 5
1 3 20
1 4 10
4 5 1
5 6 23 
3 6 3 
3 5 6
7 6 9
7 3 2
2 7 7

*/