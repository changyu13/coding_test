import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
        
            int [][] area = new int[100][100];
            int count=0;
            for(int l=0;l<num;l++){
                int a= scan.nextInt();
                int b= scan.nextInt();
                for(int i=a;i<a+10;i++){
                    for(int j=b;j<b+10;j++){
                        area[i][j]=1;
                    }
                }
            }
            for(int i=0;i<100;i++){
                    for(int j=0;j<100;j++){
                        if(area[i][j]==1){
                            count++;
                        }
                    }
            }
            System.out.println(count);
        }
}