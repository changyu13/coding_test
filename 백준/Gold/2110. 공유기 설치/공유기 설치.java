import java.io.*;
public class Main{
     public static int [] sorted;
    public static int [] house;
    public static void mergeSort(int left,int right){
        if(left==right){
            return;
        }
        int mid= (left+right)/2;
        mergeSort(left,mid);
        mergeSort(mid+1,right);
        Merge(left,mid,right);
    }
    public static void Merge(int left,int mid, int right){
        int l=left;
        int idx=left;
        int r=mid+1;
        while(l<=mid&&r<=right){
            if(house[l]<=house[r]){
                sorted[idx]=house[l];
                l++;
                idx++;
            }
            else{
                sorted[idx]=house[r];
                r++;
                idx++;
            }
        }
        if(l>mid){
            while(r<=right){
                    sorted[idx]=house[r];
                    r++;
                    idx++;
                }
        }
        else{
                while(l<=mid){
                    sorted[idx]=house[l];
                    l++;
                    idx++;
                }
        }
        for(int i=left;i<=right;i++){
            house[i]=sorted[i];
        }
    } 
    public static void main(String[] args){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int index = s.indexOf(" ");
                int n = Integer.parseInt(s.substring(0,index));
                int c = Integer.parseInt(s.substring(index+1,s.length()));
                int sum=0;
                house = new int[n];
                sorted= new int[n];
                
                for(int i=0;i<n;i++){
                    house[i]=Integer.parseInt(br.readLine());
                }
                // 집들의 좌표를 저장한 배열 house를 합병정렬로 정렬한다.
                mergeSort(0,n-1);
                int low = 1; // 집 들 사이의 최소 간격
                int high = house[n-1];  // 집들의 최대 간격
                
                while(low<=high){
                    int mid = (low+high)/2; // 최소거리 설정
                    int pos = 0;
                    int cnt = 1;
                    for(int i=0;i<n;i++){
                        if(house[i]-house[pos]>=mid){
                            pos = i;
                            cnt += 1;
                        }
                    }
                    if(cnt<c){
                        high = mid-1; //해당 최소거리일때 설치한 공유기의 수가 설치되어야 하는 공유기의 수보다 적을 때
                    }
                    else{
                        low = mid+1; // 해당 최소거리일때 설치한 공유기의 수가 설치되어야 하는 공유기의 수보다 많을 때
                                     // 또는 같을 때
                    }
                }
                System.out.println(low-1);
                
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }
}