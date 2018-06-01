package P11849;
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
                int N = sc.nextInt(), M = sc.nextInt();
                if (N == 0 && M == 0) break;
                int res = 0;
                Set<Integer> setN = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    setN.add(sc.nextInt());
                }
                for (int i = 0; i < M; i++) {
                    int cur = sc.nextInt();
                    if (setN.contains(cur)) res++;
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