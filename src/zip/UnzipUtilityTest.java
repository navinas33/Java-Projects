package zip;

/**
 * A console application that tests the UnzipUtility class
 *
 * @author www.codejava.net
 *
 */
public class UnzipUtilityTest {

	public static void main(String[] args) {
		System.out.println("1");
		String zipFilePath = "F:/as.rar";
		String destDirectory = "F:/asdf";
		System.out.println("2");
		UnzipUtility unzipper = new UnzipUtility();
		
		System.out.println("3");
		try {
			System.out.println("4");
			unzipper.unzip(zipFilePath, destDirectory);
			System.out.println("5");
		} catch (Exception ex) {
			// some errors occurred
			System.out.println("ERROR 1");
			ex.printStackTrace();
		}
	}

}
