import java.util.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
/*2
5
Yeehaw
NSM
Dont Ask
B9
Googol
10
Yeehaw
Yeehaw
Googol
B9
Googol
NSM
B9
NSM
Dont Ask
Googol*/
public class Universe {
	static Scanner sc = new Scanner(System.in);
	public static void main1(String[] args){
		int n = Integer.parseInt(sc.nextLine());
		for(int id = 1; id <= n; id++){
			int s = Integer.parseInt(sc.nextLine());
			String[] engines = new String[s];
			for(int i = 0; i < s; i++) engines[i] = sc.nextLine();
			int q = Integer.parseInt(sc.nextLine());
			String[] queries = new String[q];
			for(int i = 0; i < q; i++) queries[i] = sc.nextLine();
			int[][] table = new int[q + 1][s];
			for(int i = 1; i <= q; i++) Arrays.fill(table[i], Integer.MAX_VALUE);
			for(int i = 0; i < q; i++){
				for(int j = 0; j < s; j++){
					if(table[i][j] < Integer.MAX_VALUE){
						for(int k = 0; k < s; k++){
							if(!queries[i].equals(engines[k])){
								table[i + 1][k] = Math.min(table[i][j] + (j == k ? 0 : 1) , table[i + 1][k]);
							}
						}
					}
				}
			}
			int res = Integer.MAX_VALUE;
			for(int j = 0; j < s; j++){
				res = Math.min(table[q][j], res);
			}
			if(res == Integer.MAX_VALUE) throw new RuntimeException();
			System.out.printf("Case #%d: %d%n", id, res);
		}
	}
}


class A {
	public static void main(String[] args) {
		new A().run();
	}
	int INF = 1 << 29;
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int t = 1; t <= n; t++) {
			int m = sc.nextInt();
			sc.nextLine();
			String[] ss = new String[m];
			for (int i = 0; i < m; i++) ss[i] = sc.nextLine();
			int q = sc.nextInt();
			sc.nextLine();
			String[] ts = new String[q];
			for (int i = 0; i < q; i++) ts[i] = sc.nextLine();
			int[] dp = new int[m];
			for (String s : ts) {
				int min = minAll(dp);
				for (int i = 0; i < m; i++) {
					if (ss[i].equals(s)) dp[i] = INF;
					else dp[i] = Math.min(dp[i], min + 1);
				}
			}
			System.out.printf("Case #%d: %d%n", t, minAll(dp));
		}
	}
	int minAll(int...is) {
		int res = is[0];
		for (int i = 1; i < is.length; i++) {
			if (res > is[i]) res = is[i];
		}
		return res;
	}

}