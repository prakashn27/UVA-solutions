package P11572;
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

            int testsCount = sc.nextInt();
            for (int i = 0; i < testsCount && sc.hasNext(); ++i) {
                int count = sc.nextInt();
                HashMap<Integer, Integer> map = new HashMap<>();
                int start = 0, res = 0;
                for (int j = 0; j < count; j++) {
                    int cur = sc.nextInt();
                    if (map.containsKey(cur)) {
                        if(map.get(cur) >= start)
                            start = map.get(cur) + 1;
                        map.put(cur, j);
                    } else {
                        map.put(cur, j);
                    }
                    res = Math.max(res, j - start + 1);
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