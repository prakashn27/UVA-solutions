package P11926;
/*
Name: prakashn27
Date: 6/2/2018
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
        int MAXN = 1000000;
        try (Scanner sc = new Scanner(in)) {
            while (true) {
                int n = sc.nextInt(), m = sc.nextInt();
                if (n == 0 && m == 0) break;
                BitSet main = new BitSet(MAXN);
                Boolean done = false;
                for (int i = 0; i < n; i++) {
                    int start = sc.nextInt(), end = sc.nextInt();
                    if (done) continue;
                    BitSet cur = new BitSet();
                    cur.set(start, end);
                    if (main.intersects(cur)) {
                        out.println("CONFLICT");
                        done = true;
                    }
                    main.or(cur);
                }
                for (int i = 0; i < m; i++) {
                    int start = sc.nextInt(), end = sc.nextInt(), interval = sc.nextInt();
                    if (done) continue;
                    BitSet cur = new BitSet();
                    for (int j = start, jend = end; j < MAXN; j += interval, jend += interval) {
                        if (jend > MAXN) jend = MAXN;
                        cur.set(j, jend);
                    }
                    if (main.intersects(cur)) {
                        out.println("CONFLICT");
                        done = true;
                    }
                    main.or(cur);
                }
                if (done) continue;

                out.println("NO CONFLICT");
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

