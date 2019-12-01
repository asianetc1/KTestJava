package k.programming.test.file;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBinaryFileReadWrite {

	static String fileIn = "C:/testfile/test1.txt";
	static String fileOut = "C:/testfile/test1out.txt";
	static FileInputStream fileinputstream;
	static FileOutputStream fileoutputstream;

	public static void main(String[] Args) throws IOException {
		readFileByte(fileIn);
		readFileByte16(fileIn);	//16진수
		writeFileByte16();
	}

	
	public static void readFileByte16(String fileIn) throws FileNotFoundException, IOException {
		fileinputstream = new FileInputStream(fileIn);
		int byteSize = fileinputstream.available();
		byte content[] = new byte[byteSize];
		fileinputstream.read(content);
		for (int i = 0; i < byteSize; i++) {
			System.out.format("%02X ", content[i]);
		}
		fileinputstream.close();
		System.out.println("k>TestBinaryFileReadWrite.writeFileByte16 - read end:");	//t+++
	}
	
	
	public static void writeFileByte16() throws FileNotFoundException, IOException {
		fileoutputstream = new FileOutputStream(fileOut);
		for (byte i = 0; i < 10; i++) {
			fileoutputstream.write(i);
		}
		fileoutputstream.close();
		System.out.println("k>TestBinaryFileReadWrite.writeFileByte16 - write end:");	//t+++
	}
	
	
	public static void readFileByte(String fileIn) throws FileNotFoundException, IOException {
		fileinputstream = new FileInputStream(fileIn);
		int byteSize = fileinputstream.available();
		byte content[] = new byte[byteSize];
		fileinputstream.read(content);
		for (int i = 0; i < byteSize; i++) {
			System.out.print(content[i] + " "); // t+++
		}
		System.out.print("\n"); 
	}

}
