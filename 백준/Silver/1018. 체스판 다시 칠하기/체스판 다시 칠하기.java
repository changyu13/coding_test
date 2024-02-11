import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();
            int b = scan.nextInt();
            scan.nextLine();
            char [][] board = new char[50][50];
        
            int remain_a = a-8;
            int remain_b = b-8;
            int min = 100;
            int min_a=100;
            int min_b=100;
            int count =0;
            boolean is_b=false;
            for(int i=0; i<a;i++){
                String line = scan.nextLine();
                for(int j=0; j<b;j++){
                    board[i][j]=line.charAt(j);
                }
            }
            
            for(int j=0; j<remain_a+1;j++){
                for(int i=0; i<remain_b+1; i++){
                    count=0;
                    is_b=false;
                     if(board[j][i]=='B'){
                        for(int k=j;k<j+8;k++){
                            is_b= !is_b;
                            for(int l=i;l<i+8;l++){
                                if(is_b==true){
                                    if(board[k][l]=='B'){
                                        
                                    }
                                    else{
                                        count++;
                                    }
                                    is_b=false;
                                }
                                else{
                                    if(board[k][l]=='W'){
                                    }
                                    else{
                                         count++;   
                                    }
                                    is_b=true;
                                }
                            }
                        }
                         if(min_a>count){
                             min_a = count;
                         }
                         count=0;
                         is_b = true;
                            for(int k=j;k<j+8;k++){
                            is_b= !is_b;
                            for(int l=i;l<i+8;l++){
                                if(is_b==true){
                                    if(board[k][l]=='B'){
                                        
                                    }
                                    else{
                                        count++;
                                    }
                                    is_b=false;
                                }
                                else{
                                    if(board[k][l]=='W'){
                                    }
                                    else{
                                         count++;
                                    }
                                    is_b=true;
                                }
                            }
                        }
                         if(min_b>count){
                             min_b = count;
                         }
                     }
                        else{
                            is_b = true;
                            for(int k=j;k<j+8;k++){
                            is_b= !is_b;
                            for(int l=i;l<i+8;l++){
                                if(is_b==true){
                                    if(board[k][l]=='B'){
                                        
                                    }
                                    else{
                                        count++;
                                    }
                                    is_b=false;
                                }
                                else{
                                    if(board[k][l]=='W'){
                                    }
                                    else{
                                         count++;
                                    }
                                    is_b=true;
                                }
                            }
                        }
                        if(min_a>count){
                             min_a = count;
                         }
                         count=0;
                         is_b = false;
                            for(int k=j;k<j+8;k++){
                            is_b= !is_b;
                            for(int l=i;l<i+8;l++){
                                if(is_b==true){
                                    if(board[k][l]=='B'){
                                        
                                    }
                                    else{
                                        count++;
                                    }
                                    is_b=false;
                                }
                                else{
                                    if(board[k][l]=='W'){
                                    }
                                    else{
                                         count++;
                                    }
                                    is_b=true;
                                }
                            }
                        }
                         if(min_b>count){
                             min_b = count;
                         }
                            
                        }
                    if(min_a>min_b){
                        min=min_b;
                    }
                    else{
                        min=min_a;
                    }
                }
            }
        System.out.println(min);
            
        }
}