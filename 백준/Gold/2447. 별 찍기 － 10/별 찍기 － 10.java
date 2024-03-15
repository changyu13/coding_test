import java.io.*;

public class Main{
    public static String [][] puzzle;
    public static void draw(String[][] s, int num,int startX, int startY){
        if(num==3){
            for(int i=startX;i<startX+num;i++){
                for(int j=startY;j<startY+num;j++){
                    if(i==startX+1&&j==startY+1){
                       s[i][j]=" ";
                        continue;
                    }
                    s[i][j]="*";
                }
            }
            return;
        }
        if(num>3){
            for(int i=startX; i<startX+num;i += num/3){
                for(int j=startY; j<startY+num; j+= num/3){
                    if(i==startX+num/3&&j==startY+num/3){
                        for(int k=startX+num/3; k<startX+num/3*2;k++){
                            for(int l=startY+num/3;l<startY+num/3*2;l++){
                                s[k][l]=" ";
                            }
                        }
                        continue;
                    }
                     draw(s,num/3,i,j);       
                }
            }
        }
    }
    public static void main(String[] args){
         try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br. readLine());
                puzzle = new String[num][num];
                draw(puzzle,num,0,0);
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<num;i++){
                    for(int j=0;j<num;j++){
                        sb.append(puzzle[i][j]);
                    }
                    sb.append('\n');
                }
                System.out.print(sb);
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
    }
}