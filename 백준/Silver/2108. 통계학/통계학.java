import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main{
    public static ArrayList<Integer> al;
    public static void mergeSort(ArrayList<Integer> a){
        al = new ArrayList<Integer>(Collections.nCopies(a.size(),0));
        mergeSort(a,0,a.size()-1);
        al.clear();
    }
    public static void mergeSort(ArrayList<Integer> a,int left,int right){
        if(left==right) return;
        int mid = (left+right)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);
    }
    public static void merge(ArrayList<Integer> a, int left,int mid, int right){
        int l = left;
        int r = mid+1;
        int idx = left;
        while(l<= mid && r<=right){
            if(a.get(l)<=a.get(r)){
                al.set(idx,a.get(l));
                l++;
                idx++;
            }
            else{
                al.set(idx,a.get(r));
                r++;
                idx++;
            }
        }
        if(l>mid){
            while(r<=right){
                al.set(idx,a.get(r));
                r++;
                idx++;
            }
        }
        else{
            while(l<=mid){
                al.set(idx,a.get(l));
                l++;
                idx++;
            }
        }
        for(int i=left;i<=right;i++){
            a.set(i,al.get(i));
        }
    }
    public static void main(String[] args){
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(br.readLine());
                long sum =0;
                int max=0;
                int minus=0;
                int count_s = 0;
                int camp = 0;
                ArrayList<Integer> list = new ArrayList<>();
                HashMap<Integer,Integer> map = new HashMap<>();
                ArrayList<Integer> least = new ArrayList<>();
                for(int i=0; i<num; i++){
                    int k = Integer.parseInt(br.readLine());
                    sum += k;
                    list.add(k);
                }
                mergeSort(list);
                for(int j=0;j<num;j++){
                    int l =list.get(j);
                    map.put(l,map.getOrDefault(l,0)+1);
                }
                for(Integer key: map.keySet()){
                    if(max==map.get(key)){
                        least.add(key);
                        camp=key;
                        count_s++;
                    }
                    else if(max<map.get(key)){
                        count_s=1;
                        least=new ArrayList<Integer>(); 
                        least.add(key);
                        max= map.get(key);
                        camp=key;
                    }
                }
                mergeSort(least);
                minus = list.get(list.size()-1)-list.get(0);
                double average = (double)sum/list.size();
                System.out.println((int)Math.round(average));
                System.out.println((int)list.get(list.size()/2));
                int test=0;
                if(count_s>=2){
                    System.out.println(least.get(1));
                    /*
                    int count =0;
                    if(least.get(0)==least.get(1)){
                        
                    }
                    while(true){
                        if (camp ==least.get(test)){
                            test++;
                            continue;
                        }
                        else{
                            camp=least.get(test);
                            test++;
                            count++;
                        }
                        if(count==2){
                            break;
                        }
                    }
                    System.out.println(camp);
                    */
                }
                else{
                    System.out.println(least.get(0));
                }
                System.out.println(minus);
            }catch(IOException e){
                e.getMessage();
                e.printStackTrace();
            }
    }
}