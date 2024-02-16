import java.io.*;

public class Main {
    private static String[] sorted;
    public static void merge_sort(String[] a,int num){
        sorted = new String[num];
        merge_sort(a,num,0,num-1);
        sorted = null;
    }
    private static void merge_sort(String[] a, int num,int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(a,num,left,mid);
        merge_sort(a,num,mid+1,right);
        merge(a,left,mid,right);
    }
    private static void merge(String[] a,int left, int mid, int right){
            int l =left;
            int r = mid+1;
            int index = left;
            while(l<= mid && r<= right){
                if(a[l].length()<a[r].length()){
                    sorted[index]=a[l];
                    l++;
                    index++;
                }
                else if(a[l].length()==a[r].length()){
                    int i=0;
                    while(true){
                        if(a[l].charAt(i)-a[r].charAt(i)!=0){
                            break;
                        }
                        i++;
                    }
                    if(a[l].charAt(i)-a[r].charAt(i)>0){
                        sorted[index]=a[r];
                        r++;
                        index++;
                    }
                    else{
                        sorted[index]=a[l];
                        l++;
                        index++;
                    }
                    
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
                int num = Integer.parseInt(br.readLine());
                String [] sort_list = new String[num];
                int c =0;
                boolean tf = true;
                for(int j=0; j<num;j++){
                    String s = br.readLine();
                    tf=true;
                    for(int i=0; i<c; i++){
                        if(sort_list[i].equals(s)==true){
                            tf=false;
                            break;
                        }
                    }
                    if(tf==true){
                        sort_list[c]=s;
                        c++;
                    }
                }
                merge_sort(sort_list,c);
                for(int j=0; j<c;j++){
                    System.out.println(sort_list[j]);
                }
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
}