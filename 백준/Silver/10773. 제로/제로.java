import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<n; i++){
                int num = Integer.parseInt(br.readLine());
                if(num!=0){
                    sum += stack.push(num);
                }else{
                    sum -= stack.pop();
                }
            }
            System.out.println(sum);
        }catch(IOException e){
            e.getMessage();
            e.printStackTrace();
        }
    }
}