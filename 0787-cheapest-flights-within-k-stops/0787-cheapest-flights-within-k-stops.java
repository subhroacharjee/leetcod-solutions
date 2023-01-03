class Pair {
	public int stops;
	public int node;
	public int distance;
	public Pair(int stops, int node, int distance) {
		this.stops = stops;
		this.node = node;
		this.distance = distance;
	}
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> q = new LinkedList<>();
			int[] distance = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);

			List<Integer[]>[] adjList = new List[n];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < flights.length; i++) {
				Integer[] p = new Integer[2];
				p[0] = flights[i][1];
				p[1] = flights[i][2];
				adjList[flights[i][0]].add(p);
			}

			q.add(new Pair(0, src, 0));
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if (p.stops >= k+1 && p.node != dst) continue;
				if (p.node == dst) continue;
				for(Integer[] tup: adjList[p.node]) {
					if (distance[tup[0]] < tup[1] + p.distance) continue;
					distance[tup[0]] = tup[1] + p.distance;
					q.add(new Pair(p.stops+1, tup[0], distance[tup[0]]));
				}
			}

			return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}