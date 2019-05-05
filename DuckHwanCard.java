package codingtest_study;

import java.util.LinkedList;
import java.util.Scanner;

public class DuckHwanCard {
	public static void rearrange(LinkedList<Long> cardArray, long K) {
		for (long i = 0; i < K; i++) {
			long temp = cardArray.get(0);
			cardArray.remove(0);
			cardArray.add(temp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			long N = s.nextLong();
			long K = s.nextLong();

			LinkedList<Long> cardArray = new LinkedList<Long>();
			for (long j = 0; j < N; j++) // 카드 배열 초기화
				cardArray.add(j + 1);
			while (cardArray.size() != 1) {
				rearrange(cardArray, K);
				cardArray.remove(0);
			}
			System.out.println("#" + (i + 1) + " " + cardArray.get(0));
			cardArray.clear();

		}

	}

}
