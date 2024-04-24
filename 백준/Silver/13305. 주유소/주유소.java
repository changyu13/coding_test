import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                int [] distance = new int[num-1];
                long min=1000000000;
                long price=0;
                long sum=0;
                String s= br.readLine();
                StringTokenizer st = new StringTokenizer(s," ");
                for(int i=0;i<num-1;i++){
                    distance[i]= Integer.parseInt(st.nextToken());
                }
                s=br.readLine();
                st = new StringTokenizer(s," ");
                for(int i=0;i<num-1;i++){
                    price = Integer.parseInt(st.nextToken());
                    if(price<min){
                        min=price;
                    }
                    sum+= min*distance[i];
                }
                System.out.println(sum);
                
            }
            catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}