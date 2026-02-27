import java.io.*;
import java.util.*;

class Store {
	int x;
	int y;
	int distances;

	public Store(int x, int y, int distances) {
		this.x = x;
		this.y = y;
		this.distances = distances;
	}

	public int getDistances() {
		return distances;
	}

	public void setDistances(int distances) {
		this.distances = distances;
	}

}

class House {
	int x;
	int y;
	int distances;

	public House(int x, int y, int distances) {
		super();
		this.x = x;
		this.y = y;
		this.distances = distances;
	}

	public int getDistances() {
		return distances;
	}

	public void setDistances(int distances) {
		this.distances = distances;
	}

}

public class Main {
	static int n, m, store_cnt, house_cnt;
	static int[][] city;
	static boolean[][] visited;
	static ArrayList<Store> Stores;
	static ArrayList<House> Houses;
	static Store[] com;
	static int MIN;
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n][n];
		city = new int[n][n];
		Stores = new ArrayList<>();
		Houses = new ArrayList<>();
		com = new Store[m];
		MIN = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				int get = sc.nextInt();
				city[i][k] = get;
				if (get == 1) {
					House house = new House(i, k, 0);
					Houses.add(house);
					house_cnt++;
				}
				if (get == 2) {
					Store store = new Store(i, k, 0);
					Stores.add(store);
					store_cnt++;
				}
			}
		}
		
		selectStore(0, 0);
		System.out.println(MIN);
	}

	static void selectStore(int idx, int tidx) {
		if (tidx == m) {
			int result = calculateStoreDiff();
			MIN = Math.min(result, MIN);
			return;
		}
		if (idx >= store_cnt) {
			return;
		}
		com[tidx] = Stores.get(idx);
		selectStore(idx + 1, tidx + 1);
		selectStore(idx + 1, tidx);
	}

	static int calculateStoreDiff() {
	    int total = 0;

	    for (House h : Houses) {
	        int houseDistance = Integer.MAX_VALUE; 
	        for (int i = 0; i < m; i++) {
	            Store s = com[i];	            
	            int distance = Math.abs(h.x - s.x) + Math.abs(h.y - s.y);	            
	            houseDistance = Math.min(houseDistance, distance); 
	        }
	        total += houseDistance;
	    }
	    return total; 
	}
}