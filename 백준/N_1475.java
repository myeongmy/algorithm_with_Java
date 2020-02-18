//백준 1475번
//문자열 처리 문제 (중요!!!)
/*문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.*/

package 백준;

import java.util.*;

public class N_1475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int[] A = new int[9]; // 0:0의 개수, 1:1의 개수, 2:2의 개수, 3:3의 개수, 4:4의 개수, 5:5의 개수, 6: 6, 9의 개수
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '9') {
				A[6]++;
				continue;
			}
			A[str.charAt(i) - 48]++;
		}
		if (A[6] % 2 == 0)
			A[6] = A[6] / 2;
		else
			A[6] = A[6] / 2 + 1;
		int max = A[0];
		for (int i = 0; i < 9; i++) {
			if (max < A[i])
				max = A[i];
		}
		System.out.println(max);
	}

}
