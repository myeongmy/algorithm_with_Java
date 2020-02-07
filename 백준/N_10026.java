//백준 10026번
//DFS 문제
/*문제
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄부터 N개 줄에는 그림이 주어진다.

출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.*/

package 백준;
import java.util.*;

public class N_10026 {
	static int [][] c = new int[101][101];
	static int [][] c1 = new int[101][101];
	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {-1, 1, 0, 0};
	
	static void dfs(int i, int j, char [][] A) {
		c[i][j] = 1;
		
		for(int k=0;k<dx.length;k++) {
			if(i+dx[k]>=0 && i+dx[k] < A.length && j+dy[k] >=0 && j+dy[k] <A[0].length) {
				if(A[i][j] == A[i+dx[k]][j+dy[k]] && c[i+dx[k]][j+dy[k]] == 0) {
					dfs(i+dx[k], j+dy[k] , A);
				}
			}
		}
	}
	
	static void dfs1(int i, int j, char [][] A) {
		c1[i][j] = 1;
		
		for(int k=0;k<dx.length;k++) {
			if(i+dx[k]>=0 && i+dx[k] < A.length && j+dy[k] >=0 && j+dy[k] <A[0].length) {
				if(A[i][j] == 'R' || A[i][j] == 'G') {
					if((A[i+dx[k]][j+dy[k]] == 'R' || A[i+dx[k]][j+dy[k]] == 'G') && c1[i+dx[k]][j+dy[k]] == 0) {
						dfs1(i+dx[k], j+dy[k] , A);
					}
				}else {
					if(A[i][j] == A[i+dx[k]][j+dy[k]] && c1[i+dx[k]][j+dy[k]] == 0) {
						dfs1(i+dx[k], j+dy[k] , A);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int N = s.nextInt();
		char [][] A = new char[N][N];
		for(int i=0;i<N;i++) {
			String str = s.next();
			for(int j=0;j<N;j++) {
				A[i][j] = str.charAt(j);
			}
		}
		int connected = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(c[i][j] == 0) {
					dfs(i, j, A);
					connected++;
				}
			}
		}
		System.out.print(connected+" ");
		
		connected = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(c1[i][j] == 0) {
					dfs1(i, j, A);
					connected++;
				}
			}
		}
		System.out.print(connected);
	}

}
