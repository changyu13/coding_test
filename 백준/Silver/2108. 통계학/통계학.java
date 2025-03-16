import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static ArrayList<Integer> sorted;
    public static void mergeSort(ArrayList<Integer> list, int left, int right){
        if(left==right) return;
        int mid = (left+right)/2;
        mergeSort(list,left,mid);
        mergeSort(list,mid+1,right);
        merge(list,left,mid,right);
    }
    public static void merge(ArrayList<Integer> list, int left, int mid, int right){
        int l = left;
        int r= mid+1;
        int index = left;
        while(l <= mid && r <= right){
            if(list.get(l)<=list.get(r)){
                sorted.set(index,list.get(l));
                l++;
                index++;
            }
            else{
                sorted.set(index,list.get(r));
                r++;
                index++;
            }
        }
        if(l>mid){
            while(r<=right){
                sorted.set(index, list.get(r));
                r++;
                index++;
            }
        }else{
            while(l<=mid){
                sorted.set(index, list.get(l));
                l++;
                index++;
            }
        }
        for(int i = left; i<=right; i++){
            list.set(i,sorted.get(i));
        }
    }
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            int now;
            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> mode_list = new ArrayList<>();
            for(int i=0; i<num; i++){
                now = Integer.parseInt(br.readLine());
                list.add(now);
                map.put(now,map.getOrDefault(now,0)+1);
                sum += now;
            }

            sorted = new ArrayList<>(Collections.nCopies(list.size(),0));
            mergeSort(list,0,num-1);
            sorted.clear();

            //최빈값 찾기
            int mode=0;
            for(Integer n : map.keySet()){
                if(map.get(n)>mode){
                    mode_list= new ArrayList<>();
                    mode = map.get(n);
                    mode_list.add(n);
                }else if(map.get(n)==mode){
                    mode_list.add(n);
                }
            }
            System.out.println(Math.round((double)sum/num));
            System.out.println(list.get(list.size()/2));
            if(mode_list.size()==1){
                System.out.println(mode_list.get(0));
            }else{
                sorted = new ArrayList<>(Collections.nCopies(mode_list.size(),0));
                mergeSort(mode_list,0,mode_list.size()-1);
                System.out.println(mode_list.get(1));
            }
            System.out.println(list.get(list.size()-1)-list.get(0));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}