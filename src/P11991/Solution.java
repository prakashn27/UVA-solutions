package P11991;
/*
Name: prakashn27
Date: 6/3/2018
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        try {
            new Main(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Main {
    public Main(boolean debugMode) throws IOException {
        InputStream in = System.in;
        PrintWriter out = new PrintWriter(System.out);
        if (debugMode) {
            in = Files.newInputStream(Paths.get("D:\\Github\\UVA-solutions\\__in.txt"));
        }

        try (Scanner sc = new Scanner(in)) {
            while(sc.hasNext()) {
                int n  = sc.nextInt(), m = sc.nextInt();
//                int[] arr = new int[n+1];
                ArrayList[] graph = (ArrayList[]) new ArrayList[1_000_000];
                for (int v = 0; v < 1_000_000; v++) {
                    graph[v] = new ArrayList();
                }
                for (int i = 0; i < n; i++) {
//                    arr[i+1] = sc.nextInt();
                    graph[sc.nextInt()].add(i+1);
                }
                for (int i = 0; i < m; i++) {
                    int k = sc.nextInt(), v = sc.nextInt();
                    ArrayList cur = graph[v];
                    if (k == 0 || cur.size() < k) {
                        out.println(0);
                        continue;
                    }
                    out.println(graph[v].get(k-1));
                }
            }
        }
        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        try {
            new Main(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

