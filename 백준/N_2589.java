//���� 2589��
//BFS ���� (�ִ� �Ÿ� ���ϱ�)
/*����
������ ������ �߰��� ��ũ ������ ������ ã�Ƴ�����. ������ ������ �Ʒ� �׸��� ���� ���簢�� ����̸� ���� ĭ���� �������� �ִ�. �� ĭ�� ����(L)�� �ٴ�(W)�� ǥ�õǾ� �ִ�. �� �������� �̵��� �����¿�� �̿��� �����θ� �����ϸ�, �� ĭ �̵��ϴµ� �� �ð��� �ɸ���. ������ ���� ���� �ִ� �Ÿ��� �̵��ϴµ� �־� ���� �� �ð��� �ɸ��� ���� �� ���� ������ �����ִ�. ������ ��Ÿ���� �� �� ���̸� �ִ� �Ÿ��� �̵��Ϸ��� ���� ���� �� �� �̻� �������ų�, �ָ� ���ư����� �� �ȴ�.



���� ��� ���� ���� ������ �־����ٸ� ������ �Ʒ� ǥ�õ� �� ���� ���� �ְ� �ǰ�, �� �� ������ �ִ� �Ÿ��� �̵��ϴ� �ð��� 8�ð��� �ȴ�.



���� ������ �־��� ��, ������ ���� �ִ� �� �� ���� �ִ� �Ÿ��� �̵��ϴ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� ���� ������ ������ ũ��� ������ ũ�Ⱑ ��ĭ�� ���̿� �ΰ� �־�����. �̾� L�� W�� ǥ�õ� ���� ������ �Ʒ��� ���� ���� �־�����, �� ���� ���̿��� �� ĭ�� ����. ���� ������ ����, ������ ũ��� ���� 50�����̴�.

���
ù° �ٿ� ������ ���� �ִ� �� �� ���̸� �ִ� �Ÿ��� �̵��ϴ� �ð��� ����Ѵ�.*/

package ����;
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
