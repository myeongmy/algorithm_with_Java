package codingtest_study;

import java.util.Scanner;

public class ObstacleDifficulty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int N = s.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = s.nextInt();
			}
			int highest_up = 0;
			int highest_down = 0;
			int x;
			for (int k = 0; k <= arr.length - 2; k++) {
				if ((x = arr[k + 1] - arr[k]) >= 0) {
					if (x > highest_up)
						highest_up = x;
				} else {
					if (x < highest_down)
						highest_down = x;
				}
			}
			System.out.println("#" + (i + 1) + " " + highest_up + " " + Math.abs(highest_down));
		}

	}

}
