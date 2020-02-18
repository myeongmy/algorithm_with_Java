//백준 2941번
//문자열 처리 문제 (중요!!)
/*문제
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

크로아티아 알파벳	변경
č	c=
ć	c-
dž	dz=
đ	d-
lj	lj
nj	nj
š	s=
ž	z=
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

입력
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.

단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

출력
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.*/

package 백준;

import java.util.*;

public class N_2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'c') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-'))
					i++;
			}
			if (str.charAt(i) == 'd') {
				if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
					i++;
					i++;
				} else if (i+1 < str.length() && str.charAt(i + 1) == '-')
					i++;
			}
			if (i + 1 < str.length() && str.charAt(i) == 'l' && str.charAt(i + 1) == 'j')
				i++;
			if (i + 1 < str.length() && str.charAt(i) == 'n' && str.charAt(i + 1) == 'j')
				i++;
			if (i + 1 < str.length() && str.charAt(i) == 's' && str.charAt(i + 1) == '=')
				i++;
			if (i + 1 < str.length() && str.charAt(i) == 'z' && str.charAt(i + 1) == '=')
				i++;
			cnt++;
		}
		System.out.println(cnt);
	}

}
