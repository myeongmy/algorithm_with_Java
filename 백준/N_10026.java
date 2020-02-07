//���� 10026��
//DFS ����
/*����
���ϻ����� �������� �ʷϻ��� ���̸� ���� ������ ���Ѵ�. ����, ���ϻ����� ����� ���� �׸��� �ƴ� ����� ���� �׸����� �� �ٸ� �� �ִ�.

ũ�Ⱑ N��N�� �׸����� �� ĭ�� R(����), G(�ʷ�), B(�Ķ�) �� �ϳ��� ��ĥ�� �׸��� �ִ�. �׸��� �� ���� �������� �������� �ִµ�, ������ ���� ������ �̷���� �ִ�. ��, ���� ������ �����¿�� ������ �ִ� ��쿡 �� ���ڴ� ���� ������ ���Ѵ�. (������ ���̸� ���� ������ ���ϴ� ��쵵 ���� �����̶� �Ѵ�)

���� ���, �׸��� �Ʒ��� ���� ��쿡

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
���ϻ����� �ƴ� ����� ���� �� ������ ���� �� 4���̴�. (���� 2, �Ķ� 1, �ʷ� 1) ������, ���ϻ����� ����� ������ 3�� �� �� �ִ�. (����-�ʷ� 2, �Ķ� 1)

�׸��� �Է����� �־����� ��, ���ϻ����� ����� ���� ���� �ƴ� ����� ���� �� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. (1 �� N �� 100)

��° �ٺ��� N�� �ٿ��� �׸��� �־�����.

���
���ϻ����� �ƴ� ����� ���� ���� ������ ������ ���ϻ����� ����� ���� ���� ������ ���� �������� ������ ����Ѵ�.*/

package ����;
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
