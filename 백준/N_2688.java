//백준 2688번 줄어들지 않아
//브루트 포스 -> 시간초과
//dp 이용!

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2688 {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	static void go(int index, int n) {
		if(index > n) {
			count++;
			return;
		}
		
		int start = 0;
		if(sb.length() != 0)
			start = sb.charAt(sb.length()-1) - 48;
		
		for(int i=start;i<=9;i++) {
			sb.append(i);
			go(index+1, n);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void main(String [] args) {
		//미리 계산
		long [][] d = new long[65][10];   //d[i][j] : i자릿수인데 맨 끝이 j로 끝나는 경우의 수
		for(int i=0;i<10;i++)
			d[1][i] = 1;
		
		for(int i=2;i<=64;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					d[i][j] += d[i-1][k];
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for(int t=0;t<T;t++) {
				int n = Integer.parseInt(br.readLine());  //자릿수
				
				//go(1, n);
				long sum = 0;
				for(int i=0;i<10;i++)
					sum += d[n][i];
				
				System.out.println(sum);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
