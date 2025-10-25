import java.util.*;
import java.io.*;

// 크루스칼로 구현
/*
 * 모든 두 집 쌍 = 노드 쌍, 불이 켜진 길만 = 가중치 계산
 * 절약할 수 있는 최대 액수 = 가중치가 가장 낮은 값
 */

public class Main {
	static int M, N; //집의 수, 길의 수
	static Edge[] edges; // 간선 리스트
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			StringTokenizer st = new StringTokenizer(line);
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M == 0 && N == 0)
				break;
			
			edges = new Edge[N];
			parent = new int[M];
			
			int tot = 0; //총액 구해야 함.
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(v1, v2, c);
				tot += c;
			}
			
			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
			makeSet(); 
			
			int cnt = 0; // 간선을 사이클없이 선택
            int sum = 0;
			for(int i=0; i<edges.length; i++) {
				Edge edge = edges[i];
				// edge.v1 과 edge.v2 가 사이클을 만들지 않으면 선택
				if( union(edge.v1, edge.v2) ) {
					sum += edge.c;
					cnt++;
					if( cnt == M - 1 ) break;
				}
			}
			sb.append(tot-sum).append("\n");
		
		}
		// 절약액 출력 = 모든 간선 가중치의 합 - MST
		System.out.println(sb);
		
	}
	static void makeSet() {
		for (int i = 0; i < M; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		// x의 대표원소, 최상위 부모를 찾아 리턴
		if( parent[x] == x ) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if( px == py ) return false; // 사이클 발생
		
		if( px < py ) parent[py] = px;
		else parent[px] = py; // px == py 포함
		
		return true;
	}
	
	static class Edge{
		int v1, v2, c;
		
		Edge(int v1, int v2, int c){
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}

}
