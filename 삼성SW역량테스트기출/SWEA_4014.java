//[모의 SW 역량테스트] 활주로 건설
//연속된 수 구하기 + 브루트 포스 문제
/*[Fig. 1] 과 같은 N * N 크기의 절벽지대에 활주로를 건설하려고 한다.

각 셀의 숫자는 그 지형의 높이를 의미한다.

                                                      

활주로를 [Fig. 2] 와 같이 가로 또는 세로 방향으로 건설할 수 있는 가능성을 확인하려고 한다.
                               

활주로는 높이가 동일한 구간에서 건설이 가능하다.

높이가 다른 구간의 경우 활주로가 끊어지기 때문에 [Fig. 3] 과 같은 경사로를 설치해야만 활주로를 건설 할 수 있다.


                                                      

경사로는 길이가 X 이고, 높이는 1 이다.

경사로는 높이 차이가 1 이고 낮은 지형의 높이가 동일하게 경사로의 길이만큼 연속되는 곳에 설치 할 수 있다.

 

예를 들어 [Fig. 4] 는 길이가 2 이고 높이가 1 인 경사로를 설치하는 예를 보여준다.
                                  

 

경사로의 길이 X 와 절벽지대의 높이 정보가 주어질 때,

활주로를 건설할 수 있는 경우의 수를 계산하는 프로그램을 작성하라.

 
 

[예시]

지도의 한 변의 크기 N 이 6, 경사로의 길이 X 가 2 일 때,

[Fig. 5] 와 같이 지형의 높이가 주어진 경우를 생각해 보자.


                                                      


[Fig. 5] 의 지형 중 [ 3, 3, 3, 2, 1, 1 ] 의 경우 [Fig. 6] 과 같이 높이 2 인 구간이 경사로 길이보다 짧아서 활주로를 설치 할 수 없다.


                                                      

[ 3, 3, 3, 2, 2, 1 ] 의 지형은 [Fig. 7] 과 같이 경사로를 지형 밖까지 설치해야 되기 때문에 활주로를 설치할 수 없다.


                                                      

[ 2, 2, 3, 2, 2, 2 ] 지형과 [ 3, 3, 3, 2, 2, 2 ] 지형의 경우 아래 [Fig. 8-1], [Fig. 8-2] 와 같이 경사로를 설치하여 활주로를 건설할 수 있다.

                           
                           

[Fig. 5] 와 같은 지형에 활주로를 건설하는 방법은

아래 [Fig. 9] 와 같이 총 7 가지 ( 가로 방향 3 가지, 세로 방향 4 가지 ) 경우가 있다.

즉, 예제에 대한 정답은 7 이 된다

                                                    

[제약사항]

1. 시간제한 : 최대 50 개 테스트 케이스를 모두 통과하는 데 C / C++ / Java 모두 3 초

2. N 의 크기는 6 이상 20 이하의 정수이다. ( 6 ≤ N ≤ 20 )

3. 경사로의 높이는 항상 1 이고, 길이 X 는 2 이상 4 이하의 정수이다. ( 2 ≤ X ≤ 4 )

4. 지형의 높이는 1 이상 6 이하의 정수이다.

5. 동일한 셀에 두 개 이상의 경사로를 겹쳐서 사용할 수 없다.

( 아래 [Fig. 10] 과 같은 경우는 경사로를 설치하여 활주로를 연결 할 수 없다. )

                                           

6. 경사로는 세워서 사용할 수 없다. ( [Fig. 11] 참고 )


                                                      


[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,

그 다음 줄부터 T 개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 지도의 한 변의 크기인 N 과 경사로의 길이 X 가 주어진다.

다음 N 개의 줄에는 N * N 크기의 지형 정보가 주어진다.


 
[출력]

테스트 케이스 개수만큼 T 개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.

각 줄은 "#t" 로 시작하고 공백을 하나 둔 다음 정답을 출력한다. ( t 는 1 부터 시작하는 테스트 케이스의 번호이다. )

정답은 활주로를 건설할 수 있는 경우의 수이다.*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

public class SWEA_4014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int N = Integer.parseInt(arr[0]);
				int X = Integer.parseInt(arr[1]);

				int[][] A = new int[N][N];
				for (int j = 0; j < N; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr1[k]);
					}
				}

				int possible = 0;
				// 가로 연속된 수 판단
				Label: for (int j = 0; j < N; j++) {
					int cnt = 1;
					int haveTo = 0; // 이 때 반드시 경사로를 가져야 한다.
					for (int k = 1; k < N; k++) {
						if (A[j][k] == A[j][k - 1]) {
							cnt++;
							if (cnt == X && haveTo == 1) {
								cnt = 0;     //맨 처음에는 cnt = 1로 했었는데 cnt = 0으로 바꿨더니 통과되었다.
								haveTo = 0;
							}
						} else {
							if (Math.abs(A[j][k] - A[j][k - 1]) >= 2)
								continue Label;
							if (haveTo == 1 && cnt < X) {
								continue Label;
							}
							if (A[j][k] < A[j][k - 1]) {
								cnt = 1;
								haveTo = 1;
							} else if (A[j][k] > A[j][k - 1]) {
								if (cnt < X)
									continue Label;
								cnt = 1;
							}
						}
					}
					if (haveTo == 1 && cnt < X)
						continue;
					possible++;
				}
				// 세로 연속된 수 판단
				Label: for (int j = 0; j < N; j++) {
					int cnt = 1;
					int haveTo = 0; // 이 때 반드시 경사로를 가져야 한다.
					for (int k = 1; k < N; k++) {
						if (A[k][j] == A[k - 1][j]) {
							cnt++;
							if (cnt == X && haveTo == 1) {
								cnt = 0;
								haveTo = 0;
							}

						} else {
							if (Math.abs(A[k][j] - A[k - 1][j]) >= 2)
								continue Label;
							if (haveTo == 1 && cnt < X) {
								continue Label;
							}
							if (A[k][j] < A[k - 1][j]) {
								cnt = 1;
								haveTo = 1;
							} else if (A[k][j] > A[k - 1][j]) {
								if (cnt < X)
									continue Label;
								cnt = 1;
							}
						}
					}
					if (haveTo == 1 && cnt < X)
						continue;
					possible++;
				}
				System.out.println("#"+(i+1)+" "+possible);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
