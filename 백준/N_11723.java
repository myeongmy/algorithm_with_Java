//백준 11723번
/*문제
비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다. 
입력
첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.

둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

출력
check 연산이 주어질때마다, 결과를 출력한다.*/

package 백준;

import java.io.*;

public class N_11723 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int M = Integer.parseInt(br.readLine());
			int S = 0;
			for (int i = 0; i < M; i++) {
				String command = br.readLine();
				if (command.startsWith("add")) {
					String[] arr = command.split(" ");
					S = S | (1 << (Integer.parseInt(arr[1]) - 1));
				} else if (command.startsWith("remove")) {
					String[] arr = command.split(" ");
					S = S & ~(1 << (Integer.parseInt(arr[1]) - 1));
				} else if (command.startsWith("check")) {
					String[] arr = command.split(" ");
					if ((S & (1 << (Integer.parseInt(arr[1]) - 1))) != 0) {
						bw.write("1");
						bw.newLine();
					} else {
						bw.write("0");
						bw.newLine();
					}

				} else if (command.startsWith("toggle")) {
					String[] arr = command.split(" ");
					S = S ^ (1 << (Integer.parseInt(arr[1]) - 1));
				} else if (command.startsWith("all")) {
					S = (1 << 20) - 1;
				} else if (command.startsWith("empty")) {
					S = 0;
				}

			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
