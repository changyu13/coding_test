import java.io.*;

public class Main {
    private static String[][] sorted;
    public static void merge_sort(String[][] a,int num){
        sorted = new String[num][3];
        merge_sort(a,0,num-1);
        sorted = null;
    }
    private static void merge_sort(String[][] a,int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(a,left,mid);
        merge_sort(a,mid+1,right);
        merge(a,left,mid,right);
    }
    private static void merge(String[][] a,int left, int mid, int right){
            int l =left;
            int r = mid+1;
            int index = left;
            while(l<= mid && r<= right){
                if(Integer.parseInt(a[l][0])<Integer.parseInt(a[r][0])){
                    sorted[index][0]=a[l][0];
                    sorted[index][1]=a[l][1];
                    l++;
                    index++;
                }
                //여기서부터 수정
                else if(Integer.parseInt(a[l][0])==Integer.parseInt(a[r][0])){
                    if(Integer.parseInt(a[l][2])>Integer.parseInt(a[r][2])){
                        sorted[index][0]=a[r][0];
                        sorted[index][1]=a[r][1];
                        r++;
                        index++;                         
                    }
                    else{
                        sorted[index][0]=a[l][0];
                        sorted[index][1]=a[l][1];
                        l++;
                        index++;
                    }
                }
                else{
                    sorted[index][0]=a[r][0];
                    sorted[index][1]=a[r][1];
                    r++;
                    index++;
                }
            }
            if(l>mid){
                while(r<=right){
                    sorted[index][0]=a[r][0];
                    sorted[index][1]=a[r][1];
                    r++;
                    index++;
                }
            }
            else{
                while(l<=mid){
                    sorted[index][0]=a[l][0];
                    sorted[index][1]=a[l][1];
                    l++;
                    index++;
                }
            }
            for(int i=left; i<=right;i++){
                a[i][0]=sorted[i][0];
                a[i][1]=sorted[i][1];
            }
    }
    public static void main(String[] args) {
            try{      
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                String [][] list= new String[num][3];
                String [] spl  = new String[2];
                for(int i=0;i<num;i++){
                    spl=br.readLine().split(" ");
                    list[i][0]=spl[0];
                    list[i][1]=spl[1];
                    list[i][2]=Integer.toString(i);
                }
                merge_sort(list,num);
                for(int i=0;i<num;i++){
                    System.out.println(list[i][0]+" "+list[i][1]);
                }
                
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }    
        }
}