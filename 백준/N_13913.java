//���� 13913��
/*����
�����̴� ������ ���ٲ����� �ϰ� �ִ�. �����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�, ������ �� K(0 �� K �� 100,000)�� �ִ�. �����̴� �Ȱų� �����̵��� �� �� �ִ�. ����, �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�. �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵��ϰ� �ȴ�.

�����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù ��° �ٿ� �����̰� �ִ� ��ġ N�� ������ �ִ� ��ġ K�� �־�����. N�� K�� �����̴�.

���
ù° �ٿ� �����̰� ������ ã�� ���� ���� �ð��� ����Ѵ�.

��° �ٿ� ��� �̵��ؾ� �ϴ��� �������� ������ ����Ѵ�.*/

package ����;
import java.util.*;

public class N_13913 {
	static void go(int K, int [] parent) {
		if(K == -1)
			return;
		go(parent[K], parent);
		System.out.print(K+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		
		//bfs
		int [] c = new int[200000];
		int [] parent = new int[200000];
		Queue<Integer> q = new LinkedList<Integer>();
		c[N] = 1;
		parent[N] = -1;
		q.offer(N);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			int [] dx= {-1, 1, a};
			for(int i=0;i<dx.length;i++) {
				if(a+dx[i] >= 0 && a+dx[i] < 200000) {
					if(c[a+dx[i]] == 0) {
						q.offer(a+dx[i]);
						c[a+dx[i]] = c[a] + 1;
						parent[a+dx[i]] = a;
					}
				}
			}
			if(c[K] != 0)
				break;
		}
		System.out.println(c[K] - 1);
		go(K, parent);
	}

}
