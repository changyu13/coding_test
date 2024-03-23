import java.io.*;

public class Main{
    public static int [][][] list = new int[21][21][21];
    public static int w(int a,int b,int c){
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        else if(a>20 || b>20 || c>20){
            return list[20][20][20]=w(20,20,20);
        }
        else if(list[a][b][c]!=0){
            return list[a][b][c];
        }
        else if(a<b && b<c){
            return list [a][b][c]= w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        }
        else{
            return list[a][b][c]= w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
    }
    public static void main(String[] args) {
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while(true){
                    String s= br.readLine();
                    int space= s.indexOf(" ");
                    int a= Integer.parseInt(s.substring(0,space));
                    int space2 = space+(s.substring(space+1,s.length())).indexOf(" ")+1;
                    int b= Integer.parseInt(s.substring(space+1,space2));
                    int c= Integer.parseInt(s.substring(space2+1,s.length()));
                    if(a==-1 && b==-1 && c==-1){
                        break;
                    }
                    else{
                        System.out.println("w("+a+", "+b+", "+c+") = "+w(a,b,c));
                    }
                }
            }
            catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}