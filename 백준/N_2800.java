//백준 2800번 괄호 제거
//스택 + 브루트 포스

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class N_2800 {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // (여는 괄호의 위치: 대응하는 닫는 괄호의 위치)
	static List<Integer> keyList;
	static String oper;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static TreeSet<String> finalResult = new TreeSet<String>();   //중복 제거와 사전순 출력 위함

	static void go(int index) {
		if (index == keyList.size()) {
			if (result.size() == 0)
				return;

			StringBuilder operation = new StringBuilder(oper);
			ArrayList<Integer> deleteIndex = new ArrayList<Integer>();
			for (int i = 0; i < result.size(); i++) {
				deleteIndex.add(result.get(i));
				deleteIndex.add(map.get(result.get(i)));
			}
			Collections.sort(deleteIndex, Collections.reverseOrder());
			for (int i = 0; i < deleteIndex.size(); i++) {
				operation.deleteCharAt(deleteIndex.get(i));
			}
			finalResult.add(operation.toString());

			return;
		}
		result.add(keyList.get(index));
		go(index + 1);
		result.remove(result.size() - 1);

		go(index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			oper = br.readLine();
			Stack<Integer> st = new Stack<Integer>();
			for (int i = 0; i < oper.length(); i++) {
				if (oper.charAt(i) == '(')
					st.push(i);
				else if (oper.charAt(i) == ')') {
					map.put(st.pop(), i);
				}
			}

			keyList = new ArrayList<>(map.keySet());
			go(0);
			
			for (String a : finalResult)
				System.out.println(a);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
