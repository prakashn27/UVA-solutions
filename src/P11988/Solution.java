package P11988;
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

        try (Scanner sc = new Scanner(in)) {

            while (sc.hasNext()) {
                String line = sc.next();
                LinkedList<Character> res = new LinkedList<>();
                int location = 0;
                for(Character ch : line.toCharArray()) {
                    if (ch == '[') {
                        location = 0;
                    }
                    else if (ch == ']'){
                        location = res.size();
                    }
                    else {
                        res.add(location++, ch);
                    }
                }
                StringBuilder sb=new StringBuilder();
                for (char c : res) sb.append(c);
                System.out.println(sb.toString());
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

