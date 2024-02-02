import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    
    
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        String obj = scan.nextLine();
        
        // 크로아티아 알파벳 개수 변수
        
        int num =0;
        
        // 크로아티아 변환 배열 선언
        
        String dic[] = new String[]{"c=","c-","d-","lj","nj","s=","z="};
        int len_num = obj.length();
        int i=0;
        
        while (i<len_num)
        {
            boolean is_cro = false;
            String str="";
            if(i+3<=len_num)
            {
                str = obj.substring(i,i+3);
            }
            // i번째 문자열부터 3칸이 dz=로 끝날 경우
            if(str.equals("dz=")){
                num++;
                i +=3;
                is_cro= true;
            }
            else if(i+2<=len_num){
                str = obj.substring(i,i+2);
                for(int j=0; j< 7; j++){
                    if(str.equals(dic[j])){
                        num++;
                        i +=2;
                        is_cro= true;
                        break;
                    }
                }
                
            }
            if(is_cro==false){
                num++;
                i++;
            }
            
            
            
        }
        System.out.println(num);
    }

}

