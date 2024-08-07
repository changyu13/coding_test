import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class Bus implements Comparable<Bus> {
    int arrive, weight;

    public Bus(int arrive, int weight) {
        this.arrive = arrive;
        this.weight = weight;
    }


    @Override
    public int compareTo(Bus b) {
        return weight - b.weight;
    }
}

public class Main {
    static ArrayList<Bus>[] busMap;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int cityNum;
        int busNum;
        int f_idx, s_idx, start, end, tempV;
        int w;
        int min = 1234567890;
        int shortestV = 10;
        boolean tf;
        String s;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cityNum = Integer.parseInt(br.readLine());
        busNum = Integer.parseInt(br.readLine());
        busMap = new ArrayList[cityNum + 1];
        visited = new boolean[cityNum + 1];

        for (int i = 0; i < cityNum + 1; i++) {
            busMap[i] = new ArrayList<>();
        }
        for (int i = 0; i < busNum; i++) {
            s = br.readLine();
            f_idx = s.indexOf(" ");
            start = Integer.parseInt(s.substring(0, f_idx));
            s_idx = s.substring(f_idx + 1, s.length()).indexOf(" ") + f_idx + 1;
            end = Integer.parseInt(s.substring(f_idx + 1, s_idx));
            w = Integer.parseInt(s.substring(s_idx + 1, s.length()));
            busMap[start].add(new Bus(end, w));
        }
        s = br.readLine();
        f_idx = s.indexOf(" ");
        start = Integer.parseInt(s.substring(0, f_idx));
        ;
        end = Integer.parseInt(s.substring(f_idx + 1, s.length()));

        System.out.println(dijkstra(start,end));
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Bus> que = new PriorityQueue<>();
        que.offer(new Bus(start, 0));

        while (!que.isEmpty()) {
            Bus currBus = que.poll();
            int currNode = currBus.arrive;

            if (!visited[currNode]) {
                visited[currNode] = true;

                for (Bus b : busMap[currNode]) {
                    if (!visited[b.arrive]) {
                        int nextCost = currBus.weight + b.weight;
                        que.offer(new Bus(b.arrive, nextCost));
                    }
                }
            }
            if(currBus.arrive==end){
                return currBus.weight;
            }
        }
        return 0;
    }
}
