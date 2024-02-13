import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // 표를 그려서 봉투의 개수를 찾고 규칙성을 찾아서 정리
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
        
            if(n==4 || n==7){
                System.out.println(-1);
            }
            else if(n%5==0){
                System.out.println(n/5);
            }
            else if(n%5==1 || n%5==3){
                System.out.println(n/5+1);
            }
            else if(n%5==2 || n%5==4){
                System.out.println(n/5+2);
            }
    }
}