import java.io.*;
public class Main{
    public static int [][] sorted;
    public static int [][] schedule;
    public static void mergeSort(int left,int right){
        if(left==right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(left,mid);
        mergeSort(mid+1,right);
        merge(left,mid,right);
    }
    public static void merge(int left,int mid,int right){
        int l = left;
        int r = mid+1;
        int idx=left;
        while(l<=mid && r<= right){
            if(schedule[l][1]<schedule[r][1]){
                sorted[idx][0]=schedule[l][0];
                sorted[idx][1]=schedule[l][1];
                idx++;
                l++;  
            }
            else if (schedule[l][1]==schedule[r][1]){
                if(schedule[l][0]<= schedule[r][0]){
                    sorted[idx][0]=schedule[l][0];
                    sorted[idx][1]=schedule[l][1];
                    idx++;
                    l++;
                }
                else{
                    sorted[idx][0]=schedule[r][0];
                    sorted[idx][1]=schedule[r][1];
                    idx++;
                    r++;
                }
            }
            else{
                sorted[idx][0]=schedule[r][0];
                sorted[idx][1]=schedule[r][1];
                idx++;
                r++;  
            }
        }
        if(l>mid){
            while(r<=right){
                    sorted[idx][0]=schedule[r][0];
                    sorted[idx][1]=schedule[r][1];
                    idx++;
                    r++;  
            }
        }
        else{
            while(l<=mid){
                sorted[idx][0]=schedule[l][0];
                sorted[idx][1]=schedule[l][1];
                idx++;
                l++; 
            }
        }
        for(int i=left;i<=right;i++){
            schedule[i][0]= sorted[i][0];
            schedule[i][1]= sorted[i][1];
        }
    }
    
    public static void main(String[] args){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                String s;
                int index=0;
                int end=0;
                int cnt=0;
                boolean is_plus= false;
                schedule = new int[num][2];
                sorted = new int[num][2];
                for(int i=0;i<num;i++){
                    s=br.readLine();
                    index=s.indexOf(" ");
                    schedule[i][0]= Integer.parseInt(s.substring(0,index));
                    schedule[i][1]= Integer.parseInt(s.substring(index+1,s.length()));
                }
                mergeSort(0,num-1);
                for(int i=0;i<num;i++){
                    if(end<=schedule[i][0]){
                        end=schedule[i][1];
                        cnt++;
                    }
                }
                System.out.println(cnt);
            }
            catch(IOException e){
                e.getMessage();
                e.printStackTrace();
            }
    }
}