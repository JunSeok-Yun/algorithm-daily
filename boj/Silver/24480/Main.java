import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R;
	static int cnt = 0;
	static int[] res;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		res = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		res[R] = 1;
		visited[R] = true;
		cnt = 2;
		dfs(R);

		for (int i = 1; i<= N; i++) {
			sb.append(res[i]).append('\n');
		}
		System.out.println(sb);
		br.close();
	}

	public static void dfs(int root) {
		for (int vertex : graph.get(root)) {
			if (!visited[vertex]) {
				res[vertex] = cnt++;
				visited[vertex] = true;
				dfs(vertex);
			}
		}
	}
}
