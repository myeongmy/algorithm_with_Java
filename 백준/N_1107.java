//백준 1107번
/*문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다.

입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.*/

package 백준;


import java.util.Scanner;

public class N_1107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		boolean [] check = new boolean[10];   //ArrayList로 저장해두고 contains() 메소드 이용하는 것보다 훨씬 빠름
		for (int i = 0; i < M; i++)
			check[s.nextInt()] = true;
		int result;

		result = Math.abs(N - 100);

		Label: for (int i = 0; i <= 1000000; i++) {  //계속 에러난 원인!! i를 1부터 시작했었다.
			int num = 0;
			String c = Integer.toString(i);
			for (int j = 0; j < c.length(); j++) {
				if(check[c.charAt(j) - 48] == true)
					continue Label;  //continue문을 이용하니 그렇지 않을 때보다 시간이 3배 이상 줄어들었다.
			}
			num += c.length();
			
			num += Math.abs(N - i);
			if (result > num)
				result = num;
		}
		System.out.println(result);
	}

}
