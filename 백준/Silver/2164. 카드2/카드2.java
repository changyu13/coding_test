import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
public class Main{
    public static void main(String args[]){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                Queue<Integer> que = new LinkedList<>();
                for(int i=0; i<num;i++){
                    que.add(i+1);
                }
                int i=0;
                while(que.size()>1){
                    if(i%2==0){
                        que.poll();
                    }
                    else{
                        int n = que.poll();
                        que.add(n);
                    }
                    i++;
                }
                System.out.println(que.remove());
            }catch(IOException e){
                System.out.println(e.getMessage());
                e.getMessage();
            }
    }
}