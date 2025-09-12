
import java.util.*;
import java.io.*;

public class Main {
	
	static int V, E;
	static long sum; //가중치가 int 범위의 끝이기 때문
	static Edge[] edges; // 그래프의 모든 간선 정보를 저장함.
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); //정점의 개수
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		
		edges = new Edge[E];
		parent = new int[V + 1]; 
		//Union-find 에서 사용된다. 각 정점이 어떤 집합(루트)에 속하는지
		//추적할 때 쓰기 때문에, 정점마다 부모 노드를 기록해야 한다.
		
		// 간선 리스트
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(v1, v2, c);
		}
		
		//간선 리스트 정령
		Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
		makeSet();
		
		int cnt = 0; //사이클 없이 간선 선택
		
		for(int i=0; i<edges.length; i++) {
			Edge edge = edges[i];
			if(union(edge.v1, edge.v2)) {
				sum += edge.c;
				cnt++;
				if( cnt == V - 1 ) break;

			}
			
		}
		
		System.out.println(sum);

	}
	
	static class Edge {
		int v1, v2, c; // 시작정점, 끝정점, 가중치 c
		
		Edge(int v1, int v2, int c){
			this.v1=v1;
			this.v2=v2;
			this.c=c;
		}

		@Override
		public String toString() {
			return "[v1=" + v1 + ", v2=" + v2 + ", c=" + c + "]";
		}	
	}
	
	static void makeSet(){
		for(int i=0; i<=V; i++) {
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
		else parent[px] = py;
		
		return true;
	}
	
}
