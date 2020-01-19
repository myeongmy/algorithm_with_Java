//백준 1158번
/*
 문제
조세퍼스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-조세퍼스 순열이라고 한다. 예를 들어 (7, 3)-조세퍼스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-조세퍼스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

출력
예제와 같이 조세퍼스 순열을 출력한다.
*/

package codingtest_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_1158 {
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String sentence = br.readLine();
			String[] arr = sentence.split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			int[] array = new int[N];
			int[] removed = new int[N];
			int[] result = new int[N];
			int flag = 0; // K번째 인지 확인하기 위한 변수
			int idx = 0;
			int removedNum = 0;
			for (int i = 0; i < array.length; i++)
				array[i] = i + 1;
			while (true) {
				// 제거되지 않은 경우
				if (removed[idx] == 0) {
					flag++;
				}
				if (flag == K) {
					flag = 0;
					removed[idx] = 1;
					result[removedNum] = array[idx];
					removedNum++;
				}
				if (removedNum == N)
					break;
				idx = (idx + 1) % N;
			}
			System.out.print("<");
			for (int j = 0; j < result.length; j++) {
				if (j == result.length - 1)
					System.out.print(result[j]);
				else
					System.out.print(result[j] + ", ");
			}
			System.out.print(">");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	// 큐를 이용해서 구현
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String sentence = br.readLine();
			String [] arr = sentence.split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			Queue<Integer> q = new LinkedList<Integer>();
			LinkedList<Integer> result = new LinkedList<Integer>(); // 정답 조세퍼스 순열 담을 리스트
			for(int i=1;i<=N;i++){
				q.offer(i);
			}
			
			while(!q.isEmpty()){
				for(int i=1;i<K;i++){
					q.offer(q.poll());
				}
				result.add(q.poll());
				
			}
			System.out.print("<");
			for(int i=0;i<result.size();i++){
				if(i == result.size() - 1)
					System.out.print(result.get(i));
				else
					System.out.print(result.get(i)+", ");
			}
			System.out.print(">");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
