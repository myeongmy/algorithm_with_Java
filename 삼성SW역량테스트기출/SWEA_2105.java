//[���� SW �����׽�Ʈ] ����Ʈ ī��
//DFS(��� ã��)����
//ó�� ���� : ����Ŭ�� ã���� �Ǵ��� �˰� Ǯ�� -> �簢���� ��쿡�� ��η� �����Ǵ� ������ ������
//�߰� ���� : �簢���� ���ϱ� ���� 4�������� ���� Ž���� ����(�簢���� ������ ������ ������ �ٲ� ������ length++�ؼ� ������ ������ 4���� �Ǵ� ��θ� Ž�� -> �ð� �ʰ�
//���� ���� : �ð� �ʰ��� �ذ��ϱ� ���ؼ��� 4���� Ž�� ���� -> �� �� �ִ� �簢���� ���ϴµ� �ߺ��� �����ϱ� ���� ���� ���� (3->2->0->1)

/*ģ����� ����Ʈ ī�� ��� �� ��ȹ�̴�.

[Fig. 1]�� ���� �� ���� ���̰� N�� ���簢�� ����� ���� ������ ����Ʈ ī�䰡 �� �ִ�.
 


�� ���� ���ڴ� �ش� ����Ʈ ī�信�� �Ȱ� �ִ� ����Ʈ�� ������ �ǹ��ϰ�

ī��� ���̿��� �밢�� �������� ������ �� �ִ� ����� �ִ�.

����Ʈ ī�� ����� ��� �� ī�信�� ����Ͽ�

[Fig. 2]�� ���� �밢�� �������� �����̰� �簢�� ����� �׸��� ����� ī��� ���ƿ;� �Ѵ�.
 
 

����Ʈ ī�� ��� �ϴ� ���� �ش� ������ ����� �� �ȴ�.

����, ģ������ ���� ������ ����Ʈ�� �ٽ� �Դ� ���� �Ⱦ��Ѵ�.

��, [Fig. 3]�� ���� ī�� ���� �߿� ���� ������ ����Ʈ�� �Ȱ� �ִ� ī�䰡 ������ �� �ȴ�.
 
 

[Fig. 4]�� ���� �ϳ��� ī�信�� ����Ʈ�� �Դ� �͵� �� �ȴ�.

 

[Fig. 5]�� ���� �Դ� ���� �ٽ� ���ư��� �͵� �� �ȴ�.
 


ģ����� ����Ʈ�� �ǵ��� ���� �������� �Ѵ�.

����Ʈ ���԰� ���ִ� ������ �� ���� ���� N�� ����Ʈ ī���� ����Ʈ ������ �Է����� �־��� ��,

������ �� ī�信�� ����Ͽ� �밢�� �������� �����̰�

���� �ٸ� ����Ʈ�� �����鼭 �簢�� ����� �׸��� �ٽ� ��������� ���ƿ��� ���,

����Ʈ�� ���� ���� ���� �� �ִ� ��θ� ã��, �� ���� ����Ʈ ���� �������� ����ϴ� ���α׷��� �ۼ��϶�.

����, ����Ʈ�� ���� �� ���� ��� -1�� ����Ѵ�.


[����]

�� ���� ���� N�� 4�� ������ ����Ʈ ī�䰡 [Fig. 6]�� ���� �ִٰ� ��������.
 


����Ʈ ī�� ��� ������ ���� [Fig. 7]�� ���� 5������ ���� �� �ִ�.

(����� ���� ���� ������ �ٸ� �� ������, ����Ʈ ī�� ������ ��ΰ� �׸��� �簢�� ����� 5���� �� �ϳ��̴�.)
 

[Fig. 7]
 
�� �߿� ����Ʈ�� ���� ���� ���� �� �ִ� ���� ���� ���� ����Ʈ�� ������ 6���̴�.

����, ������ 6�� �ȴ�.


[�������]

1. �ð����� : �ִ� 50�� �׽�Ʈ ���̽��� ��� ����ϴ� �� C/C++/Java ��� 3��

2. ����Ʈ ī�䰡 ���ִ� ������ �� ���� ���� N�� 4 �̻� 20 ������ �����̴�. (4 �� N �� 20)

3. ����Ʈ ������ ��Ÿ���� ���� 1 �̻� 100 ������ �����̴�.


[�Է�]

�Է��� �� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־�����, �� ���� �ٺ��� T���� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ����Ʈ ī�䰡 ���ִ� ������ �� ���� ���� N�� �־�����.

�� ���� N �ٿ��� N * N ũ���� ����Ʈ ī�信�� �Ȱ� �ִ� ����Ʈ ������ ���� ������ �־�����.


[���]

�׽�Ʈ ���̽� ������ŭ T���� �ٿ� ������ �׽�Ʈ ���̽��� ���� ���� ����Ѵ�.

�� ���� "#t"�� �����ϰ� ������ �ϳ� �� ���� ������ ����Ѵ�. (t�� 1���� �����ϴ� �׽�Ʈ ���̽��� ��ȣ�̴�)

����ؾ� �� ������ ������ ��� �� ����Ʈ�� ���� ���� ���� ���� ����Ʈ �� �̴�.

����, ����Ʈ�� ���� �� ���� ��� ������ -1�̴�.*/

package �ＺSW�����׽�Ʈ����;

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
	static int length = 0;     // ������ ����
	static ArrayList<Dessert> list = new ArrayList<Dessert>();
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int i, int j, int[][] c, int[][] A, int dir) {
		if(length == 4) {
			int flag = 0;
			int flag1 = 0;
			
			for(int k=0;k<dx.length;k++) {    //������̶� 1�� ���̳��� ���� �´��� Ȯ��
				if(list.get(0).i+dx[k] == list.get(list.size()-1).i && list.get(0).j+dy[k] == list.get(list.size()-1).j)
					flag1 = 1;
			}
			int [] arr = new int[102];
			for(int k=0;k<list.size();k++) {   //�ߺ��� ��Ұ� ������ Ȯ��
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
		
		if(dir == -1) {   //ó�� ���� ���
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
			//3���� ���� ���
			if(i+dx[3] >= 0 && i+dx[3] < A.length && j+dy[3] >= 0 && j+dy[3] < A.length) {
				if(c[i+dx[3]][j+dy[3]] == 0) {
					c[i+dx[3]][j+dy[3]] = 1;
					list.add(new Dessert(i+dx[3], j+dy[3], A[i+dx[3]][j+dy[3]]));
					dfs(i+dx[3], j+dy[3], c, A, 3);
					list.remove(list.size()-1);
					c[i+dx[3]][j+dy[3]] = 0;
				}
			}
			//2�� ���� ���
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
			//2�ΰ��� ���
			if(i+dx[2] >= 0 && i+dx[2] < A.length && j+dy[2] >= 0 && j+dy[2] < A.length) {
				if(c[i+dx[2]][j+dy[2]] == 0) {
					c[i+dx[2]][j+dy[2]] = 1;
					list.add(new Dessert(i+dx[2], j+dy[2], A[i+dx[2]][j+dy[2]]));
					dfs(i+dx[2], j+dy[2], c, A, 2);
					list.remove(list.size()-1);
					c[i+dx[2]][j+dy[2]] = 0;
				}
			}
			//0���� ���� ���
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
			//0���� ���� ���
			if(i+dx[0] >= 0 && i+dx[0] < A.length && j+dy[0] >= 0 && j+dy[0] < A.length) {
				if(c[i+dx[0]][j+dy[0]] == 0) {
					c[i+dx[0]][j+dy[0]] = 1;
					list.add(new Dessert(i+dx[0], j+dy[0], A[i+dx[0]][j+dy[0]]));
					dfs(i+dx[0], j+dy[0], c, A, 0);
					list.remove(list.size()-1);
					c[i+dx[0]][j+dy[0]] = 0;
				}
			}
			//1�� ���� ���
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
				int[][] c = new int[N][N]; // �湮 ���� ����
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
