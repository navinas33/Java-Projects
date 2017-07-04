package strings;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.*;
import java.nio.charset.*;

public class LogicalString {

    public static String fileName="G:\\test2.txt";
    public static FileOutputStream outputStream;
    public static byte[] strToBytes;
    //public static byte[] strToBytes = str.getBytes();
    //outputStream.write(strToBytes);

    public static void permute(String begin, String end) throws IOException {
        if(end.length() <= 1) {
            strToBytes=(begin+end).getBytes();
            outputStream.write(strToBytes);
            outputStream.write('\n');
			System.out.println(begin+end);

		} else {
			for(int i = 0; i < end.length(); i++) {
				String newstring=end.substring(0, i)+end.substring(i+1);
				permute(begin+end.charAt(i),newstring);
			}
		}
    }

	public static void main(String[] args) throws IOException {
		String str = "abcdefghijk";
		String ret;
        outputStream = new FileOutputStream(fileName);

        permute("", str);
        outputStream.close();

	}
}
