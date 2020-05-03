//백준 1062번
//시뮬레이션 문제인줄 알았으나 브루트 포스 문제!!!

package 백준;

import java.util.*;

public class N_1062 {
	static char[] A = new char[21];
	static int[] alphabet = new int[26];
	static ArrayList<String> words = new ArrayList<String>();
	static int max = Integer.MIN_VALUE;

	static void go(int index, int selected, int M) {
		if (selected == M) {
			int result = 0;
			Label: for (int i = 0; i < words.size(); i++) {
				for (int j = 0; j < words.get(i).length(); j++) {
					if (alphabet[words.get(i).charAt(j) - 97] == 0)
						continue Label;
				}
				result++;
			}
			if (max < result)
				max = result;
			return;
		}
		if (index >= A.length)
			return;
		alphabet[A[index] - 97] = 1;
		go(index + 1, selected + 1, M);
		alphabet[A[index] - 97] = 0;

		go(index + 1, selected, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		if (K < 5) {
			System.out.println(0);
			System.exit(0);
		}

		for (int i = 0; i < N; i++)
			words.add(s.next());
		A[0] = 'b';
		A[1] = 'd';
		A[2] = 'e';
		A[3] = 'f';
		A[4] = 'g';
		A[5] = 'h';
		A[6] = 'j';
		A[7] = 'k';
		A[8] = 'l';
		A[9] = 'm';
		A[10] = 'o';
		A[11] = 'p';
		A[12] = 'q';
		A[13] = 'r';
		A[14] = 's';
		A[15] = 'u';
		A[16] = 'v';
		A[17] = 'w';
		A[18] = 'x';
		A[19] = 'y';
		A[20] = 'z';

		alphabet['a' - 97] = 1;
		alphabet['n' - 97] = 1;
		alphabet['t' - 97] = 1;
		alphabet['i' - 97] = 1;
		alphabet['c' - 97] = 1;
		go(0, 0, K - 5);
		System.out.println(max);
	}

}
