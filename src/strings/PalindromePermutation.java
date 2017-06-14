package strings;

import java.util.HashSet;
import java.util.*;

public class PalindromePermutation {

	public static TreeSet<String> ts = new TreeSet<>();

	public static void permute(String begin, String end) {
		// Set hs=new TreeSet();

		if (end.length() <= 1) {
			String out = begin + end;
			String rev = new StringBuffer(out).reverse().toString();
			if (out.equals(rev)) {
				ts.add(rev);
			}
		} else {
			for (int i = 0; i < end.length(); i++) {
				String newstring = end.substring(0, i) + end.substring(i + 1);
				permute(begin + end.charAt(i), newstring);
			}
		}

	}

	public static void main(String[] args) {
		// palindrome permutation of a string
		String str = "madam";
		permute("", str);
		Iterator it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
