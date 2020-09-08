//백준 14657번 준오는 최종인재야!!
//트리의 지름

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_14657 {
	static class Node {
		int num; // 노드 번호
		int weight; // 가중치

		Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

	static void dfs(int v, int depth, int weightSum, int[] c) {
		c[v] = 1;
		if (max_depth < depth) {
			max_depth = depth;
			result = v;
			weight = weightSum;
		} else if (max_depth == depth && weight > weightSum) {
			weight = weightSum;
			result = v;
		}
		for (Node n : adlist[v]) {
			if (c[n.num] == 0)
				dfs(n.num, depth + 1, weightSum + n.weight, c);
		}
	}

	static void dfs1(int v, int depth, int weightSum, int[] c) {
		c[v] = 1;
		if (max_depth < depth) {
			max_depth = depth;
			result = weightSum;
		} else if (max_depth == depth && result > weightSum) {
			result = weightSum;
		}
		for (Node n : adlist[v]) {
			if (c[n.num] == 0)
				dfs1(n.num, depth + 1, weightSum + n.weight, c);
		}
	}

	static ArrayList<Node>[] adlist;
	static int max_depth = Integer.MIN_VALUE;
	static int result = 0;
	static int weight = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 문제의 수
			int T = Integer.parseInt(input[1]);
			adlist = (ArrayList<Node>[]) new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adlist[i] = new ArrayList<Node>();

			for (int i = 0; i < N - 1; i++) {
				String[] arr = br.readLine().split(" ");
				adlist[Integer.parseInt(arr[0])].add(new Node(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
				adlist[Integer.parseInt(arr[1])].add(new Node(Integer.parseInt(arr[0]), Integer.parseInt(arr[2])));
			}

			// 임의의 한 점에서 가장 멀리 떨어진 정점 중에 가중치 합이 가장 짧은 경로 구하기
			int[] c = new int[N + 1];
			dfs(1, 1, 0, c);

			// 위에서 구한 정점에서 가장 멀리 떨어진 정점 중에서 가장 짧은 경로 구하기
			c = new int[N + 1];
			max_depth = Integer.MIN_VALUE;
			dfs1(result, 1, 0, c);

			if (result % T != 0)
				System.out.println(result / T + 1);
			else
				System.out.println(result / T);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
