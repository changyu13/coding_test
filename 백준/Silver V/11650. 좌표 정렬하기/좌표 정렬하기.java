import java.io.*;

public class Main {

    private static int[][] sorted;
    public static void merge_sort(int[][] a,int num){
        sorted = new int[num][2];
        merge_sort(a,num,0,num-1);
        sorted = null;
    }
    private static void merge_sort(int[][] a,int num, int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(a,num,left,mid);
        merge_sort(a,num,mid+1,right);
        merge(a,num,left,mid,right);
    }
    private static void merge(int[][] a,int num,int left, int mid, int right){
            int l =left;
            int r = mid+1;
            int index = left;
            while(l<= mid && r<= right){
                if(a[l][0]<a[r][0]){
                    sorted[index][0]=a[l][0];
                    sorted[index][1]=a[l][1];
                    l++;
                    index++;
                }
                else if(a[l][0]==a[r][0]){
                    if(a[l][1]<=a[r][1]){
                        sorted[index][0]=a[l][0];
                        sorted[index][1]=a[l][1];
                        l++;
                        index++;
                    }
                    else{
                        sorted[index][0]=a[r][0];
                        sorted[index][1]=a[r][1];
                        r++;
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
                String [][] coor = new String [num][2];
                int [][] coor_num = new int [num][2];
                for(int i=0;i<num;i++){
                    coor[i] = br.readLine().split(" ");
                    coor_num[i][0]= Integer.parseInt(coor[i][0]);
                    coor_num[i][1]= Integer.parseInt(coor[i][1]);
                }
                merge_sort(coor_num,num);
                for(int i=0;i<num;i++){
                    System.out.println(coor_num[i][0]+" "+coor_num[i][1]);
                }
                 
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
}