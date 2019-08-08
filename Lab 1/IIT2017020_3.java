import java.io.*;
import java.util.*;
import java.util.regex.*;

public class IIT2017503_3{
    public static void main(String[] args) throws Exception{
        File file = new File("/home/beaku/Documents/SOE/IIT2017020/input2.c");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int ans = 0;
        int cnt = 0;
        int size = 0;
        boolean flag = 0;
        String name = "";
        Stack<Character> stack = new Stack<Character>();
        String pat_1 = "(void|char|float|long|int|double){1}.+[(]{1}.*[)]{1}";
        while((st = br.readLine()) != null){
            if(Pattern.matches(pat_1, st) == true){
                String[] value = st.split(" ");
                String s = "";
                String req = value[1];
                for(int i=0;i<req.length();i++){
                    if(req.charAt(i) == '(')
                        break;
                    s += req.charAt(i);
                }

                name = s;
            }
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
                System.out.println("function " + name + " : " + cnt);
                ans += cnt;
                cnt = 0;
                flag = true;
            }
        } 

        System.out.println(ans);  
    }
}