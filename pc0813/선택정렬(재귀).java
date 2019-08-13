package Morning_0813;
public class Test_array3 {
	static int N, M, R;
	static int[]array = {1324,321,4,23234,5,654,787,32 };
	public static void main(String[] args) {
		selectionSort(0);
		for(int i =0 ; i<array.length;i++)
		{
			System.out.print( array[i] + " ") ;			
		}
	}
	static void selectionSort(int startIdx)
	{
		if(startIdx >= array.length-1)
		{
			return; 
		}
		int minIdx = startIdx; 
		for(int j = startIdx +1 ; j < array.length; j++)
		{
			if( array[j] <array[minIdx])
			{
				minIdx = j; 
				// break 넣으면 절대 안되는구나. 
				// 이유는 ? 
				// minIdx = j를 넣으니까, j값이 계속 바뀌기 때문이다. 
			}
		}
		int tmp = array[startIdx];
		array[startIdx] = array[minIdx];
		array[minIdx]=  tmp; 
		
		selectionSort(startIdx+1);
	}
	
}
