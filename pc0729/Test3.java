package Algorithm;

import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MyStack st = new MyStack();  
		String line = sc.next();
		
		boolean ans = true;  
		for (int i = 0; i < line.length(); i++) 
		{
			if(line.charAt(i)== '(')
			{
				st.push(line.charAt(i));
			}
			else if( line.charAt(i) == ')')
			{
				if( st.isEmpty() )
				{
					ans = false;  
				}
				else
				{
					st.pop();
				}
				
			}
		}
		if(st.size() !=0 )ans = false; 
		
		System.out.println(ans);
	}

}
