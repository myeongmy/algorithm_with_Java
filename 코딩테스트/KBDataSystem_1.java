package �ڵ��׽�Ʈ;

//�ִ� �Ÿ� ���ϱ�
import java.io.*;
public class KBDataSystem_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		String [] arr = br.readLine().split(" ");
		for(int i=0;i<N;i++){
			A[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(A[0]);
	}
}
