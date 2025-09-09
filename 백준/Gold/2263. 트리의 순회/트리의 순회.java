
import java.util.*;
import java.io.*;

public class Main {
	
	static int[] inorder, postorder;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		inorder = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		postorder = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		preorder(0, N-1, 0, N-1);
		System.out.println(sb);
		

	}
	
	static void preorder(int inS, int inE, int postS, int postE) {
		// 기저조건
		if(inS > inE) {
			return;
		}
		int root = postorder[postE];
		sb.append(root + " ");
		
		int rootIdx = 0;
		for(int i=inS; i<=inE; i++) {
			if(root == inorder[i]) {
				rootIdx = i;
				break;
			}
		}
		int lsize = rootIdx - inS; //왼쪽
		
		preorder(inS, rootIdx-1, postS, postS+lsize-1); //왼쪽
		preorder(rootIdx+1, inE, postS+lsize, postE-1); //오른쪽
		
		
	}

}
