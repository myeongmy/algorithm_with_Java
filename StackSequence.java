// LinkedList이용하여 stack 구현
// .add(), .removeLast() 메소드 이용
// System.exit(0) 정상적인 종료

package codingtest_study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class StackSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int numOfElements = s.nextInt();

		LinkedList<Integer> stack = new LinkedList<Integer>();
		ArrayList<Character> operationList = new ArrayList<Character>();
		int putNum = 0;
		for (int i = 0; i < numOfElements; i++) {
			int element = s.nextInt();
			if (stack.isEmpty() || stack.getLast() < element) {
				if (putNum > element) {
					System.out.println("NO");
					System.exit(0);
				}
				for (int j = putNum + 1; j <= element; j++) {
					stack.add(j);
					operationList.add('+');
					putNum += 1;
				}
				stack.removeLast();
				operationList.add('-');
			}
			if (!stack.isEmpty()) {
				if (stack.getLast() >= element) {
					for (int k = 0; k <= stack.getLast() - element; k++) {
						stack.removeLast();
						operationList.add('-');
						if (stack.isEmpty())
							break;
					}
				}
			}

		}
		for (int i = 0; i < operationList.size(); i++)
			System.out.println(operationList.get(i));

	}

}
