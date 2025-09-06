import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       char[] input = br.readLine().toCharArray();
        
       int N =  Integer.parseInt(br.readLine()); 
       System.out.println(input[N-1]); 
    }
}