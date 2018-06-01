package P11286;
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
                int n = sc.nextInt();
                if (n == 0) break;
                int res = 0;
                HashMap<String,Integer> mCourses = new HashMap<>();
                int max = 0, students = 0;
                for (int i = 0; i < n; i++) {
                    LinkedList<Integer>  courNum = new LinkedList<>();
                    for (int j = 0; j < 5; j++) {
                        courNum.add(sc.nextInt());
                    }
                    Collections.sort(courNum);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < 5; j++) {
                        sb.append(Integer.toString(courNum.removeFirst()));
                    }
                    mCourses.put(sb.toString(), mCourses.getOrDefault(sb.toString(), 0)+1);
                    int count = mCourses.get(sb.toString());
                    if(count>max)
                    {
                        max = count;
                        students = count;
                    }
                    else
                    if(count==max)
                        students += count;
                }

                out.println(students);
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