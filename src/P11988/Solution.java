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
                LinkedList<String> res = new LinkedList<>();
                StringBuilder temp = new StringBuilder();
                boolean addLast = true;
                for(Character ch : line.toCharArray()) {
                    if (ch == '[' || ch == ']') {
                        if (addLast) {
                            res.addLast(temp.toString());
                        } else {
                            res.addFirst(temp.toString());
                        }
                        temp = new StringBuilder();
                        addLast = (ch == '[' ? false : true);
                    }
                    else {
                        temp.append(ch);
                    }
//                    if (ch == '[') {
//                        addLast = false;
//                        continue;
//                    }
//                    if (ch == ']') {
//                        addLast = true;
//                        continue;
//                    }
//                    if (addLast) {
//                        res.addLast(Character.toString(ch));
//                    } else {
//                        res.addFirst(Character.toString(ch));
//                    }
                }
                if (addLast) {
                    res.addLast(temp.toString());
                } else {
                    res.addFirst(temp.toString());
                }
                System.out.println(res.stream().reduce("", (x,y) -> x+y));
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

