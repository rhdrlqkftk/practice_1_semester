package Solution;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
// 다익스트라 ( 클래스 정렬, priority큐 )
public class Test1 {
	static int N, E; 
	static int [][] graph; 
	static int [] distance;
	static boolean[] visit; 
	static PriorityQueue<Edge> pq; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		E = sc.nextInt();
		graph = new int [N+1][E+1];
		distance =  new int[N+1];
		visit = new boolean[N+1];
		pq = new PriorityQueue<Edge>();
		for(int e =0 ; e<E; e++)
		{
			graph[sc.nextInt()][sc.nextInt()] = sc.nextInt(); 
		}
		dijkstra(1); 
		System.err.println(Arrays.toString(distance));
	} 
	
	static void dijkstra( int start)
	{
		//1.  전체 정점까지의 거리는 무한대로 설정
		//2.  시작 정점을 pq에 넣고 반복문 진입
		//3.  반복문에서 가장 짧은 간선을 빼서 ( 처음엔 시작정점에서 시작정점으로 가느 거리 0짜리 나옴 ) . 
		//    해당 간선의 정점 방문처리, 이때 방문처리란 모든 정점까지 갈 떄 지금 선택한 정점을 찍고 가는게 빠른지 
		//    안찍고 가는게 빠른지 확인. 
		//4.  3번에서 선택한 정점에서 나가는 간선들도 추가로 pq에 넣기. 
		/// start
		// #1
		for( int i=1; i<= N; i++)
		{
			distance[i] = Integer.MAX_VALUE;
		}
		// #2. 
		distance[start] =0; 
		pq.add(new Edge(start, start, 0));
		while(!pq.isEmpty())
		{
			// distance는 전에 들어온 값인거 같다. 
			Edge min = pq.poll(); // 확보된 간선 중에서 가장 길이가 짧은 간선을 뽑는다.  
			visit[min.end] =true;  // 해당 간선 끝에 있는 정점을 방문 처리하고 
			for(int i =1; i<=N; i++)
			{
				if(graph[min.end][i] > 0 && distance[i] > distance[min.end]+ graph[min.end][i])
				{
					 distance[i] = distance[min.end]+ graph[min.end][i];
					 pq.add( new Edge(min.end, i, graph[min.end][i]));
				}
			}
		}
	
		
	}
	static class Edge implements Comparable<Edge>
	{
		int start, end, value; // 시작, 끝, 값. 
		Edge( int s, int e, int v)
		{
			start = s; 
			end = e;
			value = v; 
		}
		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
		
	}
	// 두가지 방법, comparable, comparator 두가지 방법이 있다. 
	/*
	 * */
}
