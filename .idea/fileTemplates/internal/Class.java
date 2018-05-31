#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

/*
Name: prakashn27
Date: ${DATE}
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
class ${Name} {
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
                int a = sc.nextInt();
                int b = sc.nextInt();
                out.println(a + ":" + b);
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