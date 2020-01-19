//백준 17298번
/*문제
크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

출력
총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.*/

package codingtest_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_17298 {
	//문자열 일일히 탐색 =>시간 초과
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
				if(i == N-1){  //수열 A의 마지막 원소인 경우
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
	
	//스택 이용
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
