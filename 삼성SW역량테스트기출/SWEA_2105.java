//[모의 SW 역량테스트] 디저트 카페
//DFS(경로 찾기)문제
//처음 생각 : 사이클을 찾으면 되는줄 알고 풀이 -> 사각형인 경우에만 경로로 인정되는 조건을 빼먹음
//중간 생각 : 사각형을 구하기 위해 4방향으로 완전 탐색을 진행(사각형의 방향을 저장해 방향이 바뀔 때마다 length++해서 선분의 개수가 4개가 되는 경로만 탐색 -> 시간 초과
//나중 생각 : 시간 초과를 해결하기 위해서는 4방향 탐색 금지 -> 될 수 있는 사각형을 구하는데 중복을 방지하기 위해 방향 설정 (3->2->0->1)

/*친구들과 디저트 카페 투어를 할 계획이다.

[Fig. 1]과 같이 한 변의 길이가 N인 정사각형 모양을 가진 지역에 디저트 카페가 모여 있다.
 


원 안의 숫자는 해당 디저트 카페에서 팔고 있는 디저트의 종류를 의미하고

카페들 사이에는 대각선 방향으로 움직일 수 있는 길들이 있다.

디저트 카페 투어는 어느 한 카페에서 출발하여

[Fig. 2]와 같이 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다.
 
 

디저트 카페 투어를 하는 도중 해당 지역을 벗어나면 안 된다.

또한, 친구들은 같은 종류의 디저트를 다시 먹는 것을 싫어한다.

즉, [Fig. 3]과 같이 카페 투어 중에 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안 된다.
 
 

[Fig. 4]와 같이 하나의 카페에서 디저트를 먹는 것도 안 된다.

 

[Fig. 5]와 같이 왔던 길을 다시 돌아가는 것도 안 된다.
 


친구들과 디저트를 되도록 많이 먹으려고 한다.

디저트 가게가 모여있는 지역의 한 변의 길이 N과 디저트 카페의 디저트 종류가 입력으로 주어질 때,

임의의 한 카페에서 출발하여 대각선 방향으로 움직이고

서로 다른 디저트를 먹으면서 사각형 모양을 그리며 다시 출발점으로 돌아오는 경우,

디저트를 가장 많이 먹을 수 있는 경로를 찾고, 그 때의 디저트 수를 정답으로 출력하는 프로그램을 작성하라.

만약, 디저트를 먹을 수 없는 경우 -1을 출력한다.


[예시]

한 변의 길이 N이 4인 지역에 디저트 카페가 [Fig. 6]과 같이 있다고 생각하자.
 


디저트 카페 투어가 가능한 경우는 [Fig. 7]과 같이 5가지로 나눌 수 있다.

(출발한 곳과 도는 방향은 다를 수 있지만, 디저트 카페 투어의 경로가 그리는 사각형 모양은 5가지 중 하나이다.)
 

[Fig. 7]
 
이 중에 디저트를 가장 많이 먹을 수 있는 경우는 ⑤인 경우로 디저트의 종류는 6개이다.

따라서, 정답은 6이 된다.


[제약사항]

1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는 데 C/C++/Java 모두 3초

2. 디저트 카페가 모여있는 지역의 한 변의 길이 N은 4 이상 20 이하의 정수이다. (4 ≤ N ≤ 20)

3. 디저트 종류를 나타나는 수는 1 이상 100 이하의 정수이다.


[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 디저트 카페가 모여있는 지역의 한 변의 길이 N이 주어진다.

그 다음 N 줄에는 N * N 크기의 디저트 카페에서 팔고 있는 디저트 종류에 대한 정보가 주어진다.


[출력]

테스트 케이스 개수만큼 T개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.

각 줄은 "#t"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (t는 1부터 시작하는 테스트 케이스의 번호이다)

출력해야 할 정답은 가능한 경우 중 디저트를 가장 많이 먹을 때의 디저트 수 이다.

만약, 디저트를 먹을 수 없는 경우 정답은 -1이다.*/

package 삼성SW역량테스트기출;

import java.io.*;
import java.util.*;

class Dessert {
	int i;
	int j;
	int weight;

	Dessert(int i, int j, int weight) {
		this.i = i;
		this.j = j;
		this.weight = weight;
	}
}

public class SWEA_2105 {
	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, -1, 1 };
	static int length = 0;     // 선분의 개수
	static ArrayList<Dessert> list = new ArrayList<Dessert>();
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int i, int j, int[][] c, int[][] A, int dir) {
		if(length == 4) {
			int flag = 0;
			int flag1 = 0;
			
			for(int k=0;k<dx.length;k++) {    //출발점이랑 1개 차이나는 것이 맞는지 확인
				if(list.get(0).i+dx[k] == list.get(list.size()-1).i && list.get(0).j+dy[k] == list.get(list.size()-1).j)
					flag1 = 1;
			}
			int [] arr = new int[102];
			for(int k=0;k<list.size();k++) {   //중복된 요소가 없는지 확인
				if(arr[list.get(k).weight] != 0)
					flag = 1;
				arr[list.get(k).weight] = 1;
			}
			if(flag == 0 && flag1 == 1 && max < list.size()) {
				max = list.size();
			}
		}
		/*for(int k=0;k<dx.length;k++) {
			if(dir == -1 && (k==0 || k  == 1 || k==2)) continue;
			if(i+dx[k] >= 0 && i+dx[k] < A.length && j+dy[k] >= 0 && j+dy[k] < A.length) {
				if(c[i+dx[k]][j+dy[k]] == 0 && length <= 4) {
					if(dir != k)
						length++;
					c[i+dx[k]][j+dy[k]] =1;
					list.add(new Dessert(i+dx[k], j+dy[k], A[i+dx[k]][j+dy[k]]));
					dfs(i+dx[k], j+dy[k], c, A, k);
					c[i+dx[k]][j+dy[k]] = 0;
					list.remove(list.size()-1);
					if(dir != k)
						length--;
				}
			}
		}*/
		
		if(dir == -1) {   //처음 들어온 경우
			if(i+dx[3] >= 0 && i+dx[3] < A.length && j+dy[3] >= 0 && j+dy[3] < A.length) {
				if(c[i+dx[3]][j+dy[3]] == 0) {
					c[i+dx[3]][j+dy[3]] = 1;
					list.add(new Dessert(i+dx[3], j+dy[3], A[i+dx[3]][j+dy[3]]));
					length++;
					dfs(i+dx[3], j+dy[3], c, A, 3);
					length--;
					list.remove(list.size()-1);
					c[i+dx[3]][j+dy[3]] = 0;
				}
			}
		} else if(dir == 3) {
			//3으로 가는 경우
			if(i+dx[3] >= 0 && i+dx[3] < A.length && j+dy[3] >= 0 && j+dy[3] < A.length) {
				if(c[i+dx[3]][j+dy[3]] == 0) {
					c[i+dx[3]][j+dy[3]] = 1;
					list.add(new Dessert(i+dx[3], j+dy[3], A[i+dx[3]][j+dy[3]]));
					dfs(i+dx[3], j+dy[3], c, A, 3);
					list.remove(list.size()-1);
					c[i+dx[3]][j+dy[3]] = 0;
				}
			}
			//2로 가는 경우
			if(i+dx[2] >= 0 && i+dx[2] < A.length && j+dy[2] >= 0 && j+dy[2] < A.length) {
				if(c[i+dx[2]][j+dy[2]] == 0) {
					c[i+dx[2]][j+dy[2]] = 1;
					length++;
					list.add(new Dessert(i+dx[2], j+dy[2], A[i+dx[2]][j+dy[2]]));
					dfs(i+dx[2], j+dy[2], c, A, 2);
					length--;
					list.remove(list.size()-1);
					c[i+dx[2]][j+dy[2]] = 0;
				}
			}
		}else if(dir == 2) {
			//2로가는 경우
			if(i+dx[2] >= 0 && i+dx[2] < A.length && j+dy[2] >= 0 && j+dy[2] < A.length) {
				if(c[i+dx[2]][j+dy[2]] == 0) {
					c[i+dx[2]][j+dy[2]] = 1;
					list.add(new Dessert(i+dx[2], j+dy[2], A[i+dx[2]][j+dy[2]]));
					dfs(i+dx[2], j+dy[2], c, A, 2);
					list.remove(list.size()-1);
					c[i+dx[2]][j+dy[2]] = 0;
				}
			}
			//0으로 가는 경우
			if(i+dx[0] >= 0 && i+dx[0] < A.length && j+dy[0] >= 0 && j+dy[0] < A.length) {
				if(c[i+dx[0]][j+dy[0]] == 0) {
					c[i+dx[0]][j+dy[0]] = 1;
					length++;
					list.add(new Dessert(i+dx[0], j+dy[0], A[i+dx[0]][j+dy[0]]));
					dfs(i+dx[0], j+dy[0], c, A, 0);
					length--;
					list.remove(list.size()-1);
					c[i+dx[0]][j+dy[0]] = 0;
				}
			}
		}else if(dir == 0) {
			//0으로 가는 경우
			if(i+dx[0] >= 0 && i+dx[0] < A.length && j+dy[0] >= 0 && j+dy[0] < A.length) {
				if(c[i+dx[0]][j+dy[0]] == 0) {
					c[i+dx[0]][j+dy[0]] = 1;
					list.add(new Dessert(i+dx[0], j+dy[0], A[i+dx[0]][j+dy[0]]));
					dfs(i+dx[0], j+dy[0], c, A, 0);
					list.remove(list.size()-1);
					c[i+dx[0]][j+dy[0]] = 0;
				}
			}
			//1로 가는 경우
			if(i+dx[1] >= 0 && i+dx[1] < A.length && j+dy[1] >= 0 && j+dy[1] < A.length) {
				if(c[i+dx[1]][j+dy[1]] == 0) {
					c[i+dx[1]][j+dy[1]] = 1;
					length++;
					list.add(new Dessert(i+dx[1], j+dy[1], A[i+dx[1]][j+dy[1]]));
					dfs(i+dx[1], j+dy[1], c, A, 1);
					length--;
					list.remove(list.size()-1);
					c[i+dx[1]][j+dy[1]] = 0;
				}
			}
		} else if(dir == 1) {
			if(i+dx[1] >= 0 && i+dx[1] < A.length && j+dy[1] >= 0 && j+dy[1] < A.length) {
				if(c[i+dx[1]][j+dy[1]] == 0) {
					c[i+dx[1]][j+dy[1]] = 1;
					list.add(new Dessert(i+dx[1], j+dy[1], A[i+dx[1]][j+dy[1]]));
					dfs(i+dx[1], j+dy[1], c, A, 1);
					list.remove(list.size()-1);
					c[i+dx[1]][j+dy[1]] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());
				int[][] A = new int[N][N];

				for (int j = 0; j < N; j++) {
					String [] arr = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr[k]);
					}
				}
				int[][] c = new int[N][N]; // 방문 여부 저장
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						dfs(j, k, c, A, -1);
					}
				}
				if (max == Integer.MIN_VALUE)
					max = -1;
				System.out.println("#" + (i + 1) + " " + max);
				max = Integer.MIN_VALUE;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
