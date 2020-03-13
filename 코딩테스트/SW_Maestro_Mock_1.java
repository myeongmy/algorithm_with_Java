package 코딩테스트;

//근묵자흑
//그냥 앞에서부터 K개씩 묶어서 갯수 세어주는 것이 최소이다.
import java.io.*;

public class SW_Maestro_Mock_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] A = new int[N];
		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(arr[i]);
		}
		int interval = K - 1;
		int start = 0;
		int fi = start + interval;
		int result = 1;
		while (fi < N - 1) {
			start = fi;
			fi = fi + interval;
			result++;
		}
		System.out.println(result);
	}
}
