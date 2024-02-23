import java.io.*;
import java.util.HashMap;
public class Main{
    public static void main(String args[]){
      try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                HashMap<String,Integer> map = new HashMap<>();
                //문자열 그대로 put
                map.put(str,1);
                
                for(int i=1;i<str.length();i++){
                    for(int j=0;j<str.length()-i+1;j++){
                        
                        map.put(str.substring(j,j+i),1);
                    }
                }
                System.out.println(map.size());
                
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }      
    }
}