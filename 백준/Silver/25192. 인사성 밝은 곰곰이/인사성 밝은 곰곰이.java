import java.io.*;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                int count =0;
                HashMap<String,Integer> map = new HashMap<>();
                for(int i=0;i<num;i++){
                    String s = br.readLine();
                    if(s.equals("ENTER")){  
                        for(String key : map.keySet()){
                            if(map.get(key)>=1){
                                count++;
                            }
                        }
                        map = new HashMap<>();
                    }
                    else{
                        map.put(s,map.getOrDefault(s,0)+1);
                    }
                }
                for(String key : map.keySet()){
                    if(map.get(key)>=1){
                        count++;
                    }
                }
                System.out.println(count);
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
        }
}