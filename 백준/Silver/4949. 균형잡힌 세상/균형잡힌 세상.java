import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            Stack<Character> stack = new Stack<Character>();
            ArrayList<String> list = new ArrayList<>();
            while(true){
                stack.clear();
                s = br.readLine();
                if(s.equals(".")==true){
                    break;
                }else{
                    String answer = "yes";
                    for(int i=0; i<s.length();i++){
                        if(s.charAt(i)=='[' || s.charAt(i)=='('){
                            stack.push(s.charAt(i));
                        }else if(s.charAt(i)==')'){
                            if(stack.size()==0 || stack.pop()!='('){
                                answer="no";
                                break;
                            }
                        } else if(s.charAt(i)==']'){
                            if(stack.size()==0 ||stack.pop()!='[') {
                                answer = "no";
                                break;
                            }
                        }
                    }
                    if(stack.size()!=0){
                        answer="no";
                    }
                    list.add(answer);
                }
            }
            for(int i=0; i<list.size();i++){
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}