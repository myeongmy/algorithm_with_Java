//백준 1325번
//DFS 문제
//이 문제는 java로 컴파일하면 시간 초과, java 11로 컴파일하면 통과되었다. 이유를 찾아보기!
/*문제
해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.

이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.

이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

출력
첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.*/

package 백준;

import java.util.*;
import java.io.*;

public class N_1325 {
	static int connectedCom = 0;

	static void dfs(int v, ArrayList<Integer>[] adlist, int[] c) {
		c[v] = 1;
		connectedCom++;

		for (int a : adlist[v]) {
			if (c[a] == 0) {
				dfs(a, adlist, c);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);

			ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adlist[i] = new ArrayList<Integer>();
			for (int i = 0; i < M; i++) {
				String[] arr1 = br.readLine().split(" ");
				int a = Integer.parseInt(arr1[0]);
				int b = Integer.parseInt(arr1[1]);
				adlist[b].add(a);
			}
			int[] num = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int[] c = new int[N + 1];
				connectedCom = 0;
				dfs(i, adlist, c);
				num[i] = connectedCom;
			}
			int max = 0;
			for (int i = 1; i <= N; i++) {
				if (max < num[i])
					max = num[i];
			}
			for (int i = 1; i <= N; i++) {
				if (num[i] == max)
					System.out.print(i + " ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
