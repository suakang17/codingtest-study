package boj.solvedac;

import java.io.*;
import java.util.*;

public class _2887 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parent;
	static ArrayList<Edge> edgeList;

    static class Point {
	int num;
	int x;
	int y;
	int z;

	Point(int num, int x, int y, int z) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }	

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(br.readLine());

		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			points[i] = new Point(i, x, y, z);
		}

		edgeList = new ArrayList<>();

		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for(int i = 0; i < N-1; i++) {
			int weight = Math.abs(points[i].x - points[i + 1].x);

			edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for(int i = 0; i < N-1; i++) {
			int weight = Math.abs(points[i].y - points[i + 1].y);

			edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for(int i = 0; i < N-1; i++) {
			int weight = Math.abs(points[i].z - points[i + 1].z);

			edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList);

		int ans = 0;
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if(find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}

		System.out.println(ans);
	}

	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x != y) {
			parent[y] = x;
		}
	}
}
