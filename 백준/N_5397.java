//���� 5397��
//�ùķ��̼� ���� Ǯ��

package ����;

import java.io.*;
import java.util.*;

public class N_5397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String str = br.readLine();
				Stack<Character> front = new Stack<Character>();
				Stack<Character> back = new Stack<Character>();

				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == '<') {
						if (front.size() == 0)
							continue;
						back.push(front.pop());
					} else if (str.charAt(j) == '>') {
						if (back.size() == 0)
							continue;
						front.push(back.pop());
					} else if (str.charAt(j) == '-') {
						if(front.size() == 0)
							continue;
						front.pop();
					} else { // ���ĺ�
						front.push(str.charAt(j));
					}
				}
				
				
				while(!front.empty()) {
					back.push(front.pop());
				}
				StringBuilder pwd = new StringBuilder();
				while(!back.empty()) {
					pwd.append(back.pop());
				}
				
				System.out.println(pwd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
