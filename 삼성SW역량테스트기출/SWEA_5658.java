//[모의 SW역량테스트] 보물상자 비밀번호
//간단한 브루트 포스 문제
/*각 변에 다음과 같이 16진수 숫자(0~F)가 적혀 있는 보물상자가 있다.

보물 상자의 뚜껑은 시계방향으로 돌릴 수 있고, 한 번 돌릴 때마다 숫자가 시계방향으로 한 칸씩 회전한다.

 

각 변에는 동일한 개수의 숫자가 있고, 시계방향 순으로 높은 자리 숫자에 해당하며 하나의 수를 나타낸다.

예를 들어 [Fig.1]의 수는 1A3, B54, 8F9, D66이고, [Fig.2]의 수는 61A, 3B5, 48F, 9D6이다.

보물상자에는 자물쇠가 걸려있는데, 이 자물쇠의 비밀번호는 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중, K번째로 큰 수를 10진 수로 만든 수이다.

N개의 숫자가 입력으로 주어졌을 때, 보물상자의 비밀 번호를 출력하는 프로그램을 만들어보자.

(서로 다른 회전 횟수에서 동일한 수가 중복으로 생성될 수 있다. 크기 순서를 셀 때 같은 수를 중복으로 세지 않도록 주의한다.)

 

[제약 사항]
 

N은 4의 배수이고, 8이상 28이하의 정수이다. (8 ≤ N ≤ 28)       
N개의 숫자는 각각 0이상 F이하로 주어진다. (A~F는 알파벳 대문자로만 주어진다.)
K는 생성 가능한 수의 개수보다 크게 주어지지 않는다.
 

[예제]
 

아래와 같이 (1, B, 3, B, 3, B, 8, 1, F, 7, 5, E) 12개의 숫자가 주어지고 K가 10인 경우를 살펴보자.
 

 

이 경우에 생성 가능한 수는 각 회전 별로 다음과 같다.  

0회전 : 1B3, B3B, 81F, 75E
1회전 : E1B, 3B3, B81, F75
2회전 : 5E1, B3B, 3B8, 1F7
3회전 : 0회전과 동일

생성 가능한 수를 내림 차순으로 나열하면 다음과 같고, K(=10)번째로 큰 수는 503(=1F7)이다.
(B3B를 중복으로 세지 않도록 주의한다.)

F75, E1B, B81, B3B, 81F, 75E, 5E1, 3B8, 3B3, 1F7, 1B3

 



[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 숫자의 개수 N과 크기 순서 K가 주어 진다.

그 다음 줄에는 16진수 0~F 숫자가 공백 없이 N개 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

public class SWEA_5658 {
	static void moving(StringBuilder sb) {
		char s = sb.charAt(0);
		sb.deleteCharAt(0).append(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int N = Integer.parseInt(arr[0]);
				int K = Integer.parseInt(arr[1]);

				StringBuilder sb = new StringBuilder(br.readLine());

				ArrayList<String> list = new ArrayList<String>();
				int interval = N / 4;
				// 0회전
				for (int j = 0; j < sb.length(); j += interval) {
					list.add(sb.substring(j, j + interval));
				}
				for (int j = 1; j < interval; j++) {
					for (int k = 0; k < interval - 1; k++) {
						moving(sb);
					}
					for (int k = 0; k < sb.length(); k += interval) {
						list.add(sb.substring(k, k + interval));
					}
				}
				Collections.sort(list, Collections.reverseOrder());
				// 중복제거를 위한 set
				LinkedHashSet<String> set = new LinkedHashSet<String>();
				for (int k = 0; k < list.size(); k++)
					set.add(list.get(k));

				Iterator<String> it = set.iterator();
				int num = 0;
				while (it.hasNext()) {
					if (num == K - 1) {
						System.out.println("#" + (i + 1) + " " + Integer.parseInt(it.next(), 16));
						break;
					}
					it.next();
					num++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
