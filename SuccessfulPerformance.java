package codingtest_study;

import java.util.Scanner;

public class SuccessfulPerformance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();

		for (int i = 0; i < testCase; i++) {
			String str = s.next();
			int person = 0;
			int hiredPerson = 0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '0') continue;
				else if (j <= person) {
					person += str.charAt(j) - '0';
				} else {
					hiredPerson += j - person;
					person += hiredPerson+(str.charAt(j) - '0');
					
				}
			}
			System.out.println("#" + (i + 1) + " " + hiredPerson);
		}
	}

}
