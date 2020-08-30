package 코딩테스트;

//시뮬레이션
import java.util.*;

public class EbayKorea_1 {
	static class Customer {
		int waitTime;
		int consultTime;

		Customer(int waitTime, int consultTime) {
			this.waitTime = waitTime;
			this.consultTime = consultTime;
		}
	}

	static class Counter {
		int total;
		int current;

		Counter(int total, int current) {
			this.total = total;
			this.current = current;
		}
	}

	public int solution(int N, int[][] simulation_data) {
		int answer = 0;
		int time = 0;
		List<Customer> waitingQueue = new LinkedList<Customer>();
		Counter[] counterArr = new Counter[N];

		for (int i = 0; i < simulation_data.length; i++)
			waitingQueue.add(new Customer(simulation_data[i][0], simulation_data[i][1]));

		while (true) {
			int emptyFlag = 0;
			for (int i = 0; i < counterArr.length; i++) {
				if (counterArr[i] != null)
					emptyFlag = 1;
			}
			if (waitingQueue.isEmpty() && emptyFlag == 0)
				break; // 시뮬레이션 종료

			// 창구 상담 시간 update
			for (int i = 0; i < counterArr.length; i++) {
				if (counterArr[i] != null) {
					counterArr[i].current++;
					if (counterArr[i].total == counterArr[i].current)
						counterArr[i] = null;
				}
			}

			// waiting queue에서 이동
			for (int i = 0; i < waitingQueue.size(); i++) {
				if (waitingQueue.get(i).waitTime <= time) {
					for (int j = 0; j < counterArr.length; j++) {
						if (counterArr[j] == null) {
							counterArr[j] = new Counter(waitingQueue.get(i).consultTime, 0);
							answer += (time - waitingQueue.get(i).waitTime);
							waitingQueue.remove(i);
							i--;
							break;
						}
					}
				}
			}

			time++;
		}

		return answer;
	}
}
