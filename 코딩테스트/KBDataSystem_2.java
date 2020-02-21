package 코딩테스트;
//완전제곱수 구하기
import java.io.*;
public class KBDataSystem_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		int M = Integer.parseInt(arr[0]);
		int N = Integer.parseInt(arr[1]);
		int [] A = new int[100000];  //완전 제곱수 담을 배열
		int idx = 0;
		for(int i=1;i*i<=N;i++){
			if(i*i >=M && i*i <= N){
				A[idx] = i*i;
				idx++;
			}
		}
		int sum = 0;
		int min = A[0];
		for(int i=0;i<idx;i++){
			sum += A[i];
			if(min > A[i])
				min = A[i];
		}
		System.out.println(min+" "+sum);
		
	}
}
