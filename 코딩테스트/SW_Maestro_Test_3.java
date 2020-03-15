//배열 나누기 문제 (백준 13397번과 동일)
//잘 못 풀었었다. 구간을 나눌 때는 연속된 수로 구간들이 이루어져야한다는 점을 간과했다. 그래서 그냥 각 수에 대해 어느 구간에 들어갈 수 있을 지 모든 경우를 따져서 구했는데 틀렸다.


package 코딩테스트;

import java.util.*;
import java.io.*;

public class SW_Maestro_Test_3 {
	// 1+2+3 더하기와 비슷한 완전탐색으로 풀이 -> 시간초과
	
	/*static int min = Integer.MAX_VALUE;
	static int[] result = new int[5001];
	static int sum = 0;

	static int min_max(int start, int end, int[] A) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = start; i <= end; i++) {
			if (min > A[i])
				min = A[i];
			if (max < A[i])
				max = A[i];
		}
		return max - min;
	}

	static void go(int index, int[] A, int M) {
		if (index == M) {
			if (sum == A.length) {
				int cost = Integer.MIN_VALUE;
				int littleSum = 0;
				for (int i = 0; i < M; i++) {
					if (i == 0) {
						int r = min_max(0, result[i] - 1, A);
						if (cost < r)
							cost = r;
					} else {
						int r = min_max(littleSum, littleSum + result[i] - 1, A);
						if (cost < r)
							cost = r;
					}
					littleSum += result[i];
				}
				if (min > cost)
					min = cost;
			}
			return;
		}
		for (int i = 1; i <= A.length; i++) {
			if (sum + i <= A.length) {
				result[index] = i;
				sum += i;
				go(index + 1, A, M);
				sum -= i;
				result[index] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int[] A = new int[N];
			String[] arr1 = br.readLine().split(" ");
			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(arr1[i]);

			go(0, A, M);
			System.out.println(min);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/
	
	// 이분 탐색으로 풀이 (파라메트릭 서치)
	// 구간 점수의 최댓값의 최솟값을 구하는 문제
	// 이진 탐색 문제는 내가 구하고자 하는 값의 최솟값, 최댓값을 구하는 최적화 문제 푸는 데 사용 가능
	// 내가 구하고자 하는 값 = 구간 점수의 최댓값
	// 내가 구하고자 하는 값의 범위= 0~9999
	// 실제 시험에서는 나눈 구간의 (최대 - 최소)의 합의 최솟값을 구하는 거였다. -> 구간 점수의  최대값의 최솟값을 구하고 그걸로 구간을 나눠서 합을 계산하면 된다.
	
	static int totalResult = Integer.MAX_VALUE;
	static int binarySearch(int [] A, int start, int end, int M) {
		if(start > end)
			return -1;
		int mid = (start+end) / 2;
		
		int gogan = 1;
		int startP = 0;
		for(int i=0;i<A.length;i++) {
			int min = min(startP, i, A);
			int max = max(startP, i, A);
			
			if(max - min > mid) {
				gogan++;
				startP = i;
			}
		}
		if(gogan <= M) {
			if(totalResult > mid)
				totalResult = mid;
			return binarySearch(A, start, mid-1, M);
		}else {
			return binarySearch(A, mid+1, end, M);
		}
		
	}
	
	static int min(int startP, int endP, int [] A) {
		int min = A[startP];
		for(int i=startP;i<=endP;i++) {
			if(min > A[i])
				min = A[i];
		}
		return min;
	}
	
	static int max(int startP, int endP, int [] A) {
		int max = A[startP];
		for(int i=startP;i<=endP;i++) {
			if(max < A[i])
				max = A[i];
		}
		return max;
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		
		int [] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = s.nextInt();
		
		binarySearch(A, 0, 9999, M);
		System.out.println(totalResult);
	}

}
