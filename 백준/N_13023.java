//���� 13023��
/*����
BOJ �˰��� ķ������ �� N���� �����ϰ� �ִ�. ������� 0������ N-1������ ��ȣ�� �Ű��� �ְ�, �Ϻ� ������� ģ���̴�.

������ ������ ���� ģ�� ���踦 ���� ��� A, B, C, D, E�� �����ϴ��� ���غ����� �Ѵ�.

A�� B�� ģ����.
B�� C�� ģ����.
C�� D�� ģ����.
D�� E�� ģ����.
���� ���� ģ�� ���谡 �����ϴ��� ���ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����� �� N (5 �� N �� 2000)�� ģ�� ������ �� M (1 �� M �� 2000)�� �־�����.

��° �ٺ��� M���� �ٿ��� ���� a�� b�� �־�����, a�� b�� ģ����� ���̴�. (0 �� a, b �� N-1, a �� b) ���� ģ�� ���谡 �� �� �̻� �־����� ���� ����.

���
������ ���ǿ� �´� A, B, C, D, E�� �����ϸ� 1�� ������ 0�� ����Ѵ�.*/

package ����;

import java.util.ArrayList;
import java.io.*;

public class N_13023 {
	static boolean[] c = new boolean[2001];
	static int is_possible = 0;

	static void go(int v, int selected, ArrayList<Integer>[] adlist) {
		if (selected == 5) {
			is_possible = 1;
			System.out.println(1);
			System.exit(0);
			return;
		}
		for (int a : adlist[v]) {
			if (c[a] == true)
				continue;
			c[a] = true;
			go(a, selected + 1, adlist);
			c[a] = false;
		}
	}

	static void dfs(int v, int selected, ArrayList<Integer>[] adlist) {
		if (selected == 5) {
			System.out.println(1);
			System.exit(0);
		}
		if (c[v])
			return;
		c[v] = true;
		for (int a : adlist[v]) {
			if (c[a] == false)
				dfs(a, selected + 1, adlist);
		}
		c[v] = false; // depth�� ���Ϸ��� �� �κ��� ������ dfs�� �ٸ��� �߰��ؾ���!!
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N];
			for (int i = 0; i < adlist.length; i++) {
				adlist[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				String[] array = br.readLine().split(" ");
				int a = Integer.parseInt(array[0]);
				int b = Integer.parseInt(array[1]);
				adlist[a].add(b);
				adlist[b].add(a);
			}
			for (int i = 0; i < N; i++) {
				// go(i, 0, adlist);
				dfs(i, 1, adlist);
			}
			bw.write("" + is_possible);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
