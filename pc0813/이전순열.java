//이전 순열. 
package Morning_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Test_array2 {
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = sc.nextInt();
		String str[] = br.readLine().split(" ");
		int arr[] = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int flag = 0;
		int idx_s = 0;
		int idx_e = N - 1;
		for (int i = N - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				// System.out.println(i + ":"+str[i] + "," +j + ":"+str[j]);
				if (arr[j] > arr[i]) {
					// 앞에 녀석이 나보다 크다면, 바꾼다 위치를..
					int abc = arr[j];
					arr[j] = arr[i];
					arr[i] = abc;
					flag = 1;
					idx_s = j;
					break;
				}
			}
			if (flag == 1) {
				break;
			} else {
				flag = -1;
			}
		}
		if (flag != -1) {
			for (int j = (idx_s + 1); j < N - 1; j++) {
				int tmp = arr[j];
				int idx = 0;
				int fg = 0;
				for (int k = j + 1; k < N; k++) {
					if (arr[j] < arr[k]) {
						arr[j] = arr[k];
						idx = k;
						fg = 1;
					}
				}
				if (fg == 1) {
					arr[idx] = tmp;
				}
			}
		}
		if (flag == -1) {
			System.out.println(flag);
		} else {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
