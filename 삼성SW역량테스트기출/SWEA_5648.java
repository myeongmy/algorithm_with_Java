//[���� SW�����׽�Ʈ] ���� �Ҹ� �ùķ��̼�
//�ùķ��̼� ����
//ó�� ���� - �޸� �ʰ� (�׽�Ʈ ���̽����� array �迭�� �����ϴٺ��� �޸� �ʰ��� ����� ���Ҵ�. static���� �����Ͽ� �ذ�)
//�� ��° ���� - �ð� �ʰ� (0.5�ʿ��� ������ ��츦 ����ϱ� ���� �ٷ� �� ��ǥ�� �ִ� ��쿡�� ������ �浹�� �Ͼ ������ �����Ͽ� �ݺ����� �� �� �װ͵� ���� üũ����)
//pass�� �ڵ� - 0.5�ʿ��� ������ ��츦 ����ϱ� ���� ��ǥ���� *2�ؼ� 4000 by 4000�� �迭�� ����. �׸��� map array���� ���� ��ġ�� ������ ���� �����ϰ� ť���� ���� ������ ���� ���� ��ġ�� ������ ���� ��ġ���� �ʴ� ��� �浹�� �Ͼ ������ �����ߴ�.

/*���ڷ� �����ҿ��� �ٹ��ϴ� ����̴�, �����ҿ��� �߻��ϴ� �������� �̸� ����ϱ� ���� ���ڵ��� �������� �ùķ��̼� �ϴ� ���α׷��� ������� �Ѵ�.

 

���ڵ��� 2���� ��鿡�� �̵��ϸ� �� �� �̻��� ���ڰ� �浹 �� ��� �浹�� ���ڵ��� ���� ������ �������� ��� �����ϰ� �Ҹ�ȴ�.

 

������ �������� ������ ����.
 

1. ������ ���� ��ġ�� 2���� ������ [x, y] �̴�.

2. ���ڴ� ���� ������ �����̴� ������ ������ �ִ�. (�����¿� 4����)

 - ��: y �� �����ϴ� ����

 - ��: y �� �����ϴ� ����

 - ��: x �� �����ϴ� ����

 - ��: x �� �����ϴ� ����

3. ��� ���ڵ��� �̵��ӵ��� �����ϴ�. ��, 1�ʿ� 1��ŭ�� �Ÿ��� �̵��Ѵ�.

4. ��� ���ڵ��� ���� ��ġ���� ���ÿ� �̵��� �����Ѵ�.
5. �� �� �̻��� ���ڰ� ���ÿ� �浹 �� ��� �浹�� ���ڵ��� ��� ������ �������� �����ϰ� �Ҹ�ȴ�.
 

           
                                    [�׸�-1]

 

[�׸�-1] �� ���� ���ڵ��� [x, y] ��ġ�� �̵������� �־����� �� ���ڵ��� ���� �������� 1 �̶�� �����غ���. (���� �Է¿��� ���ڵ��� ���� �������� ���� �ٸ� �� �ִ�.)

�浹�� ���ڵ��� �Ҹ��ϸ鼭 �����ϴ� �������� ������ ����.

1�� �Ŀ� I, J ���ڰ� �浹 �� �Ҹ��ϸ鼭 2 ������ ����
1.5�� �Ŀ� A, B ���ڰ� �浹 �� �Ҹ��ϸ鼭 2 ������ ����
2�� �Ŀ� D, E, G, H ���ڰ� �浹 �� �Ҹ��ϸ鼭 4 ������ ����
3�� �Ŀ� M, N ���ڰ� �浹 �� �Ҹ��ϸ鼭 2 ������ ����
[�׸�-1]�� ��� �ð��� �귯�� ���� C, F, K, L �� ������ �浹���� �ʾ� �Ҹ���� �ʴ´�.

���� ���ڵ��� �Ҹ�Ǹ鼭 �����ϴ� �������� ������ 10 �̴�.

 

N ���� ���ڵ��� [x, y] ��ġ, �̵� ����, ���� �������� �־��� �� ���ڵ��� �Ҹ�Ǹ鼭 �����ϴ� �������� ������ ���ϴ� ���α׷��� �ۼ��϶�.

 

 

[���� ����]
 

1. ���ڵ��� �� N �� 1,000�� �����̴�. (1��N��1,000)

2. �� ���ڵ��� ���� ������ K �� 1 �̻� 100 �����̴�. (1��K��100)

3. ���ڵ��� ó�� ��ġ [x, y] �� -1,000 �̻� 1,000 ������ ������ �־�����. (-1,000��x,y��1,000)

4. ���ڵ��� 2���� ��� ������ �����̸� ���ڵ��� ������ �� �ִ� ��ǥ�� ������ ������ ����.

5. ���ڵ��� �̵� ������ ��(0), ��(1), ��(2), ��(3)�� �־�����.

6. ���ڵ��� ���ÿ� 1�ʿ� �̵� �������� 1��ŭ �̵��Ѵ�.

7. ���ڵ��� ���� ��ġ�� ���� �ߺ����� �ʴ´�.

8. ���ڵ��� 2�� �̻��� ���ڵ��� ���� �浹�� ��� ������ �������� �����ϸ鼭 �ٷ� �Ҹ�ȴ�.

9. ���ڵ��� �̵� ������ ó���� �־��� ���⿡�� �ٲ��� �ʴ´�.

10. ���ڵ��� �浹�Ͽ� �Ҹ�Ǹ� ����Ǵ� �������� �ٸ� ������ ��ġ�� �̵� ���⿡ ������ ���� �ʴ´�.

 

[�Է�]
 

�Է��� ���� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־�����.

�� ���� �ٺ��ʹ� �� �׽�Ʈ ���̽��� �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� ���ڵ��� �� N�� �־�����.

���� N���� �ٿ��� ���ڵ��� x ��ġ, y ��ġ, �̵� ����, ���� ������ K�� �־�����.

���ڵ��� �̵� ������ ��(0), ��(1), ��(2), ��(3)�� �־�����.

 

[���]
 

�׽�Ʈ ���̽� T�� ���� ����� ��#T���� ���, ����Ǵ� �������� ������ ����Ѵ�. (T�� �׽�Ʈ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�. )*/

package �ＺSW�����׽�Ʈ����;

import java.io.*;
import java.util.*;

class Atom {
	int i;
	int j;
	int dir;
	int energy;

	Atom(int i, int j, int dir, int energy) {
		this.i = i;
		this.j = j;
		this.dir = dir;
		this.energy = energy;
	}
}

public class SWEA_5648 {
	static int [][] array = new int[4001][4001];    //�޸� �ʰ��� ���� ���� static���� ������ �Ͽ��� ��ǥ ������ -1000~1000�� ���� ����� +1000�� �Ͽ� 0~2000 �迭�� ���! �׸��� 0.5�ʿ��� ������ ��츦 ����ϱ� ���� *2�� ���־���.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				Queue<Atom> q = new LinkedList<Atom>();
				int min_i = Integer.MAX_VALUE;
				int min_j = Integer.MAX_VALUE;
				int max_i = Integer.MIN_VALUE;
				int max_j = Integer.MIN_VALUE; 

				for (int j = 0; j < N; j++) {
					String[] arr = br.readLine().split(" ");
					q.offer(new Atom((Integer.parseInt(arr[0]) + 1000)*2, (Integer.parseInt(arr[1])+ 1000)*2,
							Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
					array[(Integer.parseInt(arr[0])+ 1000)*2][(Integer.parseInt(arr[1])+ 1000)*2] = Integer.parseInt(arr[3]);
					
					if (min_i > (Integer.parseInt(arr[0]) + 1000)*2)
						min_i = (Integer.parseInt(arr[0]) + 1000)*2;
					if (max_i < (Integer.parseInt(arr[0]) + 1000)*2)
						max_i = (Integer.parseInt(arr[0]) + 1000)*2;
					if (min_j > (Integer.parseInt(arr[1])+ 1000)*2)
						min_j = (Integer.parseInt(arr[1])+ 1000)*2;
					if (max_j < (Integer.parseInt(arr[1])+ 1000)*2)
						max_j = (Integer.parseInt(arr[1])+ 1000)*2;
				}
				int result = 0;
					while (!q.isEmpty()) {
						Atom a = q.poll();
						
						if(array[a.i][a.j] != a.energy) {   //�浹�� �Ͼ ���
							result += array[a.i][a.j];
							array[a.i][a.j] = 0;
							continue;
						}
						if (a.dir == 0) {
							if (a.j + 1 > max_j) {
								array[a.i][a.j] = 0;
								continue;
							}
								
							if(array[a.i][a.j+1] == 0) {
								array[a.i][a.j+1] = a.energy;
								q.offer(new Atom(a.i, a.j+1, a.dir, a.energy));
							}else {
								array[a.i][a.j+1] += a.energy;
							}
						} else if (a.dir == 1) {
							if (a.j - 1 < min_j) {
								array[a.i][a.j] = 0;
								continue;
							}
							
							if(array[a.i][a.j-1] == 0) {
								array[a.i][a.j-1] = a.energy;
								q.offer(new Atom(a.i, a.j-1, a.dir, a.energy));
							}else {
								array[a.i][a.j-1] += a.energy;
							}
						} else if (a.dir == 2) {
							if (a.i - 1 < min_i) {
								array[a.i][a.j] = 0;
								continue;
							}

							if(array[a.i-1][a.j] == 0) {
								array[a.i-1][a.j] = a.energy;
								q.offer(new Atom(a.i-1, a.j, a.dir, a.energy));
							}else {
								array[a.i-1][a.j] += a.energy;
							}
						} else if (a.dir == 3) {
							if (a.i + 1 > max_i) {
								array[a.i][a.j] = 0;
								continue;
							}
							

							if(array[a.i+1][a.j] == 0) {
								array[a.i+1][a.j] = a.energy;
								q.offer(new Atom(a.i+1, a.j, a.dir, a.energy));
							}else {
								array[a.i+1][a.j] += a.energy;
							}
						}
						array[a.i][a.j] = 0;
					}
					

				
				System.out.println("#" + (i + 1) + " " + result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
