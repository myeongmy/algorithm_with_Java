//백준 2589번
//BFS 문제 (최단 거리 구하기)
/*문제
보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.



예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.



보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.

출력
첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.*/

package 백준;
import java.util.*;

class Point3{
	int i;
	int j;
	int cnt;
	
	Point3(int i, int j, int cnt){
		this.i = i;
		this.j = j;
		this.cnt = cnt;
		
	}
}
public class N_2589 {
	static int max = 0;
	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {-1, 1, 0, 0};
	static void bfs(int i, int j, char [][] A, int [][] c) {
		Queue<Point3> q = new LinkedList<Point3>();
		c[i][j] = 1;
		q.offer(new Point3(i, j, 0));
		
		while(!q.isEmpty()) {
			Point3 p = q.poll();
			if(p.cnt > max)
				max = p.cnt;
			for(int k=0;k<dx.length;k++) {
				if(p.i+dx[k]>=0 && p.i+dx[k]<A.length && p.j+dy[k]>=0 && p.j+dy[k]<A[0].length) {
					if(A[p.i+dx[k]][p.j+dy[k]] == 'L' && c[p.i+dx[k]][p.j+dy[k]] == 0) {
						q.offer(new Point3(p.i+dx[k], p.j+dy[k], p.cnt+1));
						c[p.i+dx[k]][p.j+dy[k]] = 1;
					}
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		char [][] A = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = s.next();
			for(int j=0;j<M;j++) {
				A[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(A[i][j] == 'L') {
					int [][] c = new int[N][M];
					bfs(i, j, A, c);
				}
			}
		}
		System.out.println(max);
	}

}
