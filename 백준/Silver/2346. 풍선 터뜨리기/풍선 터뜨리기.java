import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Balloon> queue = new ArrayDeque<>();
            String answer="";
            answer += "1 ";
            int moveValue = Integer.parseInt(st.nextToken());
            for(int i=2; i<=num; i++){
                queue.add(new Balloon(i,Integer.parseInt(st.nextToken())));
            }

            while(!queue.isEmpty()){
                if(moveValue>0){
                    for(int i=1; i<moveValue; i++){
                        queue.add(queue.poll());
                    }
                    Balloon next = queue.poll();
                    answer +=next.idx+" ";
                    moveValue = next.value;
                }else{
                    for(int i=1; i<-moveValue;i++){
                        queue.offerFirst(queue.pollLast());
                    }
                    Balloon next = queue.pollLast();
                    answer += next.idx+" ";
                    moveValue = next.value;
                }
            }
            System.out.println(answer);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static class Balloon{
        int idx;
        int value;

        public Balloon(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
}