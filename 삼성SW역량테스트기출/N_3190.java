//백준 3190번(뱀)
//bfs를 이용한 문제(현재 상태에서 몇 번의 연산을 통해 해당 상태로 되는지 최소값을 구하는 문제) 현재 상태: 뱀 머리 위치(i, j), 뱀의 길이, 뱀의 방향
/*문제
 'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.

게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.

입력
첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)

다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.

다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)

다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데,  정수 X와 문자 C로 이루어져 있으며. 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다. X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

출력
첫째 줄에 게임이 몇 초에 끝나는지 출력한다.*/

package 삼성SW역량테스트기출;
import java.util.*;

class Change{
	int sec;
	char dir;
	
	Change(int sec, char dir){
		this.sec = sec;
		this.dir = dir;
	}
}

class Location{
	int si;
	int sj;
	int fi;
	int fj;
	int length;
	int dir;      //0:상, 1:하, 2:좌, 3:우
	int time;
	
	Location(int si, int sj, int fi, int fj, int length, int dir, int time){
		this.si = si;
		this.sj = sj;
		this.fi = fi;
		this.fj = fj;
		this.length = length;
		this.dir = dir;
		this.time = time;
	}
}

class Point{
	int i;
	int j;
	
	Point(int i, int j){
		this.i  =i;
		this.j = j;
	}
}
public class N_3190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		int [][] A = new int[N][N];  //사과의 위치 저장
		for(int i=0;i<K;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			A[a-1][b-1] = 1;
		}
		int L = s.nextInt();
		ArrayList<Change> list = new ArrayList<Change>();     // 뱀의 방향 전환 정보 저장
		for(int i=0;i<L;i++) {
			list.add(new Change(s.nextInt(), s.next().charAt(0)));
		}
		//bfs를 이용한 탐색
		int [][] visited = new int[N][N];     // 현재 뱀이 위치한 곳은 1로 나타냄
		Queue<Location> q = new LinkedList<Location>();
		ArrayList<Point> al = new ArrayList<Point>();    //현재 뱀의 머리부터 꼬리까지의 위치를 순서대로 저장
		
		visited[0][0] = 1;
		al.add(new Point(0, 0));
		q.offer(new Location(0,0, 0, 0, 1, 3, 0));
		
		while(!q.isEmpty()) {
			Location l = q.poll();
			
			if(!list.isEmpty() && list.get(0).sec == l.time) { // 만약 L 나오면 0->2, 1->3, 2->1, 3->0   만약 R나오면 0->3, 1->2, 2->0, 3->1

				if(list.get(0).dir == 'L') {
					if(l.dir == 0)
						l.dir = 2;
					else if(l.dir == 1)
						l.dir = 3;
					else if(l.dir == 2)
						l.dir = 1;
					else
						l.dir = 0;
				}else if(list.get(0).dir == 'D') {
					if(l.dir == 0)
						l.dir = 3;
					else if(l.dir == 1)
						l.dir = 2;
					else if(l.dir == 2)
						l.dir = 0;
					else
						l.dir = 1;
				}
				list.remove(0);   /* 이 부분 추가 안해서 틀렸었음 */
				
			}
			if(l.dir == 3) {      //오른쪽으로 이동
				//먼저 조건에 위배되는 경우 처리 (벽에 부딪히는 경우와 뱀의 몸과 부딪히는 경우)
				if(l.sj+1 >=N) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si][l.sj+1] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. 사과가 없는 경우
				if(A[l.si][l.sj+1] == 0) {
					visited[l.si][l.sj+1] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si, l.sj+1));    //리스트의 앞이 머리에 해당하고 리스트의 끝이 뱀의 꼬리에 해당하므로 첫번째자리에 삽입해야한다 무조건
					al.remove(al.size()-1);
					q.offer(new Location(l.si, l.sj+1, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. 사과가 있는 경우
				if(A[l.si][l.sj+1] == 1) {
					A[l.si][l.sj+1] = 0;
					visited[l.si][l.sj+1] = 1;
					al.add(0, new Point(l.si, l.sj+1));
					q.offer(new Location(l.si, l.sj+1, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			} else if(l.dir == 2) {      //왼쪽으로 이동
				//먼저 조건에 위배되는 경우 처리 (벽에 부딪히는 경우와 뱀의 몸과 부딪히는 경우)
				if(l.sj-1 < 0) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si][l.sj-1] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. 사과가 없는 경우
				if(A[l.si][l.sj-1] == 0) {
					visited[l.si][l.sj-1] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si, l.sj-1));
					al.remove(al.size()-1);
					q.offer(new Location(l.si, l.sj-1, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. 사과가 있는 경우
				if(A[l.si][l.sj-1] == 1) {
					A[l.si][l.sj-1] = 0;
					visited[l.si][l.sj-1] = 1;
					al.add(0, new Point(l.si, l.sj-1));
					q.offer(new Location(l.si, l.sj-1, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			} else if(l.dir == 0) {      //위쪽으로 이동
				//먼저 조건에 위배되는 경우 처리 (벽에 부딪히는 경우와 뱀의 몸과 부딪히는 경우)
				if(l.si-1 < 0) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si-1][l.sj] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. 사과가 없는 경우
				if(A[l.si-1][l.sj] == 0) {
					visited[l.si-1][l.sj] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si-1, l.sj));
					al.remove(al.size()-1);
					q.offer(new Location(l.si-1, l.sj, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. 사과가 있는 경우
				if(A[l.si-1][l.sj] == 1) {
					A[l.si-1][l.sj] = 0;
					visited[l.si-1][l.sj] = 1;
					al.add(0, new Point(l.si-1, l.sj));
					q.offer(new Location(l.si-1, l.sj, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			}else if(l.dir == 1) {      //아래쪽으로 이동
				//먼저 조건에 위배되는 경우 처리 (벽에 부딪히는 경우와 뱀의 몸과 부딪히는 경우)
				if(l.si+1 >=N) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si+1][l.sj] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. 사과가 없는 경우
				if(A[l.si+1][l.sj] == 0) {
					visited[l.si+1][l.sj] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si+1, l.sj));
					al.remove(al.size()-1);
					q.offer(new Location(l.si+1, l.sj, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. 사과가 있는 경우
				if(A[l.si+1][l.sj] == 1) {
					A[l.si+1][l.sj] = 0;
					visited[l.si+1][l.sj] = 1;
					al.add(0, new Point(l.si+1, l.sj));
					q.offer(new Location(l.si+1, l.sj, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			}
		}
	}

}
