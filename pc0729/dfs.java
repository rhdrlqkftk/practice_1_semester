package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Test6 {

	static boolean visited[] ;
	static boolean link[][] ;
	static int N,E;
	static void dfs( int now)
	{
		if( !visited[now])
		{
			System.out.println(now+" ");
			visited[now]= true;
		}
		for (int i = 1; i <= N; i++) 
		{
			if(link[now][i] && !visited[i])
			{
				dfs(i);
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		E = sc.nextInt();
		visited = new boolean[N+1];
		link = new boolean[N+1][N+1];
		for (int i = 0; i < N; i++) 
		{
			int n1 = sc.nextInt(); 
			int n2 = sc.nextInt();
			link[n1][n2] = true;
			link[n2][n1] = true;	
		}
		
		dfs(1);
	}
}