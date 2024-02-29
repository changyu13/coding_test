import java.io.*;
import java.util.Stack;
public class Main{
    public static void main(String args[]){
     try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                int sum=0;
                Stack<Integer> stack = new Stack<>();
                for(int i=0; i<num;i++){
                    int a = Integer.parseInt(br.readLine());
                    if(a==0){
                        stack.pop();
                        continue;
                    }
                    stack.push(a); 
                }
                //stack을 pop 해주면 stack.size()수가 바뀐다.
                int size = stack.size();
                for(int j=0;j<size;j++){
                    sum += stack.pop();
                }
                System.out.println(sum);
                
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }       
    }
}