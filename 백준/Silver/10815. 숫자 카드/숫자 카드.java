import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static boolean binarySearch(int [] list, int start, int end, int value){
        int mid = (start+end)/2;
        if(start>end){
            return false;
        }
        if(list[mid]==value){
            return true;
        }
        else if(value<list[mid]){
            return binarySearch(list,start,mid-1,value);
        }
        else {
            return binarySearch(list, mid + 1, end, value);
        }
    }
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            String [] list_s = new String[num];
            int [] list = new int[num];
            list_s = br.readLine().split(" ");
            for(int i=0;i<num; i++){
                list[i]= Integer.parseInt(list_s[i]);
            }
            Arrays.sort(list);
            num = Integer.parseInt(br.readLine());
            String [] output = new String[num];
            output = br.readLine().split(" ");
            for(int i=0; i<num;i++){
                if(binarySearch(list,0,list.length-1,Integer.parseInt(output[i]))==true){
                    output[i]="1";
                }
                else{
                    output[i]="0";
                }
            }
            for(int i=0; i<num;i++){
                System.out.print(output[i]+" ");
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}