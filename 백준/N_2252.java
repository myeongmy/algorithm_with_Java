//백준 2252번 줄 세우기
//위상정렬(Topology Sort)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class N_2252 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 정점의 개수
		int M = Integer.parseInt(input[1]); // 간선의 개수

		int[] indegree = new int[N + 1]; // 각 정점의 진입 차수 저장
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1]; // 간선 저장
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			String[] arr = br.readLine().split(" ");
			adlist[Integer.parseInt(arr[0])].add(Integer.parseInt(arr[1]));
			indegree[Integer.parseInt(arr[1])]++;
		}

		// 위상 정렬
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) { // 진입 차수가 0인 정점 큐에 넣기
			if (indegree[i] == 0)
				q.offer(i);
		}

		for (int i = 1; i <= N; i++) { // 큐에서 n번 꺼내면 위상정렬 완료!
			int vertex = q.poll();
			System.out.print(vertex + " ");

			for (int j = 0; j < adlist[vertex].size(); j++) {
				indegree[adlist[vertex].get(j)]--;
				if (indegree[adlist[vertex].get(j)] == 0)
					q.offer(adlist[vertex].get(j));
			}
		}
	}

}
