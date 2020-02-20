//백준 9019번
//BFS 문제
//시간초과와 런타임에러 났던 문제
//시간초과: L연산과 R연산을 string으로 바꿔서 구하지 말고 숫자 자리수 연산을 통해 구해야 빠르다.
//런타임에러: 배열의 인덱스 문제 (S연산)
/*문제
네 개의 명령어 D, S, L, R 을 이용하는 간단한 계산기가 있다. 이 계산기에는 레지스터가 하나 있는데, 이 레지스터에는 0 이상 10,000 미만의 십진수를 저장할 수 있다. 각 명령어는 이 레지스터에 저장된 n을 다음과 같이 변환한다. n의 네 자릿수를 d1, d2, d3, d4라고 하자(즉 n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4라고 하자)

D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다. 예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.

여러분이 작성할 프로그램은 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다. 예를 들어서 A = 1234, B = 3412 라면 다음과 같이 두 개의 명령어를 적용하면 A를 B로 변환할 수 있다.

1234 →L 2341 →L 3412
1234 →R 4123 →R 3412

따라서 여러분의 프로그램은 이 경우에 LL 이나 RR 을 출력해야 한다.

n의 자릿수로 0 이 포함된 경우에 주의해야 한다. 예를 들어서 1000 에 L 을 적용하면 0001 이 되므로 결과는 1 이 된다. 그러나 R 을 적용하면 0100 이 되므로 결과는 100 이 된다.

입력
프로그램 입력은 T 개의 테스트 케이스로 구성된다. 테스트 케이스 개수 T 는 입력의 첫 줄에 주어진다. 각 테스트 케이스로는 두 개의 정수 A와 B(A ≠ B)가 공백으로 분리되어 차례로 주어지는데 A는 레지스터의 초기 값을 나타내고 B는 최종 값을 나타낸다. A 와 B는 모두 0 이상 10,000 미만이다.

출력
A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력한다.*/

package 백준;

import java.util.*;
import java.io.*;

class DSLR {
	int n;
	String oper;

	DSLR(int n, String oper) {
		this.n = n;
		this.oper = oper;
	}
}

public class N_9019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int A = Integer.parseInt(arr[0]);
				int B = Integer.parseInt(arr[1]);
				// bfs 돌리기
				int[] c = new int[10005];
				Queue<DSLR> q = new LinkedList<DSLR>();

				c[A] = 1;
				q.offer(new DSLR(A, ""));

				while (!q.isEmpty()) {
					DSLR r = q.poll();
					if (r.n == B) {
						bw.write(r.oper);
						bw.newLine();
						break;
					}
					// D 연산
					if (c[(2 * r.n) % 10000] == 0) {
						q.offer(new DSLR((2 * r.n) % 10000, r.oper + "D"));
						c[(2 * r.n) % 10000] = 1;
					}
					// S 연산
					if (r.n == 0) {
						if (c[9999] == 0) {    //이걸 위에 r.n == 0 && c[9999] == 0으로 표시해서 런타임 에러
							q.offer(new DSLR(9999, r.oper + "S"));
							c[9999] = 1;
						}
					} else {
						if (c[r.n - 1] == 0) {
							q.offer(new DSLR(r.n - 1, r.oper + "S"));
							c[r.n - 1] = 1;
						}
					}
					// L 연산
					/* 시간초과
					 * StringBuilder str = new StringBuilder(Integer.toString(r.n)); 
					 * char temp = str.charAt(0); 
					 * str.deleteCharAt(0); 
					 * str.append(temp); 
					 * if(c[Integer.parseInt(str.toString())] == 0) {
					 *  q.offer(new DSLR(Integer.parseInt(str.toString()), r.oper + "L"));
					 * c[Integer.parseInt(str.toString())] = 1; 
					 * }
					 */
					if(c[(r.n % 1000)*10 + r.n / 1000] == 0) {
						q.offer(new DSLR((r.n % 1000)*10 + r.n / 1000, r.oper+"L"));
						c[(r.n % 1000)*10 + r.n / 1000] = 1;
					}
					// R 연산
					/*
					 * StringBuilder str1 = new StringBuilder(Integer.toString(r.n)); char temp1 =
					 * str1.charAt(str1.length() - 1); str1.deleteCharAt(str1.length() - 1);
					 * str1.insert(0, temp1); if (c[Integer.parseInt(str1.toString())] == 0) {
					 * q.offer(new DSLR(Integer.parseInt(str1.toString()), r.oper + "R"));
					 * c[Integer.parseInt(str1.toString())] = 1; }
					 */
					if(c[r.n / 10 + (r.n / 1000) * 1000] == 0) {
						q.offer(new DSLR(r.n / 10 + (r.n / 1000) * 1000, r.oper+"R"));
						c[r.n / 10 + (r.n / 1000) * 1000] = 1;
					}

				}
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
