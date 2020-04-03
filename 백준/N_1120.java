//백준 1120번
//브루트 포스 문제 풀이
//x에 문자를 추가하는 방식으로 구현했더니 메모리 초과
//반대로 y에서 문자를 삭제하는 방식으로 구현했더니 pass -> String이나 StringBuilder에 계속 append 하는 것은 메모리 초과
/*문제
길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.

두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.

A의 앞에 아무 알파벳이나 추가한다.
A의 뒤에 아무 알파벳이나 추가한다.
이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. A와 B의 길이는 최대 50이고, A의 길이는 B의 길이보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

출력
A와 B의 길이가 같으면서, A와 B의 차이를 최소가 되도록 했을 때, 그 차이를 출력하시오.*/

package 백준;
import java.util.*;

public class N_1120 {
	static Character [] result = new Character[50];
	static StringBuilder x;
	static StringBuilder y;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		x = new StringBuilder(s.next());
		y = new StringBuilder(s.next());
		
		int length = y.length() - x.length();
		for(int i=0;i<=length;i++) {
			StringBuilder temp = new StringBuilder(y);
			//앞 지우기
			int cnt = i;
			while(cnt != 0) {
				temp.deleteCharAt(0);
				cnt--;
			}
			//뒤 지우기
			int time = length - i;
			while(time != 0) {
				temp.deleteCharAt(temp.length()-1);
				time--;
			}
			//x와 temp 비교
			int num = 0;
			for(int j=0;j<x.length();j++) {
				if(x.charAt(j) != temp.charAt(j))
					num++;
			}
			if(min > num)
				min = num;
		}
		System.out.println(min);
	}

}
