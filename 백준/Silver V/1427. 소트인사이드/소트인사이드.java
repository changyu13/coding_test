import java.util.Scanner;
import java.io.*;

public class Main {
    //백준 2751
    private static int[] sorted;
    public static void merge_sort(int[] a){
        sorted = new int[a.length];
        merge_sort(a,0,a.length-1);
        sorted = null;
    }
    private static void merge_sort(int[] a, int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(a,left,mid);
        merge_sort(a,mid+1,right);
        merge(a,left,mid,right);
    }
    private static void merge(int[] a,int left, int mid, int right){
            int l =left;
            int r = mid+1;
            int index = left;
            while(l<= mid && r<= right){
                if(a[l]>=a[r]){
                    sorted[index]=a[l];
                    l++;
                    index++;
                }
                else{
                    sorted[index]=a[r];
                    r++;
                    index++;
                }
            }
            if(l>mid){
                while(r<=right){
                    sorted[index]=a[r];
                    r++;
                    index++;
                }
            }
            else{
                while(l<=mid){
                    sorted[index]=a[l];
                    l++;
                    index++;
                }
            }
        for(int i=left; i<=right;i++){
            a[i]=sorted[i];
        }
    }
    
    public static void main(String[] args) {

            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String user = br.readLine();
                int [] list = new int[user.length()];
                for(int i=0; i<user.length();i++){
                    list[i] = Character.getNumericValue(user.charAt(i));
                }
                merge_sort(list);
                for(int i=0; i<user.length();i++){
                     System.out.print(list[i]);   
                }
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
}