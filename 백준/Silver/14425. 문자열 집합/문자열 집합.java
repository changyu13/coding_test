import java.util.Arrays;
import java.io.*;

public class Main {
    static boolean binarySearch(String [] list, int start, int end, String value){
        if(start>end){
            return false;
        }
        int mid = (start+end)/2;
        if(list[mid].equals(value)){
            return true;
        }
        else if(list[mid].charAt(0)>value.charAt(0)){
            return binarySearch(list,start,mid-1,value);
        }
        else if(list[mid].charAt(0)==value.charAt(0)){
            if(list[mid].contains(value)||value.contains(list[mid])){
                if(binarySearch(list,start,mid-1,value)==true||binarySearch(list,mid+1,end,value)==true){
                    return true;
                }
                else{
                    return false;
                }
            }
            int c=0;
            int judge=0;
            while(true){
                c++;
                if(list[mid].charAt(c)>value.charAt(c)){
                    judge=1;
                    break;
                }
                else if(list[mid].charAt(c)<value.charAt(c)){
                    judge=2;
                    break;
                }
            }
            if(judge==1){
                return binarySearch(list,start,mid-1,value);
            }
            else if(judge==2){
                 return binarySearch(list,mid+1,end,value);
            }
        }
        else{
            return binarySearch(list,mid+1,end,value);
        }
        return false;
    }
    public static void main(String[] args) {

            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String [] test = new String[2];
                
                test = br.readLine().split(" ");
                int n = Integer.parseInt(test[0]);
                int m = Integer.parseInt(test[1]);
                int count = 0;
                String comp;
                String[] s = new String[n];
                for(int i=0;i<n;i++){
                    s[i]=br.readLine();
                }
                Arrays.sort(s);
                for(int j=0;j<m;j++){
                    comp= br.readLine();
                    if(binarySearch(s,0,n-1,comp)==true){
                        count++;
                    }
                }
                System.out.println(count);
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        
        }
}