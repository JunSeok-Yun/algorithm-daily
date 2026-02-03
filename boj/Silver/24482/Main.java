import java.io.*;
import java.util.*;

public class Main{
	static int N,M,R;
	static int[] res;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		res = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(res, -1);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<> ());
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

		res[R] = 0;
		visited[R] = true;
		dfs(R, 1);

		for (int i = 1; i<= N; i++) {
			sb.append(res[i]).append('\n');
		}
		System.out.println(sb);

	}

	public static void dfs(int root, int depth) {
		for (int vertex: graph.get(root)){
			if (!visited[vertex]){
				visited[vertex] = true;
				res[vertex] = depth;
				dfs(vertex, depth + 1);
			}
		}
	}
}