import java.io.*;
public class Main{
    static Integer [][] dp;
    static int [] w;
    static int [] v;
    public static int knapsack(int i, int k){
        if(i<0){
            return 0;
        }
        if(dp[i][k]==null){
            if (w[i]>k){
                dp[i][k]= knapsack(i-1,k);
            }
            else{
                dp[i][k] =  Math.max(knapsack(i-1,k),knapsack(i-1,k-w[i])+v[i]);
            }
        }
        return dp[i][k];
    }
    public static void main(String[] args) {
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int space = s.indexOf(" ");
                int num = Integer.parseInt(s.substring(0,space));
                int k = Integer.parseInt(s.substring(space+1,s.length()));
                w = new int [num];
                v = new int [num];
                dp = new Integer[num][k+1];
                for(int i=0; i<num; i++){
                    s=br.readLine();
                    space = s.indexOf(" ");
                    w[i]= Integer.parseInt(s.substring(0,space));
                    v[i] = Integer.parseInt(s.substring(space+1,s.length()));
                }
                System.out.println(knapsack(num-1,k));
            }catch(IOException e){
                e.getMessage();
                e.printStackTrace();
            }
    }
}