package Class;

public class Union_find 
{
	public static void main(String[] args) 
	{
		int []arr = new int[10];
		
		for(int i=0; i < arr.length; i++)
		{
			arr[i] = i; // 자기 자신을 대입한다. 
		}
		
		System.out.println("1의 대표: " + find(arr, 1));
		System.out.println("2의 대표: " + find(arr, 2));
		System.out.println("3의 대표: " + find(arr, 3));
		
		union(arr, 1,2);
		union(arr, 2,3);
		
		System.out.println("1의 대표: " + find(arr, 1));
		System.out.println("2의 대표: " + find(arr, 2));
		System.out.println("3의 대표: " + find(arr, 3));
		
		
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

