//백준 10253번 헨리
//시뮬레이션

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10253 {
	static int lcm(int b, int x) {
		int gcd = gcd(b, x);
		return (b * x) / gcd;
	}

	static int gcd(int b, int x) {
		if (x == 0)
			return b;

		return gcd(x, b % x);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			while (true) {
				// 단위 분모 x 구하기
				int x = 0;

				if (a == 1)
					x = b;
				else
					x = b / a + 1;

				// 분수 뺄셈 진행
				if (b == x) {
					System.out.println(x);
					break;
				}
				int tempB = lcm(b, x);
				int tempA = a * (tempB / b) - (tempB / x);

				if (gcd(tempB, tempA) == 1) {
					a = tempA;
					b = tempB;
				} else {
					a = tempA / gcd(tempA, tempB);
					b = tempB / gcd(tempA, tempB);
				}

			}
		}

	}

}
