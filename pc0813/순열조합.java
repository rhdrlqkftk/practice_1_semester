package Morning_0813;
public class Test_array3 {
	static char []arr = {'a','b','c','d','e' };
	static  boolean[] used  = new boolean[arr.length];
	public static void main(String[] args) {
		comb( 2, 0, 0); 
		// 뽑아야하는 갯수, 뽑을지 말지 결정할 인텍스, 뽑은 갯수, 재귀가 사용한다 만다를 기록해서 전달하면 마지막에 사용. 
	}
	static void comb (int r, int target, int cnt)
	{
		if( cnt == r)
		{
			print();
			return;
		}
		else if(target >= arr.length)
		{
			return;
		}
		used[target] =true;  
		comb(r, target+1, cnt+1);
		used[target] =false;  
		comb(r, target+1, cnt);
	}
	static void print()
	{
		for (int i = 0; i < arr.length; i++) {
			if( used[i] ==true)
			{
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
	
}
