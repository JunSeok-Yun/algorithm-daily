import java.io.*;
import java.util.*;

public class Main{
	static int N,M,R;
	static int cnt;
	static long sum;
	static long[] res;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		res = new long[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(res, -1);

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

		for (int i = 1; i <= N; i++){
			Collections.sort(graph.get(i));
		}

		sum = 0;
		cnt = 0;

		dfs(R, 0);
		System.out.println(sum);
	}

	public static void dfs(int root, int depth) {
		visited[root] = true;
		long order = ++cnt;
		res[root] = order * depth;
		sum += res[root];

		for (int vertex: graph.get(root)) {
			if (!visited[vertex]){
				dfs(vertex, depth + 1);
			}
		}
	}
}