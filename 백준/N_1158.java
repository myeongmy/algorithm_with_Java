//���� 1158��
/*
 ����
�����۽� ������ ������ ����.

1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����. ���� ������� K��° ����� �����Ѵ�. �� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. �� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. ������ ������� ���ŵǴ� ������ (N, K)-�����۽� �����̶�� �Ѵ�. ���� ��� (7, 3)-�����۽� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.

N�� K�� �־����� (N, K)-�����۽� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� K�� �� ĭ�� ���̿� �ΰ� ������� �־�����. (1 �� K �� N �� 5,000)

���
������ ���� �����۽� ������ ����Ѵ�.
*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_1158 {
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String sentence = br.readLine();
			String[] arr = sentence.split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			int[] array = new int[N];
			int[] removed = new int[N];
			int[] result = new int[N];
			int flag = 0; // K��° ���� Ȯ���ϱ� ���� ����
			int idx = 0;
			int removedNum = 0;
			for (int i = 0; i < array.length; i++)
				array[i] = i + 1;
			while (true) {
				// ���ŵ��� ���� ���
				if (removed[idx] == 0) {
					flag++;
				}
				if (flag == K) {
					flag = 0;
					removed[idx] = 1;
					result[removedNum] = array[idx];
					removedNum++;
				}
				if (removedNum == N)
					break;
				idx = (idx + 1) % N;
			}
			System.out.print("<");
			for (int j = 0; j < result.length; j++) {
				if (j == result.length - 1)
					System.out.print(result[j]);
				else
					System.out.print(result[j] + ", ");
			}
			System.out.print(">");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	// ť�� �̿��ؼ� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String sentence = br.readLine();
			String [] arr = sentence.split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			Queue<Integer> q = new LinkedList<Integer>();
			LinkedList<Integer> result = new LinkedList<Integer>(); // ���� �����۽� ���� ���� ����Ʈ
			for(int i=1;i<=N;i++){
				q.offer(i);
			}
			
			while(!q.isEmpty()){
				for(int i=1;i<K;i++){
					q.offer(q.poll());
				}
				result.add(q.poll());
				
			}
			System.out.print("<");
			for(int i=0;i<result.size();i++){
				if(i == result.size() - 1)
					System.out.print(result.get(i));
				else
					System.out.print(result.get(i)+", ");
			}
			System.out.print(">");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
