
import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		int val;
		Node left, right;
        Node(int val) {
            this.val = val;
        }
	}
	
	static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        }
        else {
            node.right = insert(node.right, val);
        }
        return node;
    }

    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = null;
		
		String str;
		while ((str = br.readLine()) != null && !str.isEmpty()) {
            int input = Integer.parseInt(str);
            root = insert(root, input);
        }
		
		postorder(root);
		
		System.out.println(sb);
	}
	
	static void postorder(Node n) {
		if(n == null) return;
		postorder(n.left);
		postorder(n.right);
		sb.append(n.val + "\n");
	}

}
