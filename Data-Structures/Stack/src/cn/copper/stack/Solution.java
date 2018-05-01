package cn.copper.stack;
import org.junit.Test;

import java.util.Stack;

/**
 * 使用栈测试括号完美匹配
 */
public class Solution {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            } else {
                    if(stack.isEmpty()){
                        return false;
                    }
                    char topChar = stack.pop();
                    if(c == ')' && topChar != '(')
                        return false;
                    if(c == '}' && topChar != '{')
                        return false;
                    if(c == ']' && topChar != '[')
                        return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        String s = "{()[]}";
        boolean b = Solution.isValid(s);
        System.out.println(b);
    }
}
