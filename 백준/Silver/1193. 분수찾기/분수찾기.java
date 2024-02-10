import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int increase = 1;
            int standard =1;
            if (n==1){
                System.out.println("1/1");
            }
            else if(n==2){
                System.out.println("1/2");
            }
            else{
                 while(standard < n)
                {
                    increase++;
                    if(increase*(increase+1)/2 < n){
                        standard = increase*(increase+1)/2;
                    }
                    else{
                        increase--;
                        break;
                    }
                }
                int minus = n-standard;
                    if(increase%2==1){
                        int a= 0+minus;
                        int b= increase+2-minus;
                        System.out.println(Integer.toString(a)+"/"+Integer.toString(b));
                    }
                    else{
                    int a= 0+minus;
                    int b= increase+2-minus;
                    System.out.println(Integer.toString(b)+"/"+Integer.toString(a));
                    }
            }
        }
}