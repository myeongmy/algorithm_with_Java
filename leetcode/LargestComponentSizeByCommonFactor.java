package leetcode;

//배열 A의 크기가 20000개 이므로 모든 간선을 탐색하기에는 시간 초과 -> DFS 사용 불가
//Union find 알고리즘 사용

class Solution {
	static int[] parent = new int[100001];

	static int find(int v) {
		if (v == parent[v])
			return v;

		return find(parent[v]);
	}

	static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent < bParent)
			parent[bParent] = aParent;
		else
			parent[aParent] = bParent;
	}

	public int largestComponentSize(int[] A) {
		// parent 배열을 초기화
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		for (int i = 0; i < A.length; i++) {
			for (int j = 2; j <= Math.sqrt(A[i]); j++) { // 범위를 루트를 사용하지 않는 경우 time limit exceeded error
				if (A[i] % j == 0 && find(A[i]) != find(j)) {
					union(A[i], j);
				}

				if (A[i] % j == 0 && find(A[i]) != find(A[i] / j)) {
					union(A[i], A[i] / j);
				}
			}
		}

		// connected graph의 숫자를 세기 위함
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // (key, value) : (최상위 노드 : 해당 최상위 노드에 연결된
																			// A[i]의 개수)

		for (int i = 0; i < A.length; i++) {
			int parent = find(A[i]);
			map.put(parent, map.getOrDefault(parent, 0) + 1);
		}

		List<Integer> valueSet = new ArrayList<>(map.values());
		Collections.sort(valueSet, Collections.reverseOrder());

		return valueSet.get(0);
	}

}
