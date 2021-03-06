//백준 15661번
/*문제
오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 축구를 하기 위해 모인 사람은 총 N명이다. 이제 스타트 팀과 링크 팀으로 사람들을 나눠야 한다. 두 팀의 인원수는 같지 않아도 되지만, 한 명 이상이어야 한다.

BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

N=4이고, S가 아래와 같은 경우를 살펴보자.

i\j	1	2	3	4
1	 	1	2	3
2	4	 	5	6
3	7	1	 	2
4	3	4	5	 
예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.

스타트 팀: S12 + S21 = 1 + 4 = 5
링크 팀: S34 + S43 = 2 + 5 = 7
1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.

스타트 팀: S13 + S31 = 2 + 7 = 9
링크 팀: S24 + S42 = 6 + 4 = 10
축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.

입력
첫째 줄에 N(4 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다. 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.*/

package 백준;

import java.io.*;
import java.util.*;

public class N_15661 {
	static boolean[] result = new boolean[21];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> notlist = new ArrayList<Integer>();
	static int min = 1000000;

	static void go(int index, int selected, int N, int M, int[][] A) {
		if (selected == M) {
			for (int i = 0; i < N; i++) {
				if (result[i] == true)
					list.add(i);
				else
					notlist.add(i);
			}
			int sum1 = 0;
			int sum2 = 0;
			Label: for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (list.size() == 1)
						break Label;
					sum1 += A[list.get(i)][list.get(j)];
				}

			}

			Label: for (int i = 0; i < notlist.size(); i++) {
				for (int j = 0; j < notlist.size(); j++) {
					if (notlist.size() == 1)
						break Label;
					sum2 += A[notlist.get(i)][notlist.get(j)];
				}

			}
			if (min > Math.abs(sum1 - sum2)) {
				min = Math.abs(sum1 - sum2);
			}
			list.clear();
			notlist.clear();
			return;
		}
		if (index == N)
			return;
		result[index] = true;
		go(index + 1, selected + 1, N, M, A);
		result[index] = false;
		go(index + 1, selected, N, M, A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] A = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					A[i][j] = Integer.parseInt(arr[j]);
			}
			for (int M = 1; M < N; M++)
				go(0, 0, N, M, A);
			System.out.println(min);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
