//�迭 ������ ���� (���� 13397���� ����)
//�� �� Ǯ������. ������ ���� ���� ���ӵ� ���� �������� �̷�������Ѵٴ� ���� �����ߴ�. �׷��� �׳� �� ���� ���� ��� ������ �� �� ���� �� ��� ��츦 ������ ���ߴµ� Ʋ�ȴ�.


package �ڵ��׽�Ʈ;

import java.util.*;
import java.io.*;

public class SW_Maestro_Test_3 {
	// 1+2+3 ���ϱ�� ����� ����Ž������ Ǯ�� -> �ð��ʰ�
	
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
	
	// �̺� Ž������ Ǯ�� (�Ķ��Ʈ�� ��ġ)
	// ���� ������ �ִ��� �ּڰ��� ���ϴ� ����
	// ���� Ž�� ������ ���� ���ϰ��� �ϴ� ���� �ּڰ�, �ִ��� ���ϴ� ����ȭ ���� Ǫ�� �� ��� ����
	// ���� ���ϰ��� �ϴ� �� = ���� ������ �ִ�
	// ���� ���ϰ��� �ϴ� ���� ����= 0~9999
	// ���� ���迡���� ���� ������ (�ִ� - �ּ�)�� ���� �ּڰ��� ���ϴ� �ſ���. -> ���� ������  �ִ밪�� �ּڰ��� ���ϰ� �װɷ� ������ ������ ���� ����ϸ� �ȴ�.
	
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
