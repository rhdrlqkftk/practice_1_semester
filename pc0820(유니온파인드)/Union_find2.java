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
			arr[i] = i; // �ڱ� �ڽ��� �����Ѵ�. 
		}
		for(int i =0; i <M;i++)
		{
			int chk, a,b;  
			chk = sc.nextInt(); 
			a = sc.nextInt();
			b = sc. nextInt();
			if( chk == 0)
			{
				union(arr, a,b); // ��ģ�ٶ�� �ǹ�. 
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

//[�Է� ��] ����. 


//[��� ��] 
/*
��]
1�� ��ǥ: 1
2�� ��ǥ: 2
3�� ��ǥ: 3
��]
1�� ��ǥ: 1
2�� ��ǥ: 1
3�� ��ǥ: 1
*/

