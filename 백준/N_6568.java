//백준 6568번 귀로 반 로썸은 크리스마스날 심심하다고 파이썬을 만들었다
//구현(비트 연산자)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_6568 {
	static void binary(int a) {
		if (a == 0)
			return;

		binary(a / 2);
		System.out.print(a % 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = "";
			
			Label: while (true) {
				int[] memory = new int[32];

				for (int i = 0; i < 32; i++) {
					str = br.readLine();
					
					if (str.length() < 2) {
						break Label;
					}

					int pow = 1;
					int converted = 0;
					for (int j = str.length() - 1; j >= 0; j--) { // 이진수를 십진수로 변환
						converted += (str.charAt(j) - '0') * pow;
						pow *= 2;
					}

					memory[i] = converted;
				}

				int pc = 0;
				int adder = 0;

				while (true) {
					// 명령어 불러오기
					int result = memory[pc];

					// 명령어 해독하기
					int oper = result >> 5;
					int val = result - oper * 32;

					// pc 증가
					pc++;
					if ((pc >> 8) != 0) {
						pc = pc - ((pc >> 8) * 256);
					}

					// 명령어 실행
					if (oper == 0) {
						memory[val] = adder;

					} else if (oper == 1) {
						adder = memory[val];

						if ((adder >> 8) != 0) { // 누산기 값이 8비트를 초과한 경우
							adder = adder - ((adder >> 8) * 256);
						}
					} else if (oper == 2) {
						if (adder == 0) {
							pc = val;
						}
					} else if (oper == 3) {

					} else if (oper == 4) {
						if (adder == 0)
							adder = 255;
						else
							adder--;

					} else if (oper == 5) {
						adder++;

						if ((adder >> 8) != 0) { // 누산기 값이 8비트를 초과한 경우
							adder = adder - ((adder >> 8) * 256);
						}
					} else if (oper == 6) {
						pc = val;

					} else if (oper == 7) {
						binary(adder);
						System.out.println();
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
