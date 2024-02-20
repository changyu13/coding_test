import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                HashMap<String,String> map = new HashMap<String,String>();
                String [] name = new String[2];
                int count=0;
                for(int i=0;i<num;i++){
                    name = br.readLine().split(" ");
                    map.put(name[0],name[1]);
                }
                ArrayList<String> mem = new ArrayList<String>();
                for(String key : map.keySet()){
                    String value = map.get(key);
                    if (value.equals("enter")){
                        mem.add(key);
                    }
                }
                Collections.sort(mem);
                Collections.reverse(mem);
                for(int i=0; i<mem.size();i++){
                    System.out.println(mem.get(i));
                }
                
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
        }
}