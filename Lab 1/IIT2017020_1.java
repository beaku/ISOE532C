import java.io.*;
import java.util.regex.*;

public class IIT2017020_1{
    public static void main(String[] args) throws Exception{
        File file = new File("/home/beaku/Documents/SOE/IIT2017020/input.c");

        BufferedReader br = new BufferedReader(new FileReader(file));


        // Part 1
        System.out.println("Functions are: ");
        String pattern1 = "(void|char|float|long|int|double){1}.+[(]{1}.*[)]{1}";
        String pattern2 = "[a-zA-Z0-9]+[(]{1}.*";
        String str;
        int count = 0;
        while((str = br.readLine()) != null){
            if(Pattern.matches(pattern1, str) == true){
                count++;
                System.out.println(str);
            }
        }

        System.out.println("Number of functions: " + count + "\n");

        //Part 2
        count = 0;
        br = new BufferedReader(new FileReader(file));

        while((str = br.readLine()) != null){
            String[] value = str.split(" ");
            for(int i=0;i<value.length;i++){
                String req = value[i];
                if(Pattern.matches(pattern2, req) == true){
                    if(i != 0){
                        if(value[i-1].equals("int") || value[i-1].equals("void") || value[i-1].equals("char") || value[i-1].equals("float") || value[i-1].equals("long") || value[i-1].equals("double")){
                            break;
                        }
                    }
                    
                    
                    String o = "";
                    for(int k=0;k<req.length();k++){
                        if(req.charAt(k) == '(')
                            break;
                        o += req.charAt(k);
                    }
                    if(o.equals("for") || o.equals("while") || o.equals("if") || o.equals("switch")){
                        break;
                    }
                    count++;
                }
            }
        }
        System.out.println("Number of Function Calls: "+ count + "\n");


        //Part 4,5,6
        System.out.println("If/For/While/Switch-Cases: ");
        br = new BufferedReader(new FileReader(file));
        int line = 0;
        int numFor = 0;
        int numWhile = 0;
        int numDo = 0;
        int numIf = 0;
        int numCases = 0;
        while((str = br.readLine()) != null){
            str = str.trim();
            if(Pattern.matches("for[(]{1}.*[)]{1}", str) == true){
                numFor++;
                System.out.println("Found at Line number: " + line);
                System.out.println(str);
            }
            else if(Pattern.matches("while[(]{1}.*[)]{1}", str) == true){
                numWhile++;
                System.out.println("Found at Line number: " + line);
                System.out.println(str);
            }
            else if(Pattern.matches("do", str) == true){
                numDo++;
                System.out.println("Found at Line number: " + line);
                System.out.println(str);
            }
            else if(Pattern.matches("if[(]{1}.*[)]{1}", str) == true){
                numIf++;
                System.out.println("Found at Line number: " + line);
                System.out.println(str);
            }
            else if(Pattern.matches("case[ ]{1}.+", str) == true || Pattern.matches("default[:]{1}", str) == true){
                numCases++;
                System.out.println("Found at Line number: " + line);
                System.out.println(str);
            }
            line++;
        }
        System.out.println("Number of For " + numFor);
        System.out.println("Number of While " + numWhile);
        System.out.println("Number of Do " + numDo);
        System.out.println("Number of If " + numIf);
        System.out.println("Number of Case " + numCases + "\n");
        
        
        // Part 3
        br = new BufferedReader(new FileReader(file));
        String pat = "#include{1}.*";
        count = 0;
        while((str = br.readLine()) != null){
            if(Pattern.matches(pat, str) == true){
                count++;
                String s = "";
                int i = 0;
                while(str.charAt(i) != '<'){
                    i++;
                }
                i++;
                while(str.charAt(i) != '>'){
                    s += str.charAt(i);
                    i++;
                }

                System.out.println(s);
            }
        }

        System.out.println("Number of header files are: " + count + "\n");
    }
}