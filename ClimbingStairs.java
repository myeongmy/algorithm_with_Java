package codingtest_study;

import java.util.Scanner;

public class ClimbingStairs {
	public static int max(int v1, int v2) {
		if (v1 >= v2)
			return v1;
		else
			return v2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int numOfStairs = s.nextInt();
		int[] arr = new int[numOfStairs + 1];
		int[] score = new int[numOfStairs + 1]; // score[i]는 i번째 계단까지의 최대 점수 저장
		for (int i = 1; i <= numOfStairs; i++) {
			arr[i] = s.nextInt();
		}

		score[1] = arr[1];
		score[2] = arr[1] + arr[2];
		for (int i = 3; i <= numOfStairs; i++) {
			score[i] = max(arr[i] + arr[i - 1] + score[i - 3], arr[i] + score[i - 2]);
		}
		System.out.println(score[numOfStairs]);
	}

}
