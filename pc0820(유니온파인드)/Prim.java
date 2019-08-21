package Class;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 *1. 정점 중에서 시작 정점 고르기 
 *2. 고른 정점에 연결된 간선들 중에서 최소비용 간선 고르기 - 우선순위 큐(Heap) 사용해보자. 
 *   => 간선을 고르면 그 끝에 매달린 정점도 선택 받은 애가 됨.  
 *3. 선택한 모든 정점들에 (새로 선택 받은 애 포함) 연결된 모든 간선들( 큐에 넣어서 ) 중 최소비용 간선을 찾아서 선택 
 *4. 모든 정점이 다 선택될 때까지 2,3을 반복. 
 * */
public class Prim {
	static int N , E; 
	static LinkedList<Edge>[] graph; // 인접 연결 리스트 
	static boolean[] visit;  
	static ArrayList<Edge> mst;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  
		E = sc.nextInt();  
		graph = new LinkedList[N+1]; // 링크드 리스트 객체 배열이다.// 이렇게 써줘야만 쓸수 있다. 
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
		
		// 시작 정점 임의로 선택하기.  
		q.add(1);
		while(!q.isEmpty())
		{
			int now = q.poll(); 
			visit[now] = true;
			LinkedList<Edge> nowEdges = graph[now];
			for(Edge e : nowEdges)
			{
				// now에 연결된 모든 간선을 pq에 넣긴 할껀데, 
				// 해당 간선을 따라 갔을 때 가게 되는 정점이 아직 미방문인 엣지들에만 관심있음. 
				if( !visit[e.end])
				{
					pq.add(e);
				}
			}
			while(!pq.isEmpty()) // 모아둔 간선을 하나씩 꺼내서 선택해야한다. 
			{
				Edge edge = pq.poll();  // 간선중 제일 짧은 애 선택.
				if (!visit[edge.end])
				{
					visit[edge.end] = true; // 이제 간선 선택 한거니까.   
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
			return o1.value - o2.value; //가중치로 비교하겠다. 
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