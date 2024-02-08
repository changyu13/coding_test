import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String obj[] = new String[3];
            double count =0.00;
            double sum= 0.00;
            double score;
        
            for(int i=0;i<20;i++){
                score=0.00;
                obj = (scan.nextLine()).split(" ");
                if(obj[2].equals("P")){
                    continue;
                }
                else{
                    count+= Double.parseDouble(obj[1]);
                    if(obj[2].equals("A+")){
                        score = 4.50;
                    }
                    else if(obj[2].equals("A0")){
                        score = 4.00;
                    }
                    else if(obj[2].equals("B+")){
                        score = 3.50;
                    }
                    else if(obj[2].equals("B0")){
                        score = 3.00;
                    }
                    else if(obj[2].equals("C+")){
                        score = 2.50;
                    }
                    else if(obj[2].equals("C0")){
                        score = 2.00;
                    }
                    else if(obj[2].equals("D+")){
                        score = 1.50;
                    }
                    else if(obj[2].equals("D0")){
                        score = 1.00;
                    }
                    else if(obj[2].equals("F")){
                        score = 0.00;
                    }
                    sum += Double.parseDouble(obj[1]) * score;
                }
            }
            System.out.println(sum/count);
        }
}