import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class State implements Comparable<State> {
    int arrive;
    int weight;
    int count;

    public State(int arrive, int weight, int count) {
        this.arrive = arrive;
        this.weight = weight;
        this.count = count;
    }

    @Override
    public int compareTo(State s) {
        if (count - s.count != 0) {
            return count - s.count;
        }
        return weight - s.weight;
    }
}

class Edge {
    int arrive;
    int weight;

    public Edge(int arrive, int weight) {
        this.arrive = arrive;
        this.weight = weight;
    }
}

public class Main {
    static ArrayList<Edge>[] subwayMap;
    static boolean visited[];
    static int company[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int stationNum = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int curr;
        subwayMap = new ArrayList[stationNum + 1];
        visited = new boolean[stationNum + 1];
        company = new int[stationNum + 1];

        for (int i = 1; i <= stationNum; i++) {
            subwayMap[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= stationNum; i++) {
            s = br.readLine();
            company[i] = Integer.parseInt(s);
        }

        for (int i = 1; i <= stationNum; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 1; j <= stationNum; j++) {
                curr = Integer.parseInt(st.nextToken());
                if (curr != 0) {
                    subwayMap[i].add(new Edge(j, curr));
                }
            }
        }

        dijkstra(1,end+1);

    }

    public static void dijkstra(int start,int end) {
        PriorityQueue<State> que = new PriorityQueue<>();
        que.offer(new State(start, 0, 0));

        while (!que.isEmpty()) {
            State currSubway = que.poll();
            int currNode = currSubway.arrive;
            if(currNode==end){
                System.out.println(currSubway.count+" "+currSubway.weight);
                break;
            }

            if (!visited[currNode]) {
                visited[currNode] = true;

                for (Edge e : subwayMap[currNode]) {
                    if (!visited[e.arrive]) {
                        int nextCost = currSubway.weight + e.weight;
                        if(company[currNode]!=company[e.arrive]){
                            que.offer(new State(e.arrive, nextCost, currSubway.count +1));
                        }else{
                            que.offer(new State(e.arrive, nextCost,currSubway.count));
                        }
                    }
                }
            }
        }
    }

}