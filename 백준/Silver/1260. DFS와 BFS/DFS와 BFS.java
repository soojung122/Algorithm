import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; 
    static boolean[] visit; 
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int num;
        Node(int num) { this.num = num; }
        @Override
        public String toString() {
            return String.valueOf(num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        int V = sc.nextInt(); 

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visit = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visit = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());
    }

    static void dfs(int node) {
        visit[node] = true;
        sb.append(node).append(" ");

        for (int next : graph[node]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(start));
        visit[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            sb.append(cur.num).append(" ");

            for (int next : graph[cur.num]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.offer(new Node(next));
                }
            }
        }
    }
}
