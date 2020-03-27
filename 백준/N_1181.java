//백준 1181번
//정렬 문제 풀이
/*문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.*/

package 백준;

import java.util.*;
import java.io.*;

public class N_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];

			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String a, String b) {
					if (a.length() < b.length()) {
						return -1;
					} else if (a.length() > b.length()) {
						return 1;
					} else {
						return a.compareTo(b);
		
					}
				}
			});

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if(i != 0 && arr[i].equals(arr[i-1])) continue;
					sb.append(arr[i]).append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
