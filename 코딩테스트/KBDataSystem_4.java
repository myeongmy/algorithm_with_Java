package 코딩테스트;
//하노이의 탑
import java.io.*;
public class KBDataSystem_4 {
	static int count = 0;
	static void hanoi(String first, String center, String last, int N){
		if(N == 1){
			count++;
		}else{
			hanoi(first, last, center, N-1);
			count++;
			hanoi(center, first, last, N-1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi("1", "2", "3", N);
		System.out.println(count);
	}
}
