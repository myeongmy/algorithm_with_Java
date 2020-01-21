//백준 1748번
/*문제
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1≤N≤100,000,000)이 주어진다.

출력
첫째 줄에 새로운 수의 자릿수를 출력한다.*/

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			/* 메모리 초과
			 * long N = Long.parseLong(br.readLine()); 
			 * long length = 0; 
			 * for (long i = 1; i<= N; i++) { 
			 * length += Long.toString(i); 
			 * } 
			 * System.out.println(length);
			 */
			long N = Long.parseLong(br.readLine());
			long start = 1; long end = 9;
			int cnt = 1;
			long length = 0;
			while(end < N) {
				length += (end - start+1)*cnt;
				start *= 10;
				end = start*10 -1;
				cnt ++;
			}
			length += (N-start+1)*cnt;
			System.out.println(length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
