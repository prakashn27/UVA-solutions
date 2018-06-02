package P10954;
/*
Name: prakashn27
Date: 6/1/2018
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
            in = Files.newInputStream(Paths.get("C:\\Users\\pnatarajan02\\Documents\\github\\UVA\\__in.txt"));
        }

        try (Scanner sc = new Scanner(in)) {
            while (true) {
                int n = sc.nextInt();
                if (n == 0) break;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int i = 0; i < n; i++) {
                    pq.add(sc.nextInt());
                }
                int res = 0;
                while (pq.size() > 1) {
                    int a = pq.poll(), b = pq.poll();
                    int cur = a+b;
                    res += cur;
                    pq.add(cur);
                }
                out.println(res);
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