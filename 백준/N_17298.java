//���� 17298��
/*����
ũ�Ⱑ N�� ���� A = A1, A2, ..., AN�� �ִ�. ������ �� ���� Ai�� ���ؼ� ��ū�� NGE(i)�� ���Ϸ��� �Ѵ�. Ai�� ��ū���� �����ʿ� �����鼭 Ai���� ū �� �߿��� ���� ���ʿ� �ִ� ���� �ǹ��Ѵ�. �׷��� ���� ���� ��쿡 ��ū���� -1�̴�.

���� ���, A = [3, 5, 2, 7]�� ��� NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1�̴�. A = [9, 5, 4, 8]�� ��쿡�� NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000,000)�� �־�����. ��°�� ���� A�� ���� A1, A2, ..., AN (1 �� Ai �� 1,000,000)�� �־�����.

���
�� N���� �� NGE(1), NGE(2), ..., NGE(N)�� �������� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_17298 {
	//���ڿ� ������ Ž�� =>�ð� �ʰ�
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			int [] NGE = new int[N];
			String [] arr = br.readLine().split(" ");
			for(int i=0;i<N;i++){
				A[i] = Integer.parseInt(arr[i]);
			}
			for(int i=0;i<N;i++){
				if(i == N-1){  //���� A�� ������ ������ ���
					NGE[i] = -1;
					break;
				}
				for(int j=i+1;j<N;j++){
					if(j == N-1){
						NGE[i] = -1;
					}
					if(A[i] < A[j]){
						NGE[i] = A[j];
						break;
					}
				}
			}
			for(int i=0;i<NGE.length;i++){
				if(i == NGE.length - 1)
					System.out.print(NGE[i]);
				else
					System.out.print(NGE[i]+" ");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}*/
	
	//���� �̿�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			int [] NGE = new int[N];
			String [] arr = br.readLine().split(" ");
			Stack<Integer> st = new Stack<Integer>();
			for(int i=0;i<N;i++){
				A[i] = Integer.parseInt(arr[i]);
			}
			for(int i=0;i<N;i++){
				if(st.empty()){
					st.push(i);
					continue;
				}
				while(A[st.peek()] < A[i]){
					NGE[st.peek()] = A[i];
					st.pop();
					if(st.empty()) break;
				}
				st.push(i);
			}
			
			while(!st.empty()){
				NGE[st.pop()] = -1;
			}
			for(int i=0;i<NGE.length;i++){
				if(i == NGE.length - 1)
					System.out.print(NGE[i]);
				else
					System.out.print(NGE[i]+" ");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
