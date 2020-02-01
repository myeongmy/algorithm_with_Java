//���� 3190��(��)
//bfs�� �̿��� ����(���� ���¿��� �� ���� ������ ���� �ش� ���·� �Ǵ��� �ּҰ��� ���ϴ� ����) ���� ����: �� �Ӹ� ��ġ(i, j), ���� ����, ���� ����
/*����
 'Dummy' ��� ���������� �ִ�. �� ���ӿ��� ���� ���ͼ� ���ٴϴµ�, ����� ������ �� ���̰� �þ��. ���� �̸����� ���ٴϴٰ� �� �Ǵ� �ڱ��ڽ��� ���� �ε����� ������ ������.

������ NxN ���簢 ���������� ����ǰ�, ��� ĭ���� ����� ������ �ִ�. ������ �����¿� ���� ���� �ִ�. ������ �����Ҷ� ���� ���� �������� ��ġ�ϰ� ���� ���̴� 1 �̴�. ���� ó���� �������� ���Ѵ�.

���� �� �ʸ��� �̵��� �ϴµ� ������ ���� ��Ģ�� ������.

���� ���� �����̸� �÷� �Ӹ��� ����ĭ�� ��ġ��Ų��.
���� �̵��� ĭ�� ����� �ִٸ�, �� ĭ�� �ִ� ����� �������� ������ �������� �ʴ´�.
���� �̵��� ĭ�� ����� ���ٸ�, �����̸� �ٿ��� ������ ��ġ�� ĭ�� ����ش�. ��, �����̴� ������ �ʴ´�.
����� ��ġ�� ���� �̵���ΰ� �־��� �� �� ������ �� �ʿ� �������� ����϶�.

�Է�
ù° �ٿ� ������ ũ�� N�� �־�����. (2 �� N �� 100) ���� �ٿ� ����� ���� K�� �־�����. (0 �� K �� 100)

���� K���� �ٿ��� ����� ��ġ�� �־����µ�, ù ��° ������ ��, �� ��° ������ �� ��ġ�� �ǹ��Ѵ�. ����� ��ġ�� ��� �ٸ���, �� �� �� ���� (1�� 1��) ���� ����� ����.

���� �ٿ��� ���� ���� ��ȯ Ƚ�� L �� �־�����. (1 �� L �� 100)

���� L���� �ٿ��� ���� ���� ��ȯ ������ �־����µ�,  ���� X�� ���� C�� �̷���� ������. ���� ���� �ð����κ��� X�ʰ� ���� �ڿ� ����(C�� 'L') �Ǵ� ������(C�� 'D')�� 90�� ������ ȸ����Ų�ٴ� ���̴�. X�� 10,000 ������ ���� �����̸�, ���� ��ȯ ������ X�� �����ϴ� ������ �־�����.

���
ù° �ٿ� ������ �� �ʿ� �������� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;
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
	int dir;      //0:��, 1:��, 2:��, 3:��
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
		int [][] A = new int[N][N];  //����� ��ġ ����
		for(int i=0;i<K;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			A[a-1][b-1] = 1;
		}
		int L = s.nextInt();
		ArrayList<Change> list = new ArrayList<Change>();     // ���� ���� ��ȯ ���� ����
		for(int i=0;i<L;i++) {
			list.add(new Change(s.nextInt(), s.next().charAt(0)));
		}
		//bfs�� �̿��� Ž��
		int [][] visited = new int[N][N];     // ���� ���� ��ġ�� ���� 1�� ��Ÿ��
		Queue<Location> q = new LinkedList<Location>();
		ArrayList<Point> al = new ArrayList<Point>();    //���� ���� �Ӹ����� ���������� ��ġ�� ������� ����
		
		visited[0][0] = 1;
		al.add(new Point(0, 0));
		q.offer(new Location(0,0, 0, 0, 1, 3, 0));
		
		while(!q.isEmpty()) {
			Location l = q.poll();
			
			if(!list.isEmpty() && list.get(0).sec == l.time) { // ���� L ������ 0->2, 1->3, 2->1, 3->0   ���� R������ 0->3, 1->2, 2->0, 3->1

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
				list.remove(0);   /* �� �κ� �߰� ���ؼ� Ʋ�Ⱦ��� */
				
			}
			if(l.dir == 3) {      //���������� �̵�
				//���� ���ǿ� ����Ǵ� ��� ó�� (���� �ε����� ���� ���� ���� �ε����� ���)
				if(l.sj+1 >=N) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si][l.sj+1] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. ����� ���� ���
				if(A[l.si][l.sj+1] == 0) {
					visited[l.si][l.sj+1] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si, l.sj+1));    //����Ʈ�� ���� �Ӹ��� �ش��ϰ� ����Ʈ�� ���� ���� ������ �ش��ϹǷ� ù��°�ڸ��� �����ؾ��Ѵ� ������
					al.remove(al.size()-1);
					q.offer(new Location(l.si, l.sj+1, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. ����� �ִ� ���
				if(A[l.si][l.sj+1] == 1) {
					A[l.si][l.sj+1] = 0;
					visited[l.si][l.sj+1] = 1;
					al.add(0, new Point(l.si, l.sj+1));
					q.offer(new Location(l.si, l.sj+1, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			} else if(l.dir == 2) {      //�������� �̵�
				//���� ���ǿ� ����Ǵ� ��� ó�� (���� �ε����� ���� ���� ���� �ε����� ���)
				if(l.sj-1 < 0) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si][l.sj-1] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. ����� ���� ���
				if(A[l.si][l.sj-1] == 0) {
					visited[l.si][l.sj-1] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si, l.sj-1));
					al.remove(al.size()-1);
					q.offer(new Location(l.si, l.sj-1, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. ����� �ִ� ���
				if(A[l.si][l.sj-1] == 1) {
					A[l.si][l.sj-1] = 0;
					visited[l.si][l.sj-1] = 1;
					al.add(0, new Point(l.si, l.sj-1));
					q.offer(new Location(l.si, l.sj-1, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			} else if(l.dir == 0) {      //�������� �̵�
				//���� ���ǿ� ����Ǵ� ��� ó�� (���� �ε����� ���� ���� ���� �ε����� ���)
				if(l.si-1 < 0) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si-1][l.sj] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. ����� ���� ���
				if(A[l.si-1][l.sj] == 0) {
					visited[l.si-1][l.sj] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si-1, l.sj));
					al.remove(al.size()-1);
					q.offer(new Location(l.si-1, l.sj, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. ����� �ִ� ���
				if(A[l.si-1][l.sj] == 1) {
					A[l.si-1][l.sj] = 0;
					visited[l.si-1][l.sj] = 1;
					al.add(0, new Point(l.si-1, l.sj));
					q.offer(new Location(l.si-1, l.sj, l.fi, l.fj, l.length+1, l.dir, l.time+1));
				}
			}else if(l.dir == 1) {      //�Ʒ������� �̵�
				//���� ���ǿ� ����Ǵ� ��� ó�� (���� �ε����� ���� ���� ���� �ε����� ���)
				if(l.si+1 >=N) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				if(visited[l.si+1][l.sj] == 1) {
					System.out.println(l.time+1);
					System.exit(0);
				}
				//1. ����� ���� ���
				if(A[l.si+1][l.sj] == 0) {
					visited[l.si+1][l.sj] = 1;
					visited[l.fi][l.fj] = 0;
					al.add(0, new Point(l.si+1, l.sj));
					al.remove(al.size()-1);
					q.offer(new Location(l.si+1, l.sj, al.get(al.size()-1).i, al.get(al.size()-1).j, l.length, l.dir, l.time+1));
				}
				//2. ����� �ִ� ���
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
