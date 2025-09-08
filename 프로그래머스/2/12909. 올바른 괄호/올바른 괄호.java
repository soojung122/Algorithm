import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '(')
                stack.push(arr[i]);
            else{
                if(stack.isEmpty() || stack.pop() == arr[i])
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}