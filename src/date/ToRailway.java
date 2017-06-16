package date;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ToRailway {

    static String timeConversion(String s) throws ParseException {
        SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = inFormat.parse(s);
        s = outFormat.format(date);
        return s;
    }

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
