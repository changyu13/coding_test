import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public class Main{
public static void draw(StringBuilder s,int num){
        if(num==1){
            System.out.println("-");
        }
        else{
            for(int i=0;i<num;i++){
                s.append("-");
            }
            int left = num/3-1;
            int right = num/3*2;
           for(int i=left+1;i<=right-1;i++){
                s.setCharAt(i,' ');
            }
            if(left==0 && right==num-1){
                return;
            }
            draw(s,0,left);
            draw(s,right,num-1);
        }
    }
    public static void draw(StringBuilder s, int left, int right){
        if(left==right){
                return;
        }
        int n = right-left+1;
        int l= left+n/3-1;
        int r= left+n/3*2;
         for(int i=l+1;i<=r-1;i++){
                s.setCharAt(i,' ');
            }
        if(l==left && r==right){
                return;
        }
        //if(left==l || r==right+1) return;
        draw(s,left,l);
        draw(s,r,right);
        
    }
    public static void main(String[] args) {
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input;
                StringBuilder s;
                while((input=br.readLine())!=null){
                int num =(int)Math.pow(3,Integer.parseInt(input));
                s= new StringBuilder();
                draw(s,num);
                if(num!=1){
                    System.out.println(s);
                }
            }
                
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}