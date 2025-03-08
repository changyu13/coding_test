import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] sorted;
    public static void merge_sort(int[] a, int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(a,left,mid);
        merge_sort(a,mid+1,right);
        merge(a,left,mid,right);
    }
    public static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int index = left;
        while (l <= mid && r <= right) {
            if (a[l] >= a[r]) {
                sorted[index] = a[l];
                l++;
                index++;
            } else {
                sorted[index] = a[r];
                r++;
                index++;
            }
        }
        if (l > mid) {
            while (r <= right) {
                sorted[index] = a[r];
                r++;
                index++;
            }
        } else {
            while (l <= mid) {
                sorted[index] = a[l];
                l++;
                index++;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String s = br.readLine();
        int n = s.length();
        sorted = new int[n];
        int [] list = new int[n];;
        for(int i=0; i<n; i++){
            list[i] = Character.getNumericValue(s.charAt(i));
        }
        merge_sort(list,0,s.length()-1);
        for(int i=0; i<n; i++) {
            System.out.print(list[i]);
        }
    }
}