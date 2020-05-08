//백준 1484번
//투 포인터 알고리즘 문제 풀이

package 백준;

import java.util.*;

public class N_1484 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int G = s.nextInt();

		int current = 1;
		int old = 1;
		int flag = 0;

		while (old < G) {
			if (current * current - old * old == G) {
				System.out.println(current);
				flag = 1;
				old++;
			} else if (current * current - old * old < G) {
				current++;
			} else if (current * current - old * old > G) {
				old++;
			}
		}
		if (flag == 0)
			System.out.println(-1);

	}

}
