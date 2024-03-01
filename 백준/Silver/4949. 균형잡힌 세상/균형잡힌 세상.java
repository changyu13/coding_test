import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
           try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Stack<Character> stack = new Stack<>();
                while(true){
                    String input= br.readLine();
                    boolean ise = false;
                    if(input.equals(".")){
                        break;
                    }
                    else{
                        for(int i=0;i<input.length();i++){
                            if(input.charAt(i)=='[' || input.charAt(i)=='('){
                                stack.push(input.charAt(i));
                            }
                            else if(input.charAt(i)==']'){
                                if(stack.size()==0){
                                   ise= true;
                                   break;
                                }
                                else if(stack.pop()=='('){
                                    ise=true;
                                    break;
                                }
                            }
                            else if(input.charAt(i)==')'){
                                if(stack.size()==0){
                                   ise= true;
                                   break;
                                }
                                else if(stack.pop()=='['){
                                    ise=true;
                                    break;
                                }
                            }
                        }
                        if(stack.size()==0){
                            if(ise==true){
                                System.out.println("no");
                                continue;
                            }
                            System.out.println("yes");
                        }
                        else{
                            stack.clear();
                            System.out.println("no");
                        }
                    }
                }
            }catch(IOException e){
                e.getMessage();
                e.printStackTrace();
            }
        }
}