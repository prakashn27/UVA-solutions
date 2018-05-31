package P10038;
/*
Name: prakashn27
Date: 5/31/2018
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
class Main {
    private String check(LinkedList<Integer> order) {
        for (int i = 1; i <= order.size(); i++) {
            if (order.indexOf(i) != i-1) return "Not jolly";
        }
        return "Jolly";
    }
    public Main(boolean debugMode) throws IOException {
        InputStream in = System.in;
        PrintWriter out = new PrintWriter(System.out);
        if (debugMode) {
            in = Files.newInputStream(Paths.get("C:\\Users\\pnatarajan02\\Documents\\github\\UVA\\__in.txt"));
        }

        try (Scanner sc = new Scanner(in)) {
            while(sc.hasNext()) {
                int n = sc.nextInt();
                LinkedList<Integer> items = new LinkedList<>();
                LinkedList<Integer> order = new LinkedList<>();
                for (int i = 0; i < n && sc.hasNext(); i++) {
                    int cur = sc.nextInt();
                    if (items.size() > 0) {
                        order.push(Math.abs(cur - items.peekLast()));
                    }
                    items.addLast(cur);
                }
                Collections.sort(order);
                out.println(check(order));
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