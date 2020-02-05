//���� 11403��
//DFS ����
/*����
����ġ ���� ���� �׷��� G�� �־����� ��, ��� ���� (i, j)�� ���ؼ�, i���� j�� ���� ��ΰ� �ִ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����. ��° �ٺ��� N�� �ٿ��� �׷����� ���� ����� �־�����. i��° ���� j��° ���ڰ� 1�� ��쿡�� i���� j�� ���� ������ �����Ѵٴ� ���̰�, 0�� ���� ���ٴ� ���̴�. i��° ���� i��° ���ڴ� �׻� 0�̴�.

���
�� N���� �ٿ� ���ļ� ������ ������ ������� �������� ����Ѵ�. ���� i���� j�� ���� ��ΰ� ������ i��° ���� j��° ���ڸ� 1��, ������ 0���� ����ؾ� �Ѵ�.*/

package ����;

import java.util.*;

public class N_11403 {

	static void dfs(int v, int parent, ArrayList<Integer> [] adlist, int [] c, int [][] isExist) {
		for(int a : adlist[v]) {
			if(c[a] == 0) {
				c[a] = 1;
				isExist[parent][a] = 1;
				dfs(a, parent, adlist, c, isExist);
				c[a] = 0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N];
		for (int i = 0; i < N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (s.nextInt() == 1) {
					adlist[i].add(j);
				}
			}
		}
		int [][] isExist = new int[N][N];
		for(int i=0;i<N;i++) {
			int [] c = new int[N];
			dfs(i, i, adlist, c, isExist);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(isExist[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
