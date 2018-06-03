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
        int MAXN = 1000001;
        try (Scanner sc = new Scanner(in)) {
            while (true) {
                int n = sc.nextInt(), m = sc.nextInt();
                if (n == 0 && m == 0) break;
                int[][] values = new int[n+m][3];
                BitSet res = new BitSet(MAXN);
                Boolean conflict = false;
                for (int i = 0; i < n; i++) {
                    int start = sc.nextInt(), end = sc.nextInt();
                    values[i][0] = start;
                    values[i][1] = end;
                }
                for (int i = n; i < n+m; i++) {
                    int start = sc.nextInt(), end = sc.nextInt(), interval = sc.nextInt();
                    values[i][0] = start;
                    values[i][1] = end;
                    values[i][2] = interval;
                }
                for (int i = 0; i < n && !conflict; i++) {
                    int a = values[i][0];
                    int b = values[i][1];
                    for (int j = a; j < b; j++) {
                        if (res.get(j)) {
                            conflict = true;
                            break;
                        }
                        res.set(j);
                    }
                }
                if (!conflict) {
                    for (int i = n; i < n + m; i++) {
                        int a = values[i][0];
                        int b = values[i][1];
                        int c = values[i][2];
                        while (a < 1000001) {
                            for (int j = a; j < b && j < 1000001; j++) {
                                if (res.get(j)) {
                                    conflict = true;
                                    break;
                                }
                                res.set(j);
                            }
                            a += c;
                            b += c;
                        }
                    }
                }
                if (conflict) {
                    out.println("CONFLICT");
                } else {
                    out.println("NO CONFLICT");
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

