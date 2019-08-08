import java.io.*;
import java.util.*;
import java.util.regex.*;

public class IIT2017503_2{
    public static void main(String[] args) throws Exception{
        File file = new File("/home/beaku/Documents/SOE/IIT2017020/input2.c");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int ans = 0;
        int cnt = 0;
        int size = 0;
        boolean flag = false;
        Stack<Character> stack = new Stack<Character>();
        while((st = br.readLine()) != null){
            for(int i=0;i<st.length();i++){
                if(st.charAt(i) == '{'){
                    stack.push(st.charAt(i));
                    flag = true;
                    size++;
                }
                else if(st.charAt(i) == '}'){
                    stack.pop();
                    size--;
                }
            }
            st = st.trim();
            String[] arr = st.split(" ");
            for(String val : arr){
                if(Pattern.matches("if[(]{1}.*", val) == true){
                    cnt++;
                }
            }
            
            if(stack.empty() && flag){
                cnt += 1;
                ans += cnt;
                cnt = 0;
                flag = false;
            }
        } 

        System.out.println(ans);  
    }
}