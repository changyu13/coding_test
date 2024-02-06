import java.util.Scanner;
import java.util.Arrays;

public class Main {

    
    public static void main(String[] args) {
 
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int answer=0;
        char [] dic = new char[30];
        for(int i=0; i<num;i++)
        {
            String word = scan.nextLine();
            int len = word.length();
            boolean is_group=true;
            int moon = 1;
            Arrays.fill(dic,' ');
            dic[0]=word.charAt(0);
            for(int j=1; j< len; j++){
                if(word.charAt(j)==word.charAt(j-1))
                {
                    continue;
                }
                else{
                    for(int k=0; k<moon;k++){
                         if(dic[k]==word.charAt(j))
                         {
                             is_group = false;
                         }
                        }
                        if(is_group==true)
                        {
                            moon++;
                            dic[moon-1]=word.charAt(j);
                        }
                    }
                    
                
                }
            if (is_group==true){
                answer++;
                
                }
          
            }
            System.out.println(answer);
        }
}    