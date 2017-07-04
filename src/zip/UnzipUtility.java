package zip;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This utility extracts files and directories of a standard zip file to
 * a destination directory.
 * @author www.codejava.net
 *
 */
public class UnzipUtility {
	/**
	 * Size of the buffer to read/write data
	 */
	private static final int BUFFER_SIZE = 4096;

	/**
	 * Extracts a zip file specified by the zipFilePath to a directory specified by
	 * destDirectory (will be created if does not exists)
	 * @param zipFilePath
	 * @param destDirectory
	 * @throws IOException
	 */
	public void unzip(String zipFilePath, String destDirectory) throws IOException {
		System.out.println("6");
		File destDir = new File(destDirectory);
		System.out.println("7");
		if (!destDir.exists()) {
			System.out.println("8");
			destDir.mkdir();
			System.out.println("9");
		}
		
		System.out.println("10");
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));

		System.out.println("11");
		ZipEntry entry = zipIn.getNextEntry();

		System.out.println("Zip IN :"+zipIn);
		
		System.out.println("12");
		System.out.println("ENTRY :"+entry);
		// iterates over entries in the zip file
		while (entry != null) {
			System.out.println("13");
			String filePath = destDirectory + File.separator + entry.getName();
			System.out.println("14");
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				System.out.println("15");
				extractFile(zipIn, filePath);
				System.out.println("16");
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath);
				dir.mkdir();
			}
			zipIn.closeEntry();
			System.out.println("17");
			entry = zipIn.getNextEntry();
			System.out.println("18");
		}
		zipIn.close();
	}

	/**
	 * Extracts a zip entry (file entry)
	 * @param zipIn
	 * @param filePath
	 * @throws IOException
	 */
	private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		System.out.println("19");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		System.out.println("20");
		byte[] bytesIn = new byte[BUFFER_SIZE];
		System.out.println("21");
		int read = 0;
		System.out.println("sdf");
		while ((read = zipIn.read(bytesIn)) != -1) {
			System.out.println("1");
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}
}
