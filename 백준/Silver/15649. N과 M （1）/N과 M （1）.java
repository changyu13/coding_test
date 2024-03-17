import java.io.*;

public class Main{
    public static boolean [] visit;
    public static int[] arr;
    public static void dfs(int N,int M,int depth){
        if(depth==M){
            for(int val: arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(visit[i]==false){
                visit[i]=true;
                arr[depth]= i+1;
                dfs(N,M,depth+1);
                visit[i]=false;
            }
        }
    }
    public static void main(String[] args){
    try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int space = s.indexOf(" ");
                int N = Integer.parseInt(s.substring(0,space));
                int M = Integer.parseInt(s.substring(space+1,s.length()));
                
                arr = new int[M]; 
                visit = new boolean[N];
                dfs(N,M,0);
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}