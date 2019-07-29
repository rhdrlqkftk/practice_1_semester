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
			// ������ ���� �湮 ó�� 
			if( visited[now] == false ) 
			{
				System.out.println(now+ " ");
				visited[now] =true;
			}
			// ���� �湮 ������ ����� ���� ���� Ž��. 
			boolean isGo = false; // now���� �����ϰ� �������� ���� ������ ã����  true�� �ٲ����. 
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
			// ������ ���� �ڷ� ����. 
			if( stack.isEmpty() && isGo == false) //Ȯ���� ����.
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
