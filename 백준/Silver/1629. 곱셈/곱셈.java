import java.io.*;

public class Main {
    public static long m=1;
    public static long mod(long a,long b, long c){
        if(a<c){
            if(b ==1){
                return a;
            }
            else if(b%2!=0){
                m=m*a;
                m=m%c;
            }
            b= b/2;
            a= a*a;
            a= a%c;
            return mod(a,b,c);
        }
        else{
            if(b==1){
                a=a%c;
                return a;
            }
            a=a%c;
            return mod(a,b,c);
        }
    }
    public static void main(String[] args) {
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int idx= s.indexOf(" ");
                long A = Integer.parseInt(s.substring(0,idx));
                int idx_2 = idx+s.substring(idx+1,s.length()).indexOf(" ")+1;
                long B = Integer.parseInt(s.substring(idx+1,idx_2));
                long C = Integer.parseInt(s.substring(idx_2+1,s.length()));
                System.out.println((mod(A,B,C)*m)%C);
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}