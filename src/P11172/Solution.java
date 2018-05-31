package P11172;
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
    private static String getRelation(int a, int b) {
        if (a > b) {
            return ">";
        }
        if (b > a) {
            return "<";
        }
        return "=";
    }

    public Main(boolean debugMode) throws IOException {

        InputStream in = System.in;

        if (debugMode) {
            in = Files.newInputStream(Paths.get("C:\\Users\\pnatarajan02\\Documents\\github\\UVA\\__in.txt"));
        }

        try (Scanner sc = new Scanner(in)) {

            int testsCount = sc.nextInt();

            for (int i = 0; i < testsCount && sc.hasNext(); ++i) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(getRelation(a, b));
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Main(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}