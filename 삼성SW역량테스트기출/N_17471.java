//���� 17471��(�Ը��Ǵ���)
//���Ʈ ������ DFS�� ���� ����
/*����
���ؽ��� ���� �ֹ����� ���� �� �Ⱓ �Ը��Ǵ����� ���ؼ� �ڽ��� �翡�� �����ϰ� ���ű��� ȹ���ߴ�. ������ �Ƿ��� ������ �ֹ����� �Ƿ��� �ſ� �δ��ϰ� ����߰�, ������� ���� �̸��� ���ؽ÷� �����ߴ�. �̹� ���ſ����� �ִ��� �����ϰ� ���ű��� ȹ���Ϸ��� �Ѵ�.

���ؽô� N���� �������� �������� �ְ�, ������ 1������ N������ ��ȣ�� �Ű��� �ִ�. ������ �� ���� ���ű��� ������ �ϰ�, �� ������ �� ���ű� �� �ϳ��� ���ԵǾ�� �Ѵ�. ���ű��� ������ ��� �ϳ� �����ؾ� �ϰ�, �� ���ű��� ���ԵǾ� �ִ� ������ ��� ����Ǿ� �־�� �Ѵ�. ���� A���� ������ ������ ���ؼ� ���� B�� �� �� ���� ��, �� ������ ����Ǿ� �ִٰ� �Ѵ�. �߰��� ���ϴ� ������ ������ 0�� �̻��̾�� �ϰ�, ��� ���� ���ű��� ���Ե� �����̾�� �Ѵ�.

�Ʒ� �׸��� 6���� ������ �ִ� ���̰�, ������ ������ ������ ����Ǿ� �ִ�.



�Ʒ��� ���ؽø� �� ���ű��� ���� 4���� ����̸�, ������ ����� �Ұ����� ����� ���� �����̴�.

			
������ ���

[1, 3, 4]�� [2, 5, 6]���� �������� �ִ�.

������ ���

[1, 2, 3, 4, 6]�� [5]�� �������� �ִ�.

�Ұ����� ���

[1, 2, 3, 4]�� [5, 6]���� �������� �ִµ�, 5�� 6�� ����Ǿ� ���� �ʴ�.

�Ұ����� ���

�� ���ű��� ��� �ϳ��� ������ �����ؾ� �Ѵ�.

�����ϰ� ���ű��� ������ ���� �� ���ű��� ���Ե� �α��� ���̸� �ּҷ� �Ϸ��� �Ѵ�. ���ؽ��� ������ �־����� ��, �α� ������ �ּڰ��� ���غ���.

�Է�
ù° �ٿ� ������ ���� N�� �־�����. ��° �ٿ� ������ �α��� 1�� �������� N�� �������� ������� �־�����. �α��� �������� ���еǾ��� �ִ�.

��° �ٺ��� N���� �ٿ� �� ������ ������ ������ ������ �־�����. �� ������ ù ��° ������ �� ������ ������ ������ ���̰�, ���� ������ ������ ��ȣ�� �־�����. ��� ���� ������ ���еǾ��� �ִ�.

���� A�� ���� B�� �����ϸ� ���� B�� ���� A�� �����ϴ�. ������ ������ ���� ���� �ִ�.

���
ù° �ٿ� ���ؽø� �� ���ű��� �������� ��, �� ���ű��� �α� ������ �ּڰ��� ����Ѵ�. �� ���ű��� ���� �� ���� ��쿡�� -1�� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

public class N_17471 {
	static ArrayList<Integer> first = new ArrayList<Integer>();
	static ArrayList<Integer> second = new ArrayList<Integer>();
	static int min = 100000;

	static void dfs(int v, ArrayList<Integer>[] adlist, int[] c, ArrayList<Integer> result, int or) {
		c[v] = 1;
		result.add(v);

		for (int a : adlist[v]) {
			if (c[a] == 0) {
				if(or == 0 && first.contains(a))
					dfs(a, adlist, c, result, 0);
				if(or == 1 && second.contains(a))
					dfs(a, adlist, c, result, 1);
			}
				
		}
	}

	static void go(int index, int[] list, ArrayList<Integer>[] adlist) {
		if (index == list.length) {
			if (first.size() == 0 || second.size() == 0)
				return;
			//first ����Ʈ ���� ���� �˻�
			ArrayList<Integer> result= new ArrayList<Integer>();
			int [] c = new int[list.length];
			dfs(first.get(0), adlist, c, result, 0);
			if(result.size() != first.size()) return;
			//second ����Ʈ ���� ���� �˻�
			result.clear();
			int [] c1 = new int[list.length];
			dfs(second.get(0), adlist, c, result, 1);
			if(result.size() != second.size()) return;
			
			int firstNum = 0;
			int secondNum = 0;
			
			//first ����Ʈ �α� �� ���
			for(int i=0;i<first.size();i++)
				firstNum += list[first.get(i)];
			//second ����Ʈ �α� �� ���
			for(int i=0;i<second.size();i++)
				secondNum += list[second.get(i)];
			if(min > Math.abs(firstNum - secondNum))
				min = Math.abs(firstNum - secondNum);
			return;
		}
		first.add(index);
		go(index + 1, list, adlist);
		first.remove(first.size() - 1);

		second.add(index);
		go(index + 1, list, adlist);
		second.remove(second.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] list = new int[N + 1]; // �� ���� �� �α� ���� ������ ����Ʈ
		for (int i = 1; i <= N; i++)
			list[i] = s.nextInt();

		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<Integer>();
			int iter = s.nextInt();
			for (int j = 0; j < iter; j++) {
				adlist[i].add(s.nextInt());
			}
		}

		// ����������(���� �̿�)
		go(1, list, adlist);
		if (min == 100000)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
