import java.io.*;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Arrays;
import java.util.ArrayDeque;
public class Main{
    public static void main(String args[]){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                String s ="1 ";
                Deque<int [] > deque = new ArrayDeque<>();
                String input = br.readLine();
                int position = 0;
                 int balloon = 0;
                if(num==1){
                    System.out.println(1);
                }
                else{                  
                    for(int i=0; i<num-1;i++){
                        int idx = input.substring(position,input.length()).indexOf(" ")+position;
                        balloon = Integer.parseInt(input.substring(position,idx));
                        deque.addLast(new int[] {(i+1),balloon});
                        position = idx+1;
                     }
                    balloon =  Integer.parseInt(input.substring(position,input.length()));
                    deque.addLast(new int[] {(num),balloon}); 
                    int[] first = deque.removeFirst();
                    while(!deque.isEmpty()){
                        if(first[1]>0)
                        {
                            for(int a=1; a< first[1];a++){
                                deque.addLast(deque.pollFirst());   
                            }
                           first= deque.poll();
                           s += first[0]+" ";
                        }
                        else if(first[1]<0){
                            for(int a=-1; a> first[1];a--){
                                deque.addFirst(deque.pollLast());   
                            }
                           first= deque.pollLast();
                           s += first[0]+" ";
                        }
                    }
                    System.out.println(s);    
                }
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}