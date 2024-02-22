import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                int idx = str.indexOf(" ");
		        int a = Integer.parseInt(str.substring(0, idx));
		        int b = Integer.parseInt(str.substring(idx + 1, str.length()));
                String [] a_li = new String[a];
                String [] b_li = new String[b];
                a_li = br.readLine().split(" ");
                b_li = br.readLine().split(" ");
                ArrayList<String> list = new ArrayList<>();
                HashMap<String,Integer> map = new HashMap<>();
                for (int i = 0; i < a; i++) {
                    String name = a_li[i];
                    map.put(name,1);
		        }
                for (int j = 0; j < b; j++) {
                    String name = b_li[j];
                    map.put(name,map.getOrDefault(name,0)+1);
		        }
                for(String key : map.keySet()){
                    if(map.get(key)==1){
                        list.add(key);
                    }
                }
                System.out.println(list.size());
                
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
        }
}