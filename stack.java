package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Test5 {

	
	static void dfs( int n)
	{
		
//		if (visited[n] == false) {
//			visited[n] = true;
//			for (int i = 1; i <= N; i++) {
//				if (n == i)
//					continue;
//				if (link[n][i] == true) {
//					dfs(i);
//				}
//			}
//		}
	}
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); 
		boolean visited[] = new boolean[N+1];
		boolean link[][] = new boolean[N+1][N+1];
		
		MyStack st = new MyStack();
		for (int i = 0; i < N; i++) 
		{
			int n1 = sc.nextInt(); 
			int n2 = sc.nextInt();
			link[n1][n2] = true;
			link[n2][n1] = true;	
		}
		int now =1 ; 
		Stack< Integer> stack = new Stack<>();
		while(true)
		{
			// 정점에 대한 방문 처리 
			if( visited[now] == false ) 
			{
				System.out.println(now+ " ");
				visited[now] =true;
			}
			// 현재 방문 정점과 연결된 인접 정보 탐색. 
			boolean isGo = false; // now에서 인접하고 가본적은 없는 정점을 찾으면  true로 바꿔야함. 
			for (int i = 1; i <=N; i++) 
			{
				if( link[now][i]==true && visited[i] ==false)
				{
					stack.push(now);
					isGo = true; 
					now = i;  
					break; 
				}
			}	
			// 앞으로 갈지 뒤로 갈지. 
			if( stack.isEmpty() && isGo == false) //확실한 종료.
			{
				break;
			}
			else if( isGo == false) 
			{
				now = stack.pop() ;
			}			// 
		}
		
	}
	
	
/*
 7
 1 2
 1 3
 2 4
 2 5
 4 6
 5 6
 6 7
 3 7
 * 
*/
}
