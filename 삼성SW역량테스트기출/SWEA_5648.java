//[모의 SW역량테스트] 원자 소멸 시뮬레이션
//시뮬레이션 문제
//처음 생각 - 메모리 초과 (테스트 케이스마다 array 배열을 선언하다보니 메모리 초과의 결과를 낳았다. static으로 선언하여 해결)
//두 번째 생각 - 시간 초과 (0.5초에서 만나는 경우를 고려하기 위해 바로 옆 좌표에 있는 경우에는 다음에 충돌이 일어날 것으로 예상하여 반복문을 돌 때 그것도 같이 체크해줌)
//pass된 코드 - 0.5초에서 만나는 경우를 고려하기 위해 좌표값을 *2해서 4000 by 4000의 배열을 선언. 그리고 map array에는 현재 위치의 에너지 값을 저장하고 큐에서 빼낸 에너지 값이 현재 위치의 에너지 값과 일치하지 않는 경우 충돌이 일어난 것으로 간주했다.

/*원자력 발전소에서 근무하는 상원이는, 발전소에서 발생하는 에너지를 미리 계산하기 위해 원자들의 움직임을 시뮬레이션 하는 프로그램을 만들려고 한다.

 

원자들은 2차원 평면에서 이동하며 두 개 이상의 원자가 충돌 할 경우 충돌한 원자들은 각자 보유한 에너지를 모두 방출하고 소멸된다.

 

원자의 움직임은 다음과 같다.
 

1. 원자의 최초 위치는 2차원 평면상의 [x, y] 이다.

2. 원자는 각자 고유의 움직이는 방향을 가지고 있다. (상하좌우 4방향)

 - 상: y 가 증가하는 방향

 - 하: y 가 감소하는 방향

 - 좌: x 가 감소하는 방향

 - 우: x 가 증가하는 방향

3. 모든 원자들의 이동속도는 동일하다. 즉, 1초에 1만큼의 거리를 이동한다.

4. 모든 원자들은 최초 위치에서 동시에 이동을 시작한다.
5. 두 개 이상의 원자가 동시에 충돌 할 경우 충돌한 원자들은 모두 보유한 에너지를 방출하고 소멸된다.
 

           
                                    [그림-1]

 

[그림-1] 과 같이 원자들의 [x, y] 위치와 이동방향이 주어지고 각 원자들의 보유 에너지가 1 이라고 가정해보자. (실제 입력에서 원자들의 보유 에너지는 각각 다를 수 있다.)

충돌된 원자들이 소멸하면서 방출하는 에너지는 다음과 같다.

1초 후에 I, J 원자가 충돌 후 소멸하면서 2 에너지 방출
1.5초 후에 A, B 원자가 충돌 후 소멸하면서 2 에너지 방출
2초 후에 D, E, G, H 원자가 충돌 후 소멸하면서 4 에너지 방출
3초 후에 M, N 원자가 충돌 후 소멸하면서 2 에너지 방출
[그림-1]의 경우 시간이 흘러도 원자 C, F, K, L 은 영원히 충돌하지 않아 소멸되지 않는다.

따라서 원자들이 소멸되면서 방출하는 에너지의 총합은 10 이다.

 

N 개의 원자들의 [x, y] 위치, 이동 방향, 보유 에너지가 주어질 때 원자들이 소멸되면서 방출하는 에너지의 총합을 구하는 프로그램을 작성하라.

 

 

[제약 사항]
 

1. 원자들의 수 N 은 1,000개 이하이다. (1≤N≤1,000)

2. 각 원자들의 보유 에너지 K 는 1 이상 100 이하이다. (1≤K≤100)

3. 원자들의 처음 위치 [x, y] 는 -1,000 이상 1,000 이하의 정수로 주어진다. (-1,000≤x,y≤1,000)

4. 원자들은 2차원 평면 위에서 움직이며 원자들이 움직일 수 있는 좌표의 범위에 제한은 없다.

5. 원자들의 이동 방향은 상(0), 하(1), 좌(2), 우(3)로 주어진다.

6. 원자들은 동시에 1초에 이동 방향으로 1만큼 이동한다.

7. 원자들의 최초 위치는 서로 중복되지 않는다.

8. 원자들은 2개 이상의 원자들이 서로 충돌할 경우 보유한 에너지를 방출하면서 바로 소멸된다.

9. 원자들은 이동 방향은 처음에 주어진 방향에서 바뀌지 않는다.

10. 원자들이 충돌하여 소멸되며 방출되는 에너지는 다른 원자의 위치나 이동 방향에 영향을 주지 않는다.

 

[입력]
 

입력의 가장 첫 줄에는 총 테스트 케이스의 개수 T가 주어진다.

그 다음 줄부터는 각 테스트 케이스가 주어진다. 각 테스트 케이스의 첫째 줄에는 원자들의 수 N이 주어진다.

다음 N개의 줄에는 원자들의 x 위치, y 위치, 이동 방향, 보유 에너지 K가 주어진다.

원자들의 이동 방향은 상(0), 하(1), 좌(2), 우(3)로 주어진다.

 

[출력]
 

테스트 케이스 T에 대한 결과는 “#T”을 찍고, 방출되는 에너지의 총합을 출력한다. (T는 테스트케이스의 번호를 의미하며 1부터 시작한다. )*/

package 삼성SW역량테스트기출;

import java.io.*;
import java.util.*;

class Atom {
	int i;
	int j;
	int dir;
	int energy;

	Atom(int i, int j, int dir, int energy) {
		this.i = i;
		this.j = j;
		this.dir = dir;
		this.energy = energy;
	}
}

public class SWEA_5648 {
	static int [][] array = new int[4001][4001];    //메모리 초과를 막기 위해 static으로 선언을 하였고 좌표 범위가 -1000~1000인 것을 고려해 +1000을 하여 0~2000 배열을 사용! 그리고 0.5초에서 만나는 경우를 고려하기 위해 *2를 해주었다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				Queue<Atom> q = new LinkedList<Atom>();
				int min_i = Integer.MAX_VALUE;
				int min_j = Integer.MAX_VALUE;
				int max_i = Integer.MIN_VALUE;
				int max_j = Integer.MIN_VALUE; 

				for (int j = 0; j < N; j++) {
					String[] arr = br.readLine().split(" ");
					q.offer(new Atom((Integer.parseInt(arr[0]) + 1000)*2, (Integer.parseInt(arr[1])+ 1000)*2,
							Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
					array[(Integer.parseInt(arr[0])+ 1000)*2][(Integer.parseInt(arr[1])+ 1000)*2] = Integer.parseInt(arr[3]);
					
					if (min_i > (Integer.parseInt(arr[0]) + 1000)*2)
						min_i = (Integer.parseInt(arr[0]) + 1000)*2;
					if (max_i < (Integer.parseInt(arr[0]) + 1000)*2)
						max_i = (Integer.parseInt(arr[0]) + 1000)*2;
					if (min_j > (Integer.parseInt(arr[1])+ 1000)*2)
						min_j = (Integer.parseInt(arr[1])+ 1000)*2;
					if (max_j < (Integer.parseInt(arr[1])+ 1000)*2)
						max_j = (Integer.parseInt(arr[1])+ 1000)*2;
				}
				int result = 0;
					while (!q.isEmpty()) {
						Atom a = q.poll();
						
						if(array[a.i][a.j] != a.energy) {   //충돌이 일어난 경우
							result += array[a.i][a.j];
							array[a.i][a.j] = 0;
							continue;
						}
						if (a.dir == 0) {
							if (a.j + 1 > max_j) {
								array[a.i][a.j] = 0;
								continue;
							}
								
							if(array[a.i][a.j+1] == 0) {
								array[a.i][a.j+1] = a.energy;
								q.offer(new Atom(a.i, a.j+1, a.dir, a.energy));
							}else {
								array[a.i][a.j+1] += a.energy;
							}
						} else if (a.dir == 1) {
							if (a.j - 1 < min_j) {
								array[a.i][a.j] = 0;
								continue;
							}
							
							if(array[a.i][a.j-1] == 0) {
								array[a.i][a.j-1] = a.energy;
								q.offer(new Atom(a.i, a.j-1, a.dir, a.energy));
							}else {
								array[a.i][a.j-1] += a.energy;
							}
						} else if (a.dir == 2) {
							if (a.i - 1 < min_i) {
								array[a.i][a.j] = 0;
								continue;
							}

							if(array[a.i-1][a.j] == 0) {
								array[a.i-1][a.j] = a.energy;
								q.offer(new Atom(a.i-1, a.j, a.dir, a.energy));
							}else {
								array[a.i-1][a.j] += a.energy;
							}
						} else if (a.dir == 3) {
							if (a.i + 1 > max_i) {
								array[a.i][a.j] = 0;
								continue;
							}
							

							if(array[a.i+1][a.j] == 0) {
								array[a.i+1][a.j] = a.energy;
								q.offer(new Atom(a.i+1, a.j, a.dir, a.energy));
							}else {
								array[a.i+1][a.j] += a.energy;
							}
						}
						array[a.i][a.j] = 0;
					}
					

				
				System.out.println("#" + (i + 1) + " " + result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
