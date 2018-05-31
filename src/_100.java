import java.io.*;
import java.util.*;

class _100 {
    static String ReadLn(int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String(lin, 0, lg));
    }

    public static void main(String args[])  // entry point from OS
    {
        _100 myWork = new _100();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin() {
        String input;
        StringTokenizer idata;
        int a, b;

        while ((input = _100.ReadLn(255)) != null) {
            idata = new StringTokenizer(input);
            a = Integer.parseInt(idata.nextToken());
            b = Integer.parseInt(idata.nextToken());

            System.out.println(a+":"+b);
        }
    }
}