package codingtest_study;

import java.util.Scanner;

public class EasyProblem {
	static int[] arr = new int[1036];

	static void arrInit() {
		int index = 1;
		for (int i = 1; i <= 45; i++) {
			for (int j = 1; j <= i; j++) {
				arr[index] = i;
				index++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		arrInit();
		int A = s.nextInt();
		int B = s.nextInt();
		int result = 0;
		for (int i = A; i <= B; i++)
			result += arr[i];
		System.out.println(result);
	}

}
