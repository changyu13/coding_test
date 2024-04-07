import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static Integer [] seq;
    public static int [] list;
    public static int lis(int num){
        if(seq[num]==null){
            seq[num]=1;
            for(int i=num-1; i>=0;i--){
                if(list[i]<list[num]){
                     seq[num]= Math.max(seq[num],lis(i)+1);   
                }
            }
        }
        
        return seq[num];
    }
    
    
    public static void main(String []args){
         try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                list = new int[num];
                seq = new Integer[num];
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int i=0;i<num;i++){
                    list[i]=Integer.parseInt(st.nextToken());
                }
                for(int i=0;i<num;i++){
                    lis(i);
                }
                //lis(num-1);
                int max=0;
                for(int i=0;i<num;i++){
                    if(seq[i]>max){
                        max=seq[i];
                    }
                }
                System.out.println(max);
            }
            catch(IOException e){
                e.getMessage();
                e.printStackTrace();
            }
    }
}