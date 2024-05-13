import java.io.*;
public class Main{
    public static void main(String[] args){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int index = s.indexOf(" ");
                int k = Integer.parseInt(s.substring(0,index));
                int n = Integer.parseInt(s.substring(index+1,s.length()));
                int [] cable = new int[k]; 
                int quo=0;
                long left=1;
                int cmp;
                long mid=0;
                long max=0;
                for(int i=0;i<k;i++){
                    cmp=Integer.parseInt(br.readLine());
                    cable[i]=cmp;
                    if(max<cmp){
                        max=cmp;
                    }
                }
                long right=max;
                while(left<=right){
                   quo=0;
                   mid=(left+right)/2;
                   for(int i=0;i<k;i++){
                       quo+= cable[i]/mid;
                   }
                   if(quo>=n){
                       left=mid+1;
                   }
                    else{
                        right=mid-1;
                    }
                }
                System.out.println(right);
            }
            catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}