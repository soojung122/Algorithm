

import java.util.*;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			sb.append(str + "\n");
		}
		
		System.out.println(sb);
	}

}
