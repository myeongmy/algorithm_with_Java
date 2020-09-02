package 코딩테스트;

class Ahnlab_5 {
	public int solution(int num, int[] cards) {
		int answer = 0;

		long[] d = new long[10001];
		for (int i = 0; i < d.length; i++)
			d[i] = Long.MAX_VALUE;

		d[0] = 0;
		for (int i = 0; i < cards.length; i++) {
			d[cards[i]] = 1;
		}

		Label: for (int i = 1; i < d.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (i == cards[j])
					continue Label;
			}

			for (int j = 0; j < cards.length; j++) {
				if (i - cards[j] >= 0 && d[i - cards[j]] != Long.MAX_VALUE)
					d[i] = Math.min(d[i], d[i - cards[j]] + 1);
			}
		}

		if (d[num] == Long.MAX_VALUE)
			answer = -1;
		else
			answer = (int) d[num];
		return answer;
	}
}
