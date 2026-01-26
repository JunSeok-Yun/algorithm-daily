// dfs 기본 문제
// 94660KB, 908ms
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R;
	static int cnt = 0;
	static boolean[] visited; // 방문 체크 배열
	static int[] result; // 방문 순서를 저장하기 위한 결과값 배열
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		result = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i< M; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		result[R] = 1;
		visited[R] = true;
		cnt = 2;
		dfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb);
		br.close();
	}

	public static void dfs(int root) {
		for (int vertex : graph.get(root)) {
			if (!visited[vertex]) {
				result[vertex] = cnt++;
				visited[vertex] = true;
				dfs(vertex);
			}
		}
	}
}