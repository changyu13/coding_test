import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Main {
    public static void main(String args[]){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                int idx = str.indexOf(" ");
		        int listen = Integer.parseInt(str.substring(0, idx));
		        int see = Integer.parseInt(str.substring(idx + 1, str.length()));
                ArrayList<String> list = new ArrayList<>();
                HashMap<String,Integer> map = new HashMap<>();
                for (int i = 0; i < listen + see; i++) {
			        String name = br.readLine();
                    if (i < listen) {
                        map.put(name,1);
                    } 
                    else {
                        map.put(name,map.getOrDefault(name,0)+1);
                        if(map.get(name)==2){
                            list.add(name);
                        }
                    }
		        }

                Collections.sort(list);
                System.out.println(list.size());
                for(int k=0;k<list.size();k++){
                    System.out.println(list.get(k));
                }
                
            }catch(IOException e){
                e.printStackTrace();
                e.getMessage();
            }
        }
}