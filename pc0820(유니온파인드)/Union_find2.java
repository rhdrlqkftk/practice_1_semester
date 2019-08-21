package Class;

import java.util.Scanner;

public class Union_find2 
{
	static int N, M; 
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		int []arr = new int[N+1];
		
		for(int i=0; i < N+1; i++)
		{
			arr[i] = i; // 자기 자신을 대입한다. 
		}
		for(int i =0; i <M;i++)
		{
			int chk, a,b;  
			chk = sc.nextInt(); 
			a = sc.nextInt();
			b = sc. nextInt();
			if( chk == 0)
			{
				union(arr, a,b); // 합친다라는 의미. 
			}
			else if( chk == 1)
			{
				//3 4
				int Pa = find(arr, a);
				int Pb = find(arr, b);
				if( Pa == Pb)
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
	}
	static int find(int arr[], int x)
	{
		if( arr[x] ==x )
		{
			return x; 
		}
		else
		{
			int parent = find( arr, arr[x]);
			arr[x] = parent;
			return parent;
		}		
	}
	static void union( int arr[], int a, int b)
	{
		int p1 = find (arr, a);
		int p2 = find (arr, b);
		
		if( p1 != p2)
		{
			arr[p2] =p1;	
		}
	}
}

//[입력 값] 없음. 


//[출력 값] 
/*
전]
1의 대표: 1
2의 대표: 2
3의 대표: 3
후]
1의 대표: 1
2의 대표: 1
3의 대표: 1
*/

