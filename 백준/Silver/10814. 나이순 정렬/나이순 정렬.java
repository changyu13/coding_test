import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String [][] sorted;
    public static void merge_sort(String [][] a, int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(a,left,mid);
        merge_sort(a,mid+1,right);
        merge(a,left,mid,right);
    }
    public static void merge(String[][] a, int left, int mid, int right){
        int l = left;
        int r= mid+1;
        int index = left;
        while(l<= mid && r <= right){
            if(Integer.parseInt(a[l][0])<= Integer.parseInt(a[r][0])){
                sorted[index][0] = a[l][0];
                sorted[index][1] = a[l][1];
                l++;
                index++;
            }
            else{
                sorted[index][0] = a[r][0];
                sorted[index][1] = a[r][1];
                r++;
                index++;
            }
        }
        if(l>mid){
            while (r <= right) {
                sorted[index][0] = a[r][0];
                sorted[index][1] = a[r][1];
                r++;
                index++;
            }
        }else {
            while(l<=mid){
                sorted[index][0] = a[l][0];
                sorted[index][1] = a[l][1];
                l++;
                index++;
            }
        }
        for(int i=left; i<=right; i++){
            a[i][0]= sorted[i][0];
            a[i][1]= sorted[i][1];
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[][] list  = new String[n][2];
            sorted = new String[n][2];
            for(int i=0; i<n; i++){
                String s = br.readLine();
                list[i] = s.split(" ");
            }
            merge_sort(list,0,n-1);
            for(int i=0; i<n;i++){
                System.out.println(list[i][0]+" "+list[i][1]);
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}