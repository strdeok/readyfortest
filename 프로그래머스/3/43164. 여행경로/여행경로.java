import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> routes;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routes = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(routes);
        return routes.get(0).split(" ");
    }

    public static void dfs(String now, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(now) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}