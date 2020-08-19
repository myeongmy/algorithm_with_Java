package leetcode;

//문자열 처리

class Solution {
	public String toGoatLatin(String S) {
		StringBuilder sb = new StringBuilder();

		String[] arr = S.split(" ");
		String appendA = "a";

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];

			if (arr[i].startsWith("a") || arr[i].startsWith("e") || arr[i].startsWith("i") || arr[i].startsWith("o")
					|| arr[i].startsWith("u") || arr[i].startsWith("A") || arr[i].startsWith("E")
					|| arr[i].startsWith("I") || arr[i].startsWith("O") || arr[i].startsWith("U")) {
				str += "ma";
			} else {
				char a = str.charAt(0);
				str = str.substring(1);
				str += Character.toString(a);
				str += "ma";
			}

			str += appendA;
			appendA += "a";
			sb.append(str);
			sb.append(" ");
		}

		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
