//백준 1747번 소수&펠린드롬
//에라토스테네스의 체

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1747 {

	static boolean isPalindrome(int num) {
		String str1 = Integer.toString(num);
		String str2 = "";
		for(int i=str1.length()-1;i>=0;i--)
			str2 += str1.charAt(i);
		
		if(str1.equals(str2))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] A = new boolean[1005000];  //소수면 false, 합성수면 true
		A[1] = true;
		for(int i=2;i<A.length;i++) {
			if(A[i] == false) {
				for(int j=2;i*j<A.length;j++) {
					A[i*j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			
			int num = N;
			while(true) {
				if(A[num] == false && isPalindrome(num)) {
					System.out.println(num);
					break;
				}
				num++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
