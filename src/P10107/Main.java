package P10107;
/*
Name: prakashn27
Date: 5/31/2018
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Main {
    public Main(boolean debugMode) throws IOException {
        InputStream in = System.in;
        PrintWriter out = new PrintWriter(System.out);
        if (debugMode) {
            in = Files.newInputStream(Paths.get("D:\\Github\\UVA-solutions\\__in.txt"));
        }

        try (Scanner sc = new Scanner(in)) {
            ArrayList<Integer> arr = new ArrayList<>();
            while(sc.hasNext()) {
               int cur = sc.nextInt();
               arr.add(cur);
               Collections.sort(arr);
               int N = arr.size();
               if (N % 2 == 1) {
                   out.println(arr.get(N/2));
               } else {
                   out.println((arr.get(N/2)+arr.get((N-1)/2))/2);
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

class Solution {
    public static void main(String[] args) {
        try {
            new Main(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}