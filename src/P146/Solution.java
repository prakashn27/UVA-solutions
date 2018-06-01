package P146;
/*
Name: prakashn27
Date: 5/31/2018
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
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    private String getNext(String cur) {
        int N = cur.length();
        // check for input "ffcabbde"
        for (int i = N-2; i >= 0 ; i--) {
            if (cur.charAt(i) < cur.charAt(i+1)) {
                // found the decrement
                for (int j = N-1; j >= 0; j--) {
                    if (cur.charAt(j) > cur.charAt(i)) {
                        return cur.substring(0,i)
                                +cur.charAt(j)
                                +reverse(cur.substring(j+1))
                                +cur.charAt(i)
                                + reverse(cur.substring(i+1,j));
                    }
                }
            }
        }
        return "No Successor";
    }

    public Main(boolean debugMode) throws IOException {
        InputStream in = System.in;
        PrintWriter out = new PrintWriter(System.out);
        if (debugMode) {
            in = Files.newInputStream(Paths.get("D:\\Github\\UVA-solutions\\__in.txt"));
        }

        try (Scanner sc = new Scanner(in)) {
            while(true) {
                String cur = sc.next();
                if (cur.equals("#")) break;
                out.println(getNext(cur));
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