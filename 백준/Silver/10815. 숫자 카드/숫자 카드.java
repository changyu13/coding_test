import java.util.Arrays;
import java.io.*;

public class Main {

    static boolean binarySearch(int [] list,int start, int end, int value){
        if(start>end){
            return false;
        }
        int mid = (start+end)/2;
        if(list[mid]==value){
            return true;
        }
        else if(value<list[mid]){
            return binarySearch(list,start,mid-1,value);
        }
        else{
            return binarySearch(list,mid+1,end,value);
        }
    }
    public static void main(String[] args) {
        

            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int user = Integer.parseInt(br.readLine());
                String [] list_s = new String[user];
                int [] list = new int[user];
                list_s = br.readLine().split(" ");
                for(int i=0;i<user;i++){
                    list[i]=Integer.parseInt(list_s[i]);
                }
                //리스트 오름차순 정렬
                Arrays.sort(list);
                int num = Integer.parseInt(br.readLine());
                String [] list_c = new String[num];
                list_c = br.readLine().split(" ");
                for(int i=0;i<num;i++){
                    if(binarySearch(list,0,user-1,Integer.parseInt(list_c[i]))==true){
                        list_c[i]="1";
                    }
                    else{
                        list_c[i]="0";
                    }
                }
                for(int i=0;i<num;i++){
                    System.out.print(list_c[i]+" ");
                }
                
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
}