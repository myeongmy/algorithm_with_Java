//백준 13023번
/*문제
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

출력
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.*/

package 백준;

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
		c[v] = false; // depth를 구하려면 이 부분을 기존의 dfs와 다르게 추가해야함!!
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
