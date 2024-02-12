import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            int user = scan.nextInt();
            int i=665;
            String s = "";
            int count =0;
            while(true){
                i++;
                s=Integer.toString(i);
                if(s.contains("666")){
                    count++;
                }
                if(count==user){
                    break;
                }
            }
            System.out.println(i);
            
        }
}