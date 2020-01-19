//백준 1212번
/*문제
8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.

출력
첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.*/

package codingtest_study.백준;

import java.util.HashMap;
import java.util.Scanner;

public class N_1212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HashMap<Character, String> hm = new HashMap<Character, String>();
		hm.put('0', "000");
		hm.put('1', "001");
		hm.put('2', "010");
		hm.put('3', "011");
		hm.put('4', "100");
		hm.put('5', "101");
		hm.put('6', "110");
		hm.put('7', "111");
		String num = s.nextLine();
		StringBuilder result = new StringBuilder();
		if (num.equals("0")) {
			System.out.println("0");
			System.exit(0);
		}
		for (int i = 0; i < num.length(); i++) {
			if (i == 0 && num.charAt(i) >= '0' && num.charAt(i) <= '3') {
				switch (num.charAt(i)) {
				case '0':
					result.append("");
					break;
				case '1':
					result.append("1");
					break;
				case '2':
					result.append("10");
					break;
				case '3':
					result.append("11");
					break;
				}
			} else {
				result.append(hm.get(num.charAt(i)));
			}
		}
		System.out.println(result);
	}

}