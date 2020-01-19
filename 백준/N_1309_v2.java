//백준 1309번
/*문제
어떤 동물원에 가로로 두칸 세로로 N칸인 아래와 같은 우리가 있다.



이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다. 이 동물원 조련사는 사자들의 배치 문제 때문에 골머리를 앓고 있다.

동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자. 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.

입력
첫째 줄에 우리의 크기 N(1≤N≤100,000)이 주어진다.

출력
첫째 줄에 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력하여라.*/

package 백준;

import java.util.Scanner;

public class N_1309_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] d = new long[N + 1];
		long[] s = new long[N + 1];

		d[0] = 1;
		d[1] = 2;
		s[0] = 1;
		s[1] = 3;

		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 2 * s[i - 2];
			s[i] = s[i - 1] + d[i];

			d[i] %= 9901;
			s[i] %= 9901;
		}
		System.out.println(s[N]);

	}

}
